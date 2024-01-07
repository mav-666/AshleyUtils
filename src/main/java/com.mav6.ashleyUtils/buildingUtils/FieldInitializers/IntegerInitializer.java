package com.mav6.ashleyUtils.buildingUtils.FieldInitializers;

/**
 * The type Integer initializer.
 */
public class IntegerInitializer extends FieldInitializer<Integer, Integer> {
    @Override
    public Integer getInitBy(Integer config) {
        return config;
    }
}
