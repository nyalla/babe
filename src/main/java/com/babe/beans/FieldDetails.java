package com.babe.beans;

public class FieldDetails {
    private String fieldName;
    private String fieldType;
    private boolean isCustomType;
    private boolean isIdentity;

    public FieldDetails(String fieldName, String fieldType, boolean isCustomType, boolean isIdentity) {
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.isCustomType = isCustomType;
        this.isIdentity = isIdentity;
    }

    public FieldDetails() {
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public boolean isCustomType() {
        return isCustomType;
    }

    public void setCustomType(boolean customType) {
        this.isCustomType = customType;
    }

    public boolean isIdentity() {
        return isIdentity;
    }

    public void setIdentity(boolean identity) {
        this.isIdentity = identity;
    }
}
