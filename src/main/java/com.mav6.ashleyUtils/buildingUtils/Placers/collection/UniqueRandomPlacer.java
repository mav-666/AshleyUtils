package com.mav6.ashleyUtils.buildingUtils.Placers.collection;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ObjectSet;
import com.mav6.ashleyUtils.buildingUtils.Placers.Bounds;


import java.util.Random;

/**
 * The type Unique random placer.
 */
public class UniqueRandomPlacer extends RandomPlacer {

    /**
     * The Past spots.
     */
    ObjectSet<Vector2> pastSpots = new ObjectSet<>();

    /**
     * Instantiates a new Unique random placer.
     *
     * @param bounds the bounds
     * @param random the random
     */
    public UniqueRandomPlacer(Bounds bounds, Random random) {
        super(bounds, random);
    }

    @Override
    public Vector2 nextSpot() {
        Vector2 nextSpot = super.nextSpot();
        if(pastSpots.contains(nextSpot))
            return nextSpot();
        pastSpots.add(nextSpot);
        return nextSpot;
    }
}
