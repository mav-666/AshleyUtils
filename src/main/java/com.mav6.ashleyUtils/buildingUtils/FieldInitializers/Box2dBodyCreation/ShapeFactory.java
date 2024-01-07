package com.mav6.ashleyUtils.buildingUtils.FieldInitializers.Box2dBodyCreation;

import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.utils.FloatArray;

/**
 * The interface Shape factory.
 */
public interface ShapeFactory {

    /**
     * Create shape shape.
     *
     * @param coordinates the coordinates
     * @return shape
     */
    Shape createShape(FloatArray coordinates);

}
