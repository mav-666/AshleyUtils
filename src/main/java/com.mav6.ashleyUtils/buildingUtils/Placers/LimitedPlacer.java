package com.mav6.ashleyUtils.buildingUtils.Placers;


/**
 * The type Limited placer.
 */
public abstract class LimitedPlacer extends Placer {

    /**
     * The Current placed.
     */
    protected int currentPlaced = 0;
    /**
     * The Max placed.
     */
    protected int maxPlaced = -1;

    /**
     * Instantiates a new Limited placer.
     *
     * @param bounds the bounds
     */
    public LimitedPlacer(Bounds bounds) {
        super(bounds);
    }

    @Override
    public void reset(Bounds bounds) {
        currentPlaced = 0;
    }

    /**
     * Sets max placed.
     *
     * @param maxPlaced the max placed
     */
    public void setMaxPlaced(int maxPlaced) {
        this.maxPlaced = maxPlaced;
    }

    /**
     * Is not enough boolean.
     *
     * @return the boolean
     */
    protected boolean isNotEnough() {
        return maxPlaced == -1 || currentPlaced < maxPlaced;
    }

    public void iterate(Placement placement) {
        reset();
        while (hasNext() && isNotEnough()) {
            placement.on(nextSpot());
            currentPlaced++;
        }
    }
}
