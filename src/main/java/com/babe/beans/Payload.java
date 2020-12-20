package com.babe.beans;

import java.util.List;

public class Payload {
private String projectName;
private boolean isSpringBoot;
private String backEndDB;
private String tableName;
private String build;
private boolean tableSchemaNeeded;
private boolean isJpa;
private List<FieldDetails> fieldDetails;
private ApplicationProperties applicationProperties;

    public ApplicationProperties getApplicationProperties()
    {
        return applicationProperties;
    }

    public void setApplicationProperties(ApplicationProperties applicationProperties)
    {
        this.applicationProperties = applicationProperties;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public boolean isSpringBoot() {
        return isSpringBoot;
    }

    public void setSpringBoot(boolean springBoot) {
        isSpringBoot = springBoot;
    }

    public String getBackEndDB() {
        return backEndDB;
    }

    public void setBackEndDB(String backEndDB) {
        this.backEndDB = backEndDB;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public boolean isTableSchemaNeeded() {
        return tableSchemaNeeded;
    }

    public void setTableSchemaNeeded(boolean tableSchemaNeeded) {
        this.tableSchemaNeeded = tableSchemaNeeded;
    }

    public boolean isJpa() {
        return isJpa;
    }

    public void setJpa(boolean jpa) {
        isJpa = jpa;
    }

    public List<FieldDetails> getFieldDetails() {
        return fieldDetails;
    }

    public void setFieldDetails(List<FieldDetails> fieldDetails) {
        this.fieldDetails = fieldDetails;
    }

    public String getBuild()
    {
        return build;
    }

    public void setBuild(String build)
    {
        this.build = build;
    }

    public Payload() {
    }
}
