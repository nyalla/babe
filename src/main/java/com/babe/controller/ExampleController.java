package com.babe.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.babe.util.BinaryOutputWrapper;
import com.babe.util.FileUtil;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class ExampleController
{

    @Autowired
    FileUtil fileUtil;

    @GetMapping("/aaa")
    public ResponseEntity<?> generatePDF()
    {
        BinaryOutputWrapper output = new BinaryOutputWrapper();
        try
        {
            output = fileUtil.pack("E:\\trash\\babe", "");
        } catch (IOException e)
        {
            e.printStackTrace();
            //Do something when exception is thrown
        }
        return new ResponseEntity<>(output.getData(), output.getHeaders(), HttpStatus.OK);
    }


    @PostMapping(path = "/trigger", consumes = "application/json", produces = "application/zip")
    public void trigger(HttpServletResponse response, @RequestBody String json) throws IOException
    {
        System.out.println("asa");
        //setting headers
        response.setStatus(HttpServletResponse.SC_OK);
        response.addHeader("Content-Disposition", "attachment; filename=\"11111.zip\"");

        ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());

        // create a list to add files to be zipped
        ArrayList<File> files = new ArrayList<>(2);
        files.add(new File("READMEnew.md"));

        // package files
        for (File file : files)
        {
            //new zip entry and copying inputstream with file to zipOutputStream, after all closing streams
            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
            FileInputStream fileInputStream = new FileInputStream(file);

            IOUtils.copy(fileInputStream, zipOutputStream);

            fileInputStream.close();
            zipOutputStream.closeEntry();
        }

        zipOutputStream.close();

    }

    @GetMapping(value = "/zip", produces = "application/zip")
    public void zipFiles(HttpServletResponse response) throws IOException
    {

        //setting headers
        response.setStatus(HttpServletResponse.SC_OK);
        response.addHeader("Content-Disposition", "attachment; filename=\"22222.zip\"");

        ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());

        // create a list to add files to be zipped
        ArrayList<File> files = new ArrayList<>(2);
        files.add(new File("README.md"));

        // package files
        for (File file : files)
        {
            //new zip entry and copying inputstream with file to zipOutputStream, after all closing streams
            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
            FileInputStream fileInputStream = new FileInputStream(file);

            IOUtils.copy(fileInputStream, zipOutputStream);

            fileInputStream.close();
            zipOutputStream.closeEntry();
        }

        zipOutputStream.close();
    }


}