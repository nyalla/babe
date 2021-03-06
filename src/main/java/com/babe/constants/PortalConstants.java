package com.babe.constants;

import java.io.File;

public class PortalConstants
{

    public static final String BASE_LOCATION = "/";
    public static final String JAVA_EXTENSION = ".java";
    public static final String BASE_PATH = "E:\\trash" + File.separator;
    public static final String SRC_TO_MAIN = File.separator + "src" + File.separator + "main";
    public static final String SRC_TO_COM =
            SRC_TO_MAIN + File.separator + "java" + File.separator + "com"
                    + File.separator;
    public static final String PROJECT_FILE_STRUCTURE =
            "E:\\projects" + File.separator + "babe" + File.separator + "standard-folder" + File.separator
                    + "project-name";

    public enum DataBases
    {
        MYSQL, SQL, ORACLE, POSTGRES
    }
    public enum BuildType{
        POM,GRADLE
    }
}
