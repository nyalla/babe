package com.babe.framework;

import com.babe.constants.PortalConstants;

import java.util.Map;

public class BuildFilePrototype extends AbstractClassPrototype
{
    public PortalConstants.BuildType buildType;
    public PortalConstants.DataBases database;
    public boolean jpaEnabled;
    public String springVersion;
    public String javaVersion;

    public BuildFilePrototype(String className, String classCategory, String db, boolean isJpa,Map<String, Object> globals)
    {
        super(className, classCategory);
        database = FrameworkUtil.getDataBase(db);
        buildType = FrameworkUtil.getBuildType(className);
        jpaEnabled = isJpa;
        getVMByCategory(classCategory);
        initialContextBuilder(globals);
    }

    @Override
    public String getVMByCategory(String classCategory)
    {
        if (classCategory.equalsIgnoreCase("maven"))
        {
            className = "pom.xml";
            setVmPath("vtemplates/maven_v1.vm");
        }
        else
        {
            className = "build.gradle";
            setVmPath("vtemplates/gradle_v1.vm");
        }
        return "";
    }

    @Override
    public void initialContextBuilder(Map<String, Object> globals)
    {
        springVersion= "2.2.5.RELEASE";
        javaVersion="1.8";
    }

    public PortalConstants.BuildType getBuildType()
    {
        return buildType;
    }

    public void setBuildType(PortalConstants.BuildType buildType)
    {
        this.buildType = buildType;
    }

    public PortalConstants.DataBases getDatabase()
    {
        return database;
    }

    public void setDatabase(PortalConstants.DataBases database)
    {
        this.database = database;
    }

    public boolean isJpaEnabled()
    {
        return jpaEnabled;
    }

    public void setJpaEnabled(boolean jpaEnabled)
    {
        this.jpaEnabled = jpaEnabled;
    }

    public String getSpringVersion()
    {
        return springVersion;
    }

    public void setSpringVersion(String springVersion)
    {
        this.springVersion = springVersion;
    }

    public String getJavaVersion()
    {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion)
    {
        this.javaVersion = javaVersion;
    }
}
