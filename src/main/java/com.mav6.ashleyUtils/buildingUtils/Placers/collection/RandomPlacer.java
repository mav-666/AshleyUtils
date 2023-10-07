package com.mav6.ashleyUtils.buildingUtils.Placers.collection;

import com.badlogic.gdx.math.Vector2;
import com.mav6.ashleyUtils.buildingUtils.Placers.Bounds;
import com.mav6.ashleyUtils.buildingUtils.Placers.LimitedPlacer;


import java.util.Random;

public class RandomPlacer extends LimitedPlacer {

    private final Random random;

    public RandomPlacer(Bounds bounds, Random random) {
        super(bounds);
        this.random = random;
    }

    @Override
    public Vector2 nextSpot() {
        return new Vector2(random.nextFloat() * (bounds.width() - bounds.startX()) +  bounds.startX(),
                random.nextFloat() * (bounds.height() - bounds.startY()) +  bounds.startY());
    }

    @Override
    public boolean hasNext() {
        return true;
    }
}
