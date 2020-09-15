package com.babe.framework;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DefaultDirectoryManager {

    public void createDefaultDirectory(String projectName,String appName){
        File source = new File("E:\\projects\\babe\\standard-folder\\project-name");
        File dest = new File("E:\\" + projectName);
        try {
            FileUtils.copyDirectory(source, dest);
            System.out.println("came");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("came");
    }
}
