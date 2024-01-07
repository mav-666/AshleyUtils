package com.mav6.ashleyUtils.buildingUtils.Placers;

import com.badlogic.gdx.math.Vector2;


/**
 * The type Placer.
 */
public abstract class Placer {

    /**
     * The Bounds.
     */
    protected Bounds bounds;

    /**
     * Instantiates a new Placer.
     *
     * @param bounds the bounds
     */
    public Placer(Bounds bounds) {
        this.bounds = bounds;
    }

    /**
     * Iterate.
     *
     * @param placement the placement
     */
    public void iterate(Placement placement) {
        reset();
        do {
            placement.on(nextSpot());
        } while (hasNext());
    }

    /**
     * Next spot vector 2.
     *
     * @return the vector 2
     */
    public abstract Vector2 nextSpot();

    /**
     * Has next boolean.
     *
     * @return the boolean
     */
    public abstract boolean hasNext();

    /**
     * Reset.
     *
     * @param bounds the bounds
     */
    public void reset(Bounds bounds) {
        this.bounds = bounds;
    }

    /**
     * Reset.
     */
    public void reset() {
        reset(this.bounds);
    }

    /**
     * Gets bounds.
     *
     * @return the bounds
     */
    public Bounds getBounds() {
        return bounds;
    }
}
