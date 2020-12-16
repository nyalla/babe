package com.babe.beans;

import java.util.Map;

public class ApplicationProperties
{
    private String port;
    private String contextPath;
    private String dataSourceUrl;
    private String dataBaseName;
    private String dataSourceUserName;
    private String getDataSourcePassword;
    Map<String,Object> additional;

    public String getDataBaseName()
    {
        return dataBaseName;
    }

    public void setDataBaseName(String dataBaseName)
    {
        this.dataBaseName = dataBaseName;
    }

    public String getPort()
    {
        return port;
    }

    public void setPort(String port)
    {
        this.port = port;
    }

    public String getContextPath()
    {
        return contextPath;
    }

    public void setContextPath(String contextPath)
    {
        this.contextPath = contextPath;
    }

    public String getDataSourceUrl()
    {
        return dataSourceUrl;
    }

    public void setDataSourceUrl(String dataSourceUrl)
    {
        this.dataSourceUrl = dataSourceUrl;
    }

    public String getDataSourceUserName()
    {
        return dataSourceUserName;
    }

    public void setDataSourceUserName(String dataSourceUserName)
    {
        this.dataSourceUserName = dataSourceUserName;
    }

    public String getGetDataSourcePassword()
    {
        return getDataSourcePassword;
    }

    public void setGetDataSourcePassword(String getDataSourcePassword)
    {
        this.getDataSourcePassword = getDataSourcePassword;
    }

    public Map<String, Object> getAdditional()
    {
        return additional;
    }

    public void setAdditional(Map<String, Object> additional)
    {
        this.additional = additional;
    }
}
