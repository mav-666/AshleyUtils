package com.mav6.ashleyUtils.buildingUtils.FieldInitializers;

public class BooleanInitializer extends FieldInitializer<Boolean, Boolean> {

    @Override
    public Boolean getInitBy(Boolean config) {
        return config;
    }
}
