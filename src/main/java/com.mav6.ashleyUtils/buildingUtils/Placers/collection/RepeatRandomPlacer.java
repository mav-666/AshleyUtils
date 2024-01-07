package com.mav6.ashleyUtils.buildingUtils.Placers.collection;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mav6.ashleyUtils.buildingUtils.Placers.Bounds;


import java.util.Random;

/**
 * The type Repeat random placer.
 */
public class RepeatRandomPlacer extends RandomPlacer {

    /**
     * The Past spots.
     */
    Array<Vector2> pastSpots = new Array<>();
    private int currentSpot = 0;
    private boolean isRepeating = true;

    /**
     * Instantiates a new Repeat random placer.
     *
     * @param bounds the bounds
     * @param random the random
     */
    public RepeatRandomPlacer(Bounds bounds, Random random) {
        super(bounds, random);
    }

    @Override
    public Vector2 nextSpot() {
        if(isRepeating)
            return repeat();

        Vector2 nextSpot = super.nextSpot();
        pastSpots.add(nextSpot);

        return nextSpot;
    }

    private Vector2 repeat() {
        if(currentSpot < pastSpots.size)
            return pastSpots.get(currentSpot++);
        return super.nextSpot();
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public void reset(Bounds bounds) {
        super.reset(bounds);

        isRepeating = !isRepeating;

        if(!isRepeating) {
            pastSpots.clear();
            currentSpot = 0;
        }
    }
}
