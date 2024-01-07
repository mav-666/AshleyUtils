package com.mav6.ashleyUtils.buildingUtils.Placers;

/**
 * The type Bounds.
 */
public record Bounds(
        float startX,
        float startY,

        float width,
        float height
) {
    /**
     * Instantiates a new Bounds.
     *
     * @param width  the width
     * @param height the height
     */
    public Bounds(float width, float height) {
        this(0,0, width, height);
    }
}
