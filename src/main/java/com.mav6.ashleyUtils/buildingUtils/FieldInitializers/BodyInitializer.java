package com.mav6.ashleyUtils.buildingUtils.FieldInitializers;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.mav6.ashleyUtils.buildingUtils.FieldInitializers.Box2dBodyCreation.BodyConfig;
import com.mav6.ashleyUtils.buildingUtils.FieldInitializers.Config.ConfigFactory;

/**
 * The type Body initializer.
 */
public class BodyInitializer extends FieldInitializer<Body, String> {

    private final World world;

    private final ConfigFactory<BodyConfig> bodyConfigFactory;

    /**
     * Instantiates a new Body initializer.
     *
     * @param world             the world
     * @param bodyConfigFactory the body config factory
     */
    public BodyInitializer(World world, ConfigFactory<BodyConfig> bodyConfigFactory) {
        this.world = world;
        this.bodyConfigFactory = bodyConfigFactory;
    }

    @Override
    public Body getInitBy(String config) {
        BodyConfig bodyConfig = bodyConfigFactory.get(config);

        Body initBody = world.createBody(bodyConfig.bodyDef());

        bodyConfig.fixtureDefs().forEach(initBody::createFixture);

        initBody.getMassData().mass = bodyConfig.mass();

        return initBody;
    }
}
