package com.babe.util;

import com.babe.beans.Payload;
import com.babe.framework.DefaultDirectoryManager;
import com.babe.skeletons.ModelPackageManager;
import com.babe.skeletons.PackageManager;
import com.google.gson.Gson;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class VelocityWriter {

    static String modelName = "User";
    static String packageName = "com.companyname.projectname";

    public static void main(String[] args) throws IOException {

        String projectName = "babe";

        String payLoadJson = "{\n" +
                "\t\"projectName\": \"babe\",\n" +
                "\t\"isSpringBoot\": \"yes\",\n" +
                "\t\"backEndDB\": \"mysql\",\n" +
                "\t\"tableName\": \"customer\",\n" +
                "\t\"tableSchemaNeeded\": true,\n" +
                "\t\"isJpa\": true,\n" +
                "\t\"fieldDetails\": [{\n" +
                "\t\t\t\"fieldName\": \"id\",\n" +
                "\t\t\t\"fieldType\": \"int\",\n" +
                "\t\t\t\"isCustomType\": false,\n" +
                "\t\t\t\"isIdentity\": true\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"fieldName\": \"firstName\",\n" +
                "\t\t\t\"fieldType\": \"String\",\n" +
                "\t\t\t\"isCustomType\": false,\n" +
                "\t\t\t\"isIdentity\": false\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"fieldName\": \"lastName\",\n" +
                "\t\t\t\"fieldType\": \"String\",\n" +
                "\t\t\t\"isCustomType\": false,\n" +
                "\t\t\t\"isIdentity\": false\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"fieldName\": \"dob\",\n" +
                "\t\t\t\"fieldType\": \"LocalDate\",\n" +
                "\t\t\t\"isCustomType\": true,\n" +
                "\t\t\t\"isIdentity\": false\n" +
                "\t\t}\n" +
                "\t]\n" +
                "\n" +
                "}";

        // Creating a Gson Object
        Gson gson = new Gson();

        Payload payload
                = gson.fromJson(payLoadJson,
                Payload.class);

        File tempDirectory = new File(System.getProperty("java.io.tmpdir"));
        File fileWithRelativePath = new File(tempDirectory, "newFile.txt");

        Map<String, Object> globals = new HashMap<>();
        globals.put("packageName",packageName);
        globals.put("modelName",modelName);
        globals.put("projectName",payload.getProjectName());
        VelocityEngine velocityEngine = new VelocityEngine();
        Properties p = new Properties();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init(p);

        DefaultDirectoryManager dm = new DefaultDirectoryManager();
        dm.createDefaultDirectory(payload.getProjectName(),"");

        PackageManager model = new ModelPackageManager();
        model.buildPackageContexts(globals,payload.getFieldDetails());
        model.constructPackageContents(velocityEngine);
        model.generatePackageFiles(globals);

        System.out.println("aaa");

    }
}
