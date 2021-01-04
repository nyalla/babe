package com.babe.beans;

import java.util.Map;

public class ApplicationProperties
{
    private String port;
    private String contextPath;
    private String dataSourceUrl;
    private String dataBaseName;
    private String username;
    private String password;
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

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
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
