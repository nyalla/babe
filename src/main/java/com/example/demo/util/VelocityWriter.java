package com.example.demo.util;

import com.example.demo.beans.Field;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class VelocityWriter {

    static String modelName = "User";
    static String packageName = "com.companyname.projectname";

    public static void main(String[] args) {
        VelocityEngine velocityEngine = new VelocityEngine();
        Properties p = new Properties();
        p.setProperty("resource.loader", "class");
        p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        velocityEngine.init(p);

        Template t = velocityEngine.getTemplate("vtemplates/class.vm");

        VelocityContext context = new VelocityContext();

        if(packageName != null) {
            context.put("packagename", packageName);
        }

        List<Field> properties = new ArrayList<Field>();
        properties.add(new Field("id", "int","Id"));
        properties.add(new Field("firstName", "String","FirstName"));
        properties.add(new Field("lastName", "String","LastName"));
        properties.add(new Field("dob", "LocalDate","Dob"));
        context.put("className", modelName);
        context.put("properties", properties);

        StringWriter writer = new StringWriter();
        t.merge( context, writer );

        System.out.println(writer.toString());
    }
}
