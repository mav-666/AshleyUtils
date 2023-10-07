package com.mav6.ashleyUtils.buildingUtils.Placers.collection;

import com.badlogic.gdx.math.Vector2;
import com.mav6.ashleyUtils.buildingUtils.Placers.Bounds;
import com.mav6.ashleyUtils.buildingUtils.Placers.LimitedPlacer;
import com.mav6.ashleyUtils.buildingUtils.Placers.Placer;


public class IntPlacer extends LimitedPlacer {

    private final Placer placer;

    public IntPlacer(Bounds bounds, Placer placer) {
        super(bounds);

        this.placer = placer;
    }

    @Override
    public Vector2 nextSpot() {
        Vector2 spot = placer.nextSpot();
        return spot.set((int) spot.x, (int) spot.y);
    }

    @Override
    public boolean hasNext() {
        return placer.hasNext();
    }
}
