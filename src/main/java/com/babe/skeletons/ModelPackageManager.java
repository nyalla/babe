package com.babe.skeletons;

import com.babe.beans.FieldContext;
import com.babe.beans.FieldDetails;
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
import java.util.Map;

public class ModelPackageManager implements PackageManager {

    private VelocityContext context = new VelocityContext();
    private StringWriter writer = new StringWriter();

    @Override
    public void buildPackageContexts(Map<String, Object> globals, List<FieldDetails> fields) {

        context.put("packagename", globals.get("packageName"));
        context.put("className", globals.get("modelName"));
        List<FieldContext> properties = new ArrayList<FieldContext>();

        for (FieldDetails fd : fields) {
            properties.add(new FieldContext(fd.getFieldName(), fd.getFieldType(), fd.getFieldName().substring(0, 1).toUpperCase() + fd.getFieldName().substring(1)));
        }
        context.put("properties", properties);
    }

    @Override
    public void constructPackageContents(VelocityEngine velocityEngine) {
        //Selecting VM file with content and writing context data into it
        Template t = velocityEngine.getTemplate("vtemplates/class.vm");
        t.merge(context, writer);
    }

    @Override
    public void generatePackageFiles(Map<String, Object> globals) throws IOException {
        //Creation files
        File myfile = new File("E:\\" + globals.get("projectName") + "\\src\\main\\java\\com\\app-name\\models\\" + globals.get("modelName") + PortalConstants.JAVA_EXTENSION);
        FileUtils.touch(myfile);

        //Getting path of the file
        Path path = Paths.get("E:\\" + globals.get("projectName") + "\\src\\main\\java\\com\\app-name\\models\\" + globals.get("modelName") + PortalConstants.JAVA_EXTENSION);

        //Injecting data into file
        try (BufferedWriter inject = Files.newBufferedWriter(path)) {
            inject.write(writer.toString());
        }

    }
}
