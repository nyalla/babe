package com.babe.beans;

public class FieldDetails {
    private String name;
    private String type;
    private boolean customType;
    private boolean identity;

    public FieldDetails(String name, String type, boolean customType, boolean identity) {
        this.name = name;
        this.type = type;
        this.customType = customType;
        this.identity = identity;
    }

    public FieldDetails() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isCustomType() {
        return customType;
    }

    public void setCustomType(boolean customType) {
        this.customType = customType;
    }

    public boolean isIdentity() {
        return identity;
    }

    public void setIdentity(boolean identity) {
        this.identity = identity;
    }
}
