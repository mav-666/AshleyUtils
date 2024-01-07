package com.mav6.ashleyUtils.buildingUtils.FieldInitializers.Box2dBodyCreation;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.utils.FloatArray;

/**
 * The type Circle factory.
 */
public class CircleFactory implements ShapeFactory {

    @Override
    public Shape createShape(FloatArray coordinates) {
        CircleShape circle = new CircleShape();

        Vector2 center = new Vector2(coordinates.get(0), coordinates.get(1));

        circle.setPosition(center);
        circle.setRadius((coordinates.get(2)));

        return circle;
    }
}
