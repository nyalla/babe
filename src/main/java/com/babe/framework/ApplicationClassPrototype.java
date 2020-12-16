package com.babe.framework;

import java.util.Map;

public class ApplicationClassPrototype extends AbstractClassPrototype
{
    public ApplicationClassPrototype(String className, String classCategory, Map<String, Object> globals)
    {
        super(className + "Application", classCategory);
        initialContextBuilder(globals);

    }

    @Override
    public String getVMByCategory(String classCategory)
    {
        // In future it can driven based upon version of the vm file
        setVmPath("vtemplates/application_v1.vm");
        return "";
    }

    @Override
    public void initialContextBuilder(Map<String, Object> globals)
    {
        classPackage = "";
        getVMByCategory("");
    }
}
