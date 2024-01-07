package com.mav6.ashleyUtils.buildingUtils.FieldInitializers.Box2dBodyCreation;

/**
 * The enum Bit category.
 */
public enum BitCategory {
    /**
     * Projectile bit category.
     */
    Projectile((short) 2),
    ;

    /**
     * The Bit.
     */
    public short bit;

    BitCategory(short bit) {
        this.bit = bit;
    }
}
