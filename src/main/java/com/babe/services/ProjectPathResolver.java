package com.babe.services;


import java.io.File;
import java.util.Map;

import static com.babe.constants.PortalConstants.*;

public class ProjectPathResolver
{
    public static String pathGetter(Map<String, Object> globals, String fileName, String classPackage, boolean isMain)
    {
        String BASE_PATH_TEMP = globals.get("basePath")+File.separator;
        if (isMain)
        {
            String packageFolder = classPackage.isEmpty() ? "" : classPackage + File.separator;
            return
                    BASE_PATH_TEMP + globals.get("projectName") + SRC_TO_COM + globals.get("appName")
                            + File.separator + packageFolder
                            + fileName;
        }
        else
        {
            return
                    BASE_PATH_TEMP + globals.get("projectName") + SRC_TO_MAIN + File.separator + "resources"
                            + File.separator + fileName;
        }
    }

    public static String buildPathGetter(Map<String, Object> globals, String fileName)
    {
        String BASE_PATH_TEMP = globals.get("basePath")+File.separator;
        return
                BASE_PATH_TEMP + globals.get("projectName") + File.separator
                        + File.separator + fileName;
    }
}
