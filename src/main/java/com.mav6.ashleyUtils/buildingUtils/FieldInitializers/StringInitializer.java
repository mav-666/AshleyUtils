package com.mav6.ashleyUtils.buildingUtils.FieldInitializers;

public class StringInitializer extends FieldInitializer<String, String> {

    @Override
    public String getInitBy(String config) {
        return config;
    }
}
