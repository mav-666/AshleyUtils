package com.mav6.ashleyUtils.buildingUtils.Placers.collection;

import com.badlogic.gdx.math.Vector2;
import com.mav6.ashleyUtils.buildingUtils.Placers.Bounds;
import com.mav6.ashleyUtils.buildingUtils.Placers.Placer;


/**
 * The type Test placer.
 */
public class TestPlacer extends Placer {

    private boolean tested = false;

    /**
     * Instantiates a new Test placer.
     *
     * @param bounds the bounds
     */
    public TestPlacer(Bounds bounds) {
        super(bounds);
    }

    @Override
    public Vector2 nextSpot() {
        tested = true;
        return new Vector2(0,1);
    }

    @Override
    public boolean hasNext() {
        return !tested;
    }
}
