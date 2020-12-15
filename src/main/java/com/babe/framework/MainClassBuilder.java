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
                            + File.separator + "models" + File.separator
                            + repoClass.getClassName() + PortalConstants.JAVA_EXTENSION);
            FileUtils.touch(myfile);

            try (FileOutputStream fis = new FileOutputStream(myfile))
            {
                fis.write(writer.toString().getBytes(Charset.defaultCharset()));
            }
        }
    }
}
