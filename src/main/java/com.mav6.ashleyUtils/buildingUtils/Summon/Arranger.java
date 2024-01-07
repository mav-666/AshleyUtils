package com.mav6.ashleyUtils.buildingUtils.Summon;

import com.badlogic.ashley.core.Entity;

public interface Arranger {

    void arrangeBy(Entity prototype, Entity arranged);

    String getAspect();
}
