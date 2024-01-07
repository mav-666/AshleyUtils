package com.mav6.ashleyUtils.buildingUtils.FieldInitializers.Box2dBodyCreation;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.utils.Array;
import com.mav6.ashleyUtils.buildingUtils.FieldInitializers.Config.Config;

/**
 * The type Body config.
 */
public record BodyConfig(
        BodyDef bodyDef,
        float mass,
        Array<FixtureDef> fixtureDefs
) implements Config {}
