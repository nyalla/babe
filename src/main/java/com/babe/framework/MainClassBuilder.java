package com.babe.framework;

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
import java.util.Map;

import static com.babe.constants.PortalConstants.BASE_PATH;
import static com.babe.constants.PortalConstants.SRC_TO_COM;

public class MainClassBuilder
{
    public void constructClass(ClassPrototype proto, VelocityEngine velocityEngine, Map<String, Object> globals) throws IOException
    {
        VelocityContext context = new VelocityContext();
        StringWriter writer = new StringWriter();
        if (proto instanceof RepositoryClassPrototype)
        {
            RepositoryClassPrototype repoClass = (RepositoryClassPrototype) proto;
            Template t = velocityEngine.getTemplate(repoClass.getVmPath());
            context.put("class", repoClass);
            context.put("packagename", globals.get("packageName"));
            t.merge(context, writer);
            File myfile = new File(
                    BASE_PATH + globals.get("projectName") + SRC_TO_COM + globals.get("appName")
                            + "\\models\\"
                            + repoClass.getClassName() + PortalConstants.JAVA_EXTENSION);
            FileUtils.touch(myfile);

            //Getting path of the file
            Path path = Paths.get(
                    BASE_PATH + globals.get("projectName") + SRC_TO_COM + globals.get("appName")
                            + "\\models\\"
                            + repoClass.getClassName() + PortalConstants.JAVA_EXTENSION);

            //Injecting data into file
            try (BufferedWriter inject = Files.newBufferedWriter(path))
            {
                inject.write(writer.toString());
            }
        }
    }
}
