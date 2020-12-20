package com.babe.services;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Map;

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
}
