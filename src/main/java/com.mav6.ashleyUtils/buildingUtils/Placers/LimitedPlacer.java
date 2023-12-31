package com.mav6.ashleyUtils.buildingUtils.Placers;


public abstract class LimitedPlacer extends Placer {

    protected int currentPlaced = 0;
    protected int maxPlaced = -1;

    public LimitedPlacer(Bounds bounds) {
        super(bounds);
    }

    @Override
    public void reset(Bounds bounds) {
        currentPlaced = 0;
    }

    public void setMaxPlaced(int maxPlaced) {
        this.maxPlaced = maxPlaced;
    }

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
