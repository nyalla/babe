package com.babe.services;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

import static com.babe.constants.PortalConstants.*;

@Service
public class DefaultDirectoryManager
{

    public void createDefaultDirectory(String projectName, String appName)
    {
        File source = new File(PROJECT_FILE_STRUCTURE);
        File dest = new File(BASE_PATH + projectName);
        try
        {
            FileUtils.copyDirectory(source, dest);

            File sourceFilePath = new File(BASE_PATH + projectName + SRC_TO_COM + "app-name");
            File targetFilePath = new File(BASE_PATH + projectName + SRC_TO_COM + appName);
            sourceFilePath.renameTo(targetFilePath);

            System.out.println("aasa");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
