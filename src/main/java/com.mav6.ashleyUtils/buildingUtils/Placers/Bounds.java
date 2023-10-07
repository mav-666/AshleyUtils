package com.mav6.ashleyUtils.buildingUtils.Placers;

public record Bounds(
        float startX,
        float startY,

        float width,
        float height
) {
    public Bounds(float width, float height) {
        this(0,0, width, height);
    }
}
