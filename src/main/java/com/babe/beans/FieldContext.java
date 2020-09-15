package com.babe.beans;

public class FieldContext {
    private String fieldName;
    private String fieldType;
    private String getterAndSetterField;


    public FieldContext(String fieldName, String fieldType, String getterAndSetterField) {
        super();
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.getterAndSetterField = getterAndSetterField;
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

    public String getGetterAndSetterField() {
        return getterAndSetterField;
    }

    public void setGetterAndSetterField(String getterAndSetterField) {
        this.getterAndSetterField = getterAndSetterField;
    }
}
