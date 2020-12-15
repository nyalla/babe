package com.babe.framework;

import com.babe.beans.FieldDetails;

import java.util.List;
import java.util.Map;

public class ControllerClassPrototype extends AbstractClassPrototype
{
    public RepositoryClassProtoType repositoryClassProtoType;
    public EntityBeanClassPrototype entityBeanClassPrototype;

    public ControllerClassPrototype(String className, String classCategory, Map<String, Object> globals, RepositoryClassProtoType repository, EntityBeanClassPrototype entityBean)
    {
        super(className + "Controller", classCategory);
        this.repositoryClassProtoType = repository;
        this.entityBeanClassPrototype = entityBean;
        initialContextBuilder(globals);

    }

    @Override
    public void initialContextBuilder(Map<String, Object> globals)
    {
        //Package Name
        classPackage = "controller";

        imports.add("import " + globals.get("packageName") + "." + entityBeanClassPrototype.getClassPackage() + "."
                + entityBeanClassPrototype.getClassName());
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
    public String setClassFields(List<FieldDetails> fields)
    {
        return null;
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

    public EntityBeanClassPrototype getEntityBeanClassPrototype()
    {
        return entityBeanClassPrototype;
    }

    public void setEntityBeanClassPrototype(EntityBeanClassPrototype entityBeanClassPrototype)
    {
        this.entityBeanClassPrototype = entityBeanClassPrototype;
    }
}
