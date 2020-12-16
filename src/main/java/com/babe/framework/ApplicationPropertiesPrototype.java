package com.babe.framework;

import com.babe.beans.ApplicationProperties;

public class ApplicationPropertiesPrototype
{
    private ApplicationProperties applicationProperties;

    private String vmPath;
    private String fileName;

    public String getVmPath()
    {
        return vmPath;
    }

    public ApplicationPropertiesPrototype(ApplicationProperties applicationProperties)
    {
        this.applicationProperties = applicationProperties;
        this.vmPath = "vtemplates/properties_v1.vm";
        this.fileName = "application.properties";
    }

    public ApplicationProperties getApplicationProperties()
    {
        return applicationProperties;
    }

    public String getFileName()
    {
        return fileName;
    }
}
