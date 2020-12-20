package com.babe.framework;


import java.io.File;
import java.util.Map;

import static com.babe.constants.PortalConstants.*;

public class ProjectPathResolver
{
    public static String pathGetter(Map<String, Object> globals, String fileName, String classPackage, boolean isMain)
    {
        if (isMain)
        {
            String packageFolder = classPackage.isEmpty() ? "" : classPackage + File.separator;
            return
                    BASE_PATH + globals.get("projectName") + SRC_TO_COM + globals.get("appName")
                            + File.separator + packageFolder
                            + fileName;
        }
        else
        {
            return
                    BASE_PATH + globals.get("projectName") + SRC_TO_MAIN + File.separator + "resources"
                            + File.separator + fileName;
        }
    }

    public static String buildPathGetter(Map<String, Object> globals, String fileName)
    {
        return
                BASE_PATH + globals.get("projectName") + File.separator
                        + File.separator + fileName;
    }
}
