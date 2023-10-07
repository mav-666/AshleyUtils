package com.mav6.ashleyUtils.buildingUtils.FieldInitializers.Box2dBodyCreation;

public enum BitCategory {
    Projectile((short) 2),
    ;

    public short bit;

    BitCategory(short bit) {
        this.bit = bit;
    }
}
