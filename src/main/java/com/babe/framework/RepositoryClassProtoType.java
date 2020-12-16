package com.babe.framework;

import java.util.Map;

public class RepositoryClassProtoType extends AbstractClassPrototype
{
    public EntityBeanClassPrototype entityBeanClassPrototype;

    public RepositoryClassProtoType(String className, String classCategory, Map<String, Object> globals, EntityBeanClassPrototype bean)
    {
        super(className + "Repository", classCategory);
        this.entityBeanClassPrototype = bean;
        initialContextBuilder(globals);
    }

    @Override
    public void initialContextBuilder(Map<String, Object> globals)
    {
        //Package Name
        classPackage = "repository";
        imports.add("import " + globals.get("packageName") + "." + entityBeanClassPrototype.getClassPackage());
        imports.add("import org.springframework.data.repository.CrudRepository;");
        getVMByCategory("");
    }

    @Override
    public String getVMByCategory(String classCategory)
    {
        // In future it can driven based upon version of the vm file
        setVmPath("vtemplates/repository_v1.vm");
        return "";
    }

    public EntityBeanClassPrototype getEntityBeanClassPrototype()
    {
        return entityBeanClassPrototype;
    }
}
