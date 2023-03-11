package com.shivam.keyvaluestore.utils;

public class AttributeType {

    public Class getAttributeType(String value) {
        Class type = String.class;
        if(value.matches("^-?\\d+$")) {
            type = Integer.class;
        } else if(value.matches("^-?\\d+\\.\\d+$")) {
            type = Double.class;
        } else if(value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
            type = Boolean.class;
        }
        return type;
    }
}
