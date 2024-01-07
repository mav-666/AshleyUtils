package com.mav6.ashleyUtils.buildingUtils.Placers.collection;

import com.badlogic.gdx.math.Vector2;
import com.mav6.ashleyUtils.buildingUtils.Placers.Placer;
import com.mav6.ashleyUtils.buildingUtils.Placers.Bounds;


/**
 * The type Square placer.
 */
public class SquarePlacer extends Placer {

    private final Vector2 currentSpot = new Vector2(bounds.startX(),bounds.startY());

    /**
     * Instantiates a new Square placer.
     *
     * @param bounds the bounds
     */
    public SquarePlacer(Bounds bounds) {
        super(bounds);
    }

    @Override
    public Vector2 nextSpot() {
        return currentSpot.cpy();
    }

    @Override
    public boolean hasNext() {
        if(currentSpot.x == bounds.width() && currentSpot.y == bounds.height())
            return false;

        if(currentSpot.x == bounds.width())
            currentSpot.set(0, ++currentSpot.y);
        else
            currentSpot.add(1,0);
        return true;
    }
}
