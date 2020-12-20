package com.babe.framework;

import java.util.LinkedList;
import java.util.List;

public class ProjectTree
{
    private List<EntityBeanClassPrototype> entityBeansList=new LinkedList<>();
    private List<RepositoryClassProtoType> repositoryList = new LinkedList<>();
    private List<ControllerClassPrototype> controllerList = new LinkedList<>();
    private ApplicationClassPrototype applicationClassPrototype;
    private BuildFilePrototype pom;

    public ProjectTree()
    {
    }

    public ProjectTree(List<EntityBeanClassPrototype> entityBeansList, List<RepositoryClassProtoType> repositoryList, List<ControllerClassPrototype> controllerList, ApplicationClassPrototype applicationClassPrototype, BuildFilePrototype pom)
    {
        this.entityBeansList = entityBeansList;
        this.repositoryList = repositoryList;
        this.controllerList = controllerList;
        this.applicationClassPrototype = applicationClassPrototype;
        this.pom = pom;
    }

    public List<EntityBeanClassPrototype> getEntityBeansList()
    {
        return entityBeansList;
    }

    public void setEntityBeansList(List<EntityBeanClassPrototype> entityBeansList)
    {
        this.entityBeansList = entityBeansList;
    }

    public List<RepositoryClassProtoType> getRepositoryList()
    {
        return repositoryList;
    }

    public void setRepositoryList(List<RepositoryClassProtoType> repositoryList)
    {
        this.repositoryList = repositoryList;
    }

    public List<ControllerClassPrototype> getControllerList()
    {
        return controllerList;
    }

    public void setControllerList(List<ControllerClassPrototype> controllerList)
    {
        this.controllerList = controllerList;
    }

    public ApplicationClassPrototype getApplicationClassPrototype()
    {
        return applicationClassPrototype;
    }

    public void setApplicationClassPrototype(ApplicationClassPrototype applicationClassPrototype)
    {
        this.applicationClassPrototype = applicationClassPrototype;
    }

    public BuildFilePrototype getPom()
    {
        return pom;
    }

    public void setPom(BuildFilePrototype pom)
    {
        this.pom = pom;
    }
}
