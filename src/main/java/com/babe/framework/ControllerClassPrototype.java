package com.babe.framework;

import java.util.Map;

public class ControllerClassPrototype extends AbstractClassPrototype
{
    public RepositoryClassProtoType repositoryClassProtoType;

    public ControllerClassPrototype(String className, String classCategory, Map<String, Object> globals, RepositoryClassProtoType repository)
    {
        super(className + "Controller", classCategory);
        this.repositoryClassProtoType = repository;
        initialContextBuilder(globals);

    }

    @Override
    public void initialContextBuilder(Map<String, Object> globals)
    {
        //Package Name
        classPackage = "controller";

        imports.add("import " + globals.get("packageName") + "." + repositoryClassProtoType.getEntityBeanClassPrototype().getClassPackage() + "."
                + repositoryClassProtoType.getEntityBeanClassPrototype().getClassName());
        imports.add("import " + globals.get("packageName") + "." + repositoryClassProtoType.getClassPackage() + "."
                + repositoryClassProtoType.getClassName());
        imports.add("import org.springframework.web.bind.annotation.*;");
        imports.add("import org.springframework.http.ResponseEntity;");

        classLevelAnnotation.add("@CrossOrigin(\"*\")");
        classLevelAnnotation.add("@RestController");

        autowireClasses.add(
                repositoryClassProtoType.getClassName() + " " + repositoryClassProtoType.getClassName().toLowerCase());
        getVMByCategory("");

    }

    @Override
    public String getVMByCategory(String classCategory)
    {
        // In future it can driven based upon version of the vm file
        setVmPath("vtemplates/controller_v1.vm");
        return "";
    }

    public RepositoryClassProtoType getRepositoryClassProtoType()
    {
        return repositoryClassProtoType;
    }

    public void setRepositoryClassProtoType(RepositoryClassProtoType repositoryClassProtoType)
    {
        this.repositoryClassProtoType = repositoryClassProtoType;
    }

}
