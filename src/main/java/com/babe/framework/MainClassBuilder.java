package com.babe.framework;

import com.babe.constants.PortalConstants;
import org.apache.commons.io.FileUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;

import static com.babe.constants.PortalConstants.*;

public class MainClassBuilder
{
    public void constructClass(ClassPrototype proto, VelocityEngine velocityEngine, Map<String, Object> globals)
    {
        VelocityContext context = new VelocityContext();
        context.put("packageName", globals.get("packageName"));
        if (proto instanceof EntityBeanClassPrototype)
        {
            EntityBeanClassPrototype classInstance = (EntityBeanClassPrototype) proto;
            context.put("class", classInstance);
            generateClassFile(velocityEngine, classInstance.getVmPath(), context, globals,
                    classInstance.getClassName() + JAVA_EXTENSION, classInstance.getClassPackage(), true);
        }
        else
            if (proto instanceof RepositoryClassProtoType)
            {
                RepositoryClassProtoType classInstance = (RepositoryClassProtoType) proto;
                context.put("class", classInstance);
                generateClassFile(velocityEngine, classInstance.getVmPath(), context, globals,
                        classInstance.getClassName() + JAVA_EXTENSION, classInstance.getClassPackage(), true);
            }
            else
                if (proto instanceof ControllerClassPrototype)
                {
                    ControllerClassPrototype classInstance = (ControllerClassPrototype) proto;
                    context.put("class", classInstance);
                    generateClassFile(velocityEngine, classInstance.getVmPath(), context, globals,
                            classInstance.getClassName() + JAVA_EXTENSION, classInstance.getClassPackage(), true);
                }
                else
                    if (proto instanceof ApplicationClassPrototype)
                    {
                        ApplicationClassPrototype classInstance = (ApplicationClassPrototype) proto;
                        context.put("class", classInstance);

                        generateClassFile(velocityEngine, classInstance.getVmPath(), context, globals,
                                classInstance.getClassName() + JAVA_EXTENSION, classInstance.getClassPackage(), true);
                    }
    }

    public void constructProperties(ApplicationPropertiesPrototype prop, VelocityEngine velocityEngine, Map<String, Object> globals)
    {
        VelocityContext context = new VelocityContext();
        context.put("class", prop.getApplicationProperties());
        context.put("globals", globals);
        generateClassFile(velocityEngine, prop.getVmPath(), context, globals, prop.getFileName(), "", false);
    }

    public void generateClassFile(VelocityEngine velocityEngine, String vmPath, VelocityContext context, Map<String, Object> globals, String fileName, String classPackage, boolean isSrc)
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
}
