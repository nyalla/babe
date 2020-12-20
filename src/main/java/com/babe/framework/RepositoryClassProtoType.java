package com.babe.framework;

import com.google.common.base.CaseFormat;

import java.util.Map;

public class RepositoryClassProtoType extends AbstractClassPrototype
{
    public EntityBeanClassPrototype entityBeanClassPrototype;

    public RepositoryClassProtoType(String classNameIni, String classCategory, Map<String, Object> globals, EntityBeanClassPrototype bean)
    {
        super(classNameIni + "Repository", classCategory);
        classInstanceName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, className);
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
