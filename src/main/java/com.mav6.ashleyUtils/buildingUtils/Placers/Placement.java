package com.mav6.ashleyUtils.buildingUtils.Placers;

import com.badlogic.gdx.math.Vector2;

@FunctionalInterface
public interface Placement {

    void on(Vector2 spot);
}
