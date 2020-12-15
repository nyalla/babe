package com.babe.framework;

import com.babe.constants.PortalConstants;
import org.apache.commons.io.FileUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;

import static com.babe.constants.PortalConstants.BASE_PATH;
import static com.babe.constants.PortalConstants.SRC_TO_COM;

public class MainClassBuilder
{
    public void constructClass(ClassPrototype proto, VelocityEngine velocityEngine, Map<String, Object> globals) throws IOException
    {
        VelocityContext context = new VelocityContext();
        context.put("packageName", globals.get("packageName"));
        if (proto instanceof EntityBeanClassPrototype)
        {
            EntityBeanClassPrototype classInstance = (EntityBeanClassPrototype) proto;
            context.put("class", classInstance);
            generateClassFile(velocityEngine, classInstance.getVmPath(), context, globals, classInstance.getClassName(), classInstance.getClassPackage());
        }
        else
            if (proto instanceof RepositoryClassProtoType)
            {
                RepositoryClassProtoType classInstance = (RepositoryClassProtoType) proto;
                context.put("class", classInstance);
                generateClassFile(velocityEngine, classInstance.getVmPath(), context, globals, classInstance.getClassName(), classInstance.getClassPackage());
            }
            else
                if (proto instanceof ControllerClassPrototype)
                {
                    ControllerClassPrototype classInstance = (ControllerClassPrototype) proto;
                    context.put("class", classInstance);
                    generateClassFile(velocityEngine, classInstance.getVmPath(), context, globals, classInstance.getClassName(), classInstance.getClassPackage());
                }
    }

    public void generateClassFile(VelocityEngine velocityEngine, String vmPath, VelocityContext context, Map<String, Object> globals, String fileName, String classPackage) throws IOException
    {
        StringWriter writer = new StringWriter();
        Template t = velocityEngine.getTemplate(vmPath);

        t.merge(context, writer);

        File myfile = new File(
                BASE_PATH + globals.get("projectName") + SRC_TO_COM + globals.get("appName")
                        + File.separator + classPackage + File.separator
                        + fileName + PortalConstants.JAVA_EXTENSION);
        FileUtils.touch(myfile);

        try (FileOutputStream fis = new FileOutputStream(myfile))
        {
            fis.write(writer.toString().getBytes(Charset.defaultCharset()));
        }
    }
}
