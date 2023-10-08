package com.mav6.ashleyUtils.buildingUtils.Summoners;

import com.badlogic.ashley.core.Engine;
import com.mav6.ashleyUtils.buildingUtils.EntityBuilder;
import com.mav6.ashleyUtils.buildingUtils.SummoningDirector;

public abstract class EntityBuilderSummoner implements SummoningDirector {
    protected final EntityBuilder<?> entityBuilder;
    protected final Engine engine;

    public EntityBuilderSummoner(EntityBuilder<?> entityBuilder, Engine engine) {
        this.entityBuilder = entityBuilder;
        this.engine = engine;
    }
}
