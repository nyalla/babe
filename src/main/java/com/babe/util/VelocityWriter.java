package com.babe.util;

import com.babe.beans.FieldContext;
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
import java.util.*;

public class VelocityWriter {

    static String modelName = "User";
    static String packageName = "com.companyname.projectname";

    public static void main(String[] args) throws IOException {

        String projectName = "babe";

        Map<String, Object> globals = new HashMap<>();
        globals.put("packageName",packageName);
        globals.put("modelName",modelName);

        VelocityEngine velocityEngine = new VelocityEngine();
        Properties p = new Properties();
        p.setProperty("resource.loader", "class");
        p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        velocityEngine.init(p);

        //Creating tempalte
        Template t = velocityEngine.getTemplate("vtemplates/class.vm");

        //Construction of context properties
        VelocityContext context = new VelocityContext();
        context.put("packagename", packageName);
        List<FieldContext> properties = new ArrayList<FieldContext>();
        properties.add(new FieldContext("id", "int", "Id"));
        properties.add(new FieldContext("firstName", "String", "FirstName"));
        properties.add(new FieldContext("lastName", "String", "LastName"));
        properties.add(new FieldContext("dob", "LocalDate", "Dob"));
        context.put("className", modelName);
        context.put("properties", properties);

        //Preparation of VM file contentn
        StringWriter writer = new StringWriter();
        t.merge(context, writer);

        //Creation files
        File myfile = new File("E:\\" + projectName + "\\src\\main\\java\\com\\app-name\\models\\" + modelName + PortalConstants.JAVA_EXTENSION);
        FileUtils.touch(myfile);

        //Getting path of the file
        Path path = Paths.get("E:\\" + projectName + "\\src\\main\\java\\com\\app-name\\models\\" + modelName + PortalConstants.JAVA_EXTENSION);

        //Injecting data into file
        try (BufferedWriter inject = Files.newBufferedWriter(path)) {
            inject.write(writer.toString());
        }

        System.out.println(writer.toString());
    }
}
