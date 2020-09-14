package com.babe.util;

import com.babe.beans.Field;
import com.babe.constants.PortalConstants;
import org.apache.commons.io.FileUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class VelocityWriter {

    static String modelName = "User";
    static String packageName = "com.companyname.projectname";

    public static void main(String[] args) throws IOException {

        String projectName = "babe";
        System.out.println("came");
        File source = new File("E:\\projects\\babe\\standard-folder\\project-name");
        File dest = new File("E:\\" + projectName);
        try {
            FileUtils.copyDirectory(source, dest);
            System.out.println("came");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("came");
        VelocityEngine velocityEngine = new VelocityEngine();
        Properties p = new Properties();
        p.setProperty("resource.loader", "class");
        p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        velocityEngine.init(p);

        Template t = velocityEngine.getTemplate("vtemplates/class.vm");

        VelocityContext context = new VelocityContext();

        if (packageName != null) {
            context.put("packagename", packageName);
        }

        List<Field> properties = new ArrayList<Field>();
        properties.add(new Field("id", "int", "Id"));
        properties.add(new Field("firstName", "String", "FirstName"));
        properties.add(new Field("lastName", "String", "LastName"));
        properties.add(new Field("dob", "LocalDate", "Dob"));
        context.put("className", modelName);
        context.put("properties", properties);

        StringWriter writer = new StringWriter();
        t.merge(context, writer);

        File myfile = new File("E:\\" + projectName + "\\src\\main\\java\\com\\app-name\\models\\" + modelName + PortalConstants.JAVA_EXTENSION);
        FileUtils.touch(myfile);

        Path path = Paths.get("E:\\" + projectName + "\\src\\main\\java\\com\\app-name\\models\\" + modelName + PortalConstants.JAVA_EXTENSION);

        //Use try-with-resource to get auto-closeable writer instance
        try (BufferedWriter inject = Files.newBufferedWriter(path)) {
            inject.write(writer.toString());
        }

        System.out.println(writer.toString());
    }
}
