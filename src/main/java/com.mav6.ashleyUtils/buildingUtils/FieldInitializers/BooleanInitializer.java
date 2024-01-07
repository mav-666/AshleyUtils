package com.mav6.ashleyUtils.buildingUtils.FieldInitializers;

/**
 * The type Boolean initializer.
 */
public class BooleanInitializer extends FieldInitializer<Boolean, Boolean> {

    @Override
    public Boolean getInitBy(Boolean config) {
        return config;
    }
}
