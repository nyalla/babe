package com.babe.framework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractClassPrototype implements ClassPrototype
{
    public String classPackage;
    public List<String> imports = new LinkedList<>();
    public String className;
    public List<String> classLevelAnnotation = new ArrayList<>();
    public String classCategory;
    public List<FieldPrototype> fields = new ArrayList<>();
    public List<String> autowireClasses = new ArrayList<>();
    public String vmPath;

    public String getVmPath()
    {
        return vmPath;
    }

    public void setVmPath(String vmPath)
    {
        this.vmPath = vmPath;
    }

    public abstract String getVMByCategory(String classCategory);

    public String abstractMethod(String holder)
    {
        return holder;
    }

    public AbstractClassPrototype(String className, String classCategory)
    {
        this.className = className;
        this.classCategory = classCategory;
    }

    public AbstractClassPrototype(List<String> imports, List<String> classLevelAnnotation, List<FieldPrototype> fields, List<String> autowireClasses, String vmPath)
    {
        this.imports = imports;
        this.classLevelAnnotation = classLevelAnnotation;
        this.fields = fields;
        this.autowireClasses = autowireClasses;
        this.vmPath = vmPath;
    }

    public String getClassPackage()
    {
        return classPackage;
    }

    public void setClassPackage(String classPackage)
    {
        this.classPackage = classPackage;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public String getClassCategory()
    {
        return classCategory;
    }

    public void setClassCategory(String classCategory)
    {
        this.classCategory = classCategory;
    }

    public List<FieldPrototype> getFields()
    {
        return fields;
    }

    public void setFields(List<FieldPrototype> fields)
    {
        this.fields = fields;
    }

    public List<String> getImports()
    {
        return imports;
    }

    public void setImports(List<String> imports)
    {
        this.imports = imports;
    }

    public List<String> getClassLevelAnnotation()
    {
        return classLevelAnnotation;
    }

    public void setClassLevelAnnotation(List<String> classLevelAnnotation)
    {
        this.classLevelAnnotation = classLevelAnnotation;
    }

    public List<String> getAutowireClasses()
    {
        return autowireClasses;
    }

    public void setAutowireClasses(List<String> autowireClasses)
    {
        this.autowireClasses = autowireClasses;
    }
}
