package com.babe.services;

import com.babe.beans.Payload;
import com.babe.framework.*;
import com.babe.util.ConvertUtil;
import com.babe.util.FrameworkUtil;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.babe.constants.PortalConstants.BASE_PATH;

@Service
public class ProjectCreationService
{

    @Autowired
    DefaultDirectoryManager defaultDirectoryManager;

    @Autowired
    MainClassBuilder mainClassBuilder;

    @Autowired
    VelocityService velocityService;

    public byte[] createProject(Payload payload)
    {

        ProjectTree project = new ProjectTree();

        Map<String, Object> globals = new HashMap<>();
        globals.put("packageName", "com." + payload.getAppName());
        globals.put("appName", payload.getAppName());
        globals.put("projectName", payload.getProjectName());

        //Default directory creation
        defaultDirectoryManager.createDefaultDirectory(payload.getProjectName(), payload.getAppName());

        //Entity creation class
        EntityBeanClassPrototype entityBean = new EntityBeanClassPrototype(
                ConvertUtil.firstLetterCapital(payload.getTableName()), "", globals);
        entityBean.setClassFields(payload.getFieldDetails());
        project.getEntityBeansList().add(entityBean);

        //Repository creation class
        RepositoryClassProtoType repository = new RepositoryClassProtoType(
                ConvertUtil.firstLetterCapital(payload.getTableName()), "", globals, entityBean);
        project.getRepositoryList().add(repository);

        //Controller creation class
        ControllerClassPrototype controller = new ControllerClassPrototype(
                ConvertUtil.firstLetterCapital(payload.getTableName()), "", globals, repository);
        project.getControllerList().add(controller);

        //Application creation class
        ApplicationClassPrototype application = new ApplicationClassPrototype(
                ConvertUtil.firstLetterCapital(payload.getAppName()), "", globals);
        project.setApplicationClassPrototype(application);

        //Project properties creation class
        ApplicationPropertiesPrototype propertiesPrototype = new ApplicationPropertiesPrototype(payload.getApplicationProperties());

        //Build file creation class
        BuildFilePrototype buildFilePrototype = new BuildFilePrototype(FrameworkUtil.getBuildType(payload.getBuild()).toString(), payload.getBuild(), payload.getBackEndDB(), payload.isJpa(), globals);
        project.setBuildFilePrototype(buildFilePrototype);

        VelocityEngine engine = velocityService.engineGenerator();

        mainClassBuilder.constructClass(entityBean, engine, globals);
        mainClassBuilder.constructClass(repository, engine, globals);
        mainClassBuilder.constructClass(controller, engine, globals);
        mainClassBuilder.constructClass(application, engine, globals);
        mainClassBuilder.constructProperties(propertiesPrototype, engine, globals);
        mainClassBuilder.constructBuildFile(buildFilePrototype, engine, globals);

        String generatedProject = BASE_PATH + globals.get("projectName");

        //Create Zip folder of the project directory
        try
        {
            byte[] byteContent = FileGeneratorService.pack(generatedProject);
            return byteContent;

        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
