package com.mav6.ashleyUtils.buildingUtils.Placers;

import com.badlogic.gdx.math.Vector2;


public abstract class Placer {

    protected Bounds bounds;

    public Placer(Bounds bounds) {
        this.bounds = bounds;
    }

    public void iterate(Placement placement) {
        reset();
        do {
            placement.on(nextSpot());
        } while (hasNext());
    }

    public abstract Vector2 nextSpot();

    public abstract boolean hasNext();

    public void reset(Bounds bounds) {
        this.bounds = bounds;
    }

    public void reset() {
        reset(this.bounds);
    }

    public Bounds getBounds() {
        return bounds;
    }
}
