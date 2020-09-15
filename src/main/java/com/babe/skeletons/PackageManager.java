package com.babe.skeletons;

import com.babe.beans.FieldDetails;
import org.apache.velocity.app.VelocityEngine;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface PackageManager {
    void buildPackageContexts(Map<String, Object> globals, List<FieldDetails> fields);
    void constructPackageContents(VelocityEngine velocityEngine);
    void generatePackageFiles(Map<String, Object> globals) throws IOException;
}
