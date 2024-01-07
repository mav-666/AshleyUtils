package com.mav6.ashleyUtils.buildingUtils.Summon;

import com.badlogic.ashley.core.Entity;

/**
 * The interface Arranger.
 */
public interface Arranger {

    /**
     * Arrange by.
     *
     * @param prototype the prototype
     * @param arranged  the arranged
     */
    void arrangeBy(Entity prototype, Entity arranged);

    /**
     * Gets aspect.
     *
     * @return the aspect
     */
    String getAspect();
}
