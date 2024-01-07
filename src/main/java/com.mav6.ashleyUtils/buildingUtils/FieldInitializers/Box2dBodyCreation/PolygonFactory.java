package com.mav6.ashleyUtils.buildingUtils.FieldInitializers.Box2dBodyCreation;

import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.utils.FloatArray;

/**
 * The type Polygon factory.
 */
public class PolygonFactory implements ShapeFactory {
    /**
     * The Polygon.
     */
    PolygonShape polygon;

    @Override
    public Shape createShape(FloatArray coordinates) {
        polygon = new PolygonShape();

        if(coordinates.size == 2)
            createAsBox(coordinates.get(0), coordinates.get(1));
        else
            createByPoints(coordinates);

        return polygon;
    }

    private void createAsBox(float width, float height) {
        polygon.setAsBox(width, height);
    }

    private void createByPoints(FloatArray coordinates) {
        polygon.set(coordinates.toArray());
    }
}
