package com.mav6.ashleyUtils.buildingUtils.Summoners;

import com.badlogic.ashley.core.Engine;
import com.mav6.ashleyUtils.buildingUtils.EntityTemplateFactoryBy;
import com.mav6.ashleyUtils.buildingUtils.SummoningDirector;

public abstract class EntityBuilderSummoner implements SummoningDirector {
    protected final EntityTemplateFactoryBy<?> entityBuilder;
    protected final Engine engine;

    public EntityBuilderSummoner(EntityTemplateFactoryBy<?> entityBuilder, Engine engine) {
        this.entityBuilder = entityBuilder;
        this.engine = engine;
    }
}
