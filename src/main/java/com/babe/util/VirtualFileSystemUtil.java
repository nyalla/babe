package com.babe.util;

import com.google.common.collect.ImmutableList;
import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class VirtualFileSystemUtil {
    public static void main(String[] args) throws IOException {

        FileSystem fs = Jimfs.newFileSystem(Configuration.unix());
        Path foo = fs.getPath("/foo");
        Files.createDirectory(foo);

        Path hello = foo.resolve("hello.txt"); // /foo/hello.txt
        Files.write(hello, ImmutableList.of("hello world"), StandardCharsets.UTF_8);


        if (!Files.isDirectory(foo)) {
            System.out.println("Please provide a folder.");
            return;
        }
        try {
            //Path mainP = Paths.get("E:\\babe");
            VirtualFileSystemUtil.zipFolder(hello);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }

    // zip a directory, including sub files and sub directories
    public static void zipFolder(Path source) throws IOException {

        // get folder name as zip file name
        String zipFileName = "E:\\babe\\Manishi.zip";
        try (
                ZipOutputStream zos = new ZipOutputStream(
                        new FileOutputStream(zipFileName))
        ) {
            Files.walkFileTree(source, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file,
                                                 BasicFileAttributes attributes) {
                    // only copy files, no symbolic links
                    if (attributes.isSymbolicLink()) {
                        return FileVisitResult.CONTINUE;
                    }

                    try (FileInputStream fis = new FileInputStream(file.toFile())) {
                        Path targetFile = source.relativize(file);
                        zos.putNextEntry(new ZipEntry(targetFile.toString()));

                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = fis.read(buffer)) > 0) {
                            zos.write(buffer, 0, len);
                        }
                        // if large file, throws out of memory
                        //byte[] bytes = Files.readAllBytes(file);
                        //zos.write(bytes, 0, bytes.length);
                        zos.closeEntry();
                        System.out.printf("Zip file : %s%n", file);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    System.err.printf("Unable to zip : %s%n%s%n", file, exc);
                    return FileVisitResult.CONTINUE;
                }
            });
        }
    }
}
