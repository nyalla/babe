package com.babe.framework;

import java.util.ArrayList;
import java.util.List;

public class FieldPrototype
{
    private String name;
    private String type;
    private List<String> annotation = new ArrayList<>();
    private boolean increment;
    private String getterAndSetterField;

    public FieldPrototype(String name, String type, List<String> annotation, boolean increment)
    {
        this.name = name;
        this.type = type;
        this.annotation = annotation;
        this.increment = increment;
    }

    public FieldPrototype(String name, String type)
    {
        this.name = name;
        this.type = type;
    }

    public FieldPrototype()
    {

    }

    public String getGetterAndSetterField()
    {
        return getterAndSetterField;
    }

    public void setGetterAndSetterField(String getterAndSetterField)
    {
        this.getterAndSetterField = getterAndSetterField;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public List<String> getAnnotation()
    {
        return annotation;
    }

    public void setAnnotation(List<String> annotation)
    {
        this.annotation = annotation;
    }

    public boolean isIncrement()
    {
        return increment;
    }

    public void setIncrement(boolean increment)
    {
        this.increment = increment;
    }
}
