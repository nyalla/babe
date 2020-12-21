package com.babe.services;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Map;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileGeneratorService
{
    public static void generate(VelocityEngine velocityEngine, String vmPath, VelocityContext context, Map<String, Object> globals, String fileName, String classPackage, boolean isSrc)
    {
        try
        {
            StringWriter writer = new StringWriter();
            Template t = velocityEngine.getTemplate(vmPath);

            t.merge(context, writer);

            File myfile = new File(ProjectPathResolver.pathGetter(globals, fileName, classPackage, isSrc));
            FileUtils.touch(myfile);

            try (FileOutputStream fis = new FileOutputStream(myfile))
            {
                fis.write(writer.toString().getBytes(Charset.defaultCharset()));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void generateBuildFile(VelocityEngine velocityEngine, String vmPath, VelocityContext context, Map<String, Object> globals, String fileName)
    {
        try
        {
            StringWriter writer = new StringWriter();
            Template t = velocityEngine.getTemplate(vmPath);
            t.merge(context, writer);
            File myfile = new File(ProjectPathResolver.buildPathGetter(globals, fileName));
            FileUtils.touch(myfile);
            try (FileOutputStream fis = new FileOutputStream(myfile))
            {
                fis.write(writer.toString().getBytes(Charset.defaultCharset()));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // zip a directory, including sub files and sub directories
    public static byte[] pack(String sourceDirPath) throws IOException
    {
        Path pp = Paths.get(sourceDirPath);
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        try (ZipOutputStream zs = new ZipOutputStream(byteOutputStream);
             Stream<Path> paths = Files.walk(pp))
        {
            paths
                    .filter(path -> !Files.isDirectory(path))
                    .forEach(path -> {
                        ZipEntry zipEntry = new ZipEntry(pp.relativize(path).toString());
                        try
                        {
                            zs.putNextEntry(zipEntry);
                            Files.copy(path, zs);
                            zs.closeEntry();
                        } catch (IOException e)
                        {
                            System.err.println(e);
                        }
                    });
        }
        return byteOutputStream.toByteArray();
    }
}
