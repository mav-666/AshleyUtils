package com.mav6.ashleyUtils.buildingUtils.Placers;

import com.badlogic.gdx.math.Vector2;

/**
 * The interface Placement.
 */
@FunctionalInterface
public interface Placement {

    /**
     * On.
     *
     * @param spot the spot
     */
    void on(Vector2 spot);
}
