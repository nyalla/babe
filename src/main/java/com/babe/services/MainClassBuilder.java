package com.babe.services;

import com.babe.framework.*;
import com.babe.services.FileGeneratorService;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

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
            FileGeneratorService.generate(velocityEngine, classInstance.getVmPath(), context, globals,
                    classInstance.getClassName() + JAVA_EXTENSION, classInstance.getClassPackage(), true);
        }
        else
            if (proto instanceof RepositoryClassProtoType)
            {
                RepositoryClassProtoType classInstance = (RepositoryClassProtoType) proto;
                context.put("class", classInstance);
                FileGeneratorService.generate(velocityEngine, classInstance.getVmPath(), context, globals,
                        classInstance.getClassName() + JAVA_EXTENSION, classInstance.getClassPackage(), true);
            }
            else
                if (proto instanceof ControllerClassPrototype)
                {
                    ControllerClassPrototype classInstance = (ControllerClassPrototype) proto;
                    context.put("class", classInstance);
                    FileGeneratorService.generate(velocityEngine, classInstance.getVmPath(), context, globals,
                            classInstance.getClassName() + JAVA_EXTENSION, classInstance.getClassPackage(), true);
                }
                else
                    if (proto instanceof ApplicationClassPrototype)
                    {
                        ApplicationClassPrototype classInstance = (ApplicationClassPrototype) proto;
                        context.put("class", classInstance);

                        FileGeneratorService.generate(velocityEngine, classInstance.getVmPath(), context, globals,
                                classInstance.getClassName() + JAVA_EXTENSION, classInstance.getClassPackage(), true);
                    }
    }

    public void constructProperties(ApplicationPropertiesPrototype prop, VelocityEngine velocityEngine, Map<String, Object> globals)
    {
        VelocityContext context = new VelocityContext();
        context.put("class", prop.getApplicationProperties());
        context.put("globals", globals);
        FileGeneratorService.generate(velocityEngine, prop.getVmPath(), context, globals, prop.getFileName(), "", false);
    }

    public void constructBuildFile(BuildFilePrototype buildFilePrototype, VelocityEngine velocityEngine, Map<String, Object> globals)
    {
        VelocityContext context = new VelocityContext();
        context.put("class", buildFilePrototype);
        context.put("globals", globals);
        FileGeneratorService.generateBuildFile(velocityEngine, buildFilePrototype.getVmPath(), context, globals, buildFilePrototype.getClassName());
    }
}
