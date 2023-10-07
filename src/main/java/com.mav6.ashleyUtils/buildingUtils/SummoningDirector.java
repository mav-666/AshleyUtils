package com.mav6.ashleyUtils.buildingUtils;

import com.badlogic.ashley.core.Entity;

public interface SummoningDirector {

    Entity summonBy(Entity summoner);

    String getType();
}
