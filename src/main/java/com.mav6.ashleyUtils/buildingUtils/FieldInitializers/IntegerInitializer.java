package com.mav6.ashleyUtils.buildingUtils.FieldInitializers;

public class IntegerInitializer extends FieldInitializer<Integer, Integer> {
    @Override
    public Integer getInitBy(Integer config) {
        return config;
    }
}
