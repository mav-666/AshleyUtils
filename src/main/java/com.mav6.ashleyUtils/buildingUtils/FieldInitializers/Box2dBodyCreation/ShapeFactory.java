package com.mav6.ashleyUtils.buildingUtils.FieldInitializers.Box2dBodyCreation;

import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.utils.FloatArray;

public interface ShapeFactory {

    Shape createShape(FloatArray coordinates);

}
