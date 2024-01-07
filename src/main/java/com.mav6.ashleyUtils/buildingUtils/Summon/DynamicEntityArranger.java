package com.mav6.ashleyUtils.buildingUtils.Summon;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.ObjectMap;

/**
 * The type Dynamic entity arranger.
 */
public class DynamicEntityArranger {
    private final ObjectMap<String, Arranger> arrangers = new ObjectMap<>();
    private Entity prototype;
    private Entity arranged;

    /**
     * Summon by dynamic entity arranger.
     *
     * @param prototype the prototype
     * @param arranged  the arranged
     * @return the dynamic entity arranger
     */
    public DynamicEntityArranger summonBy(Entity prototype, Entity arranged) {
        this.prototype =  prototype;
        this.arranged = arranged;
        return this;
    }

    /**
     * Arrange dynamic entity arranger.
     *
     * @param aspect the aspect
     * @return the dynamic entity arranger
     */
    public DynamicEntityArranger arrange(String aspect) {
        arrangers.get(aspect).arrangeBy(prototype, arranged);

        return this;
    }

    /**
     * Get entity.
     *
     * @return the entity
     */
    public Entity get() {
        return arranged;
    }

    /**
     * Add arranger.
     *
     * @param arranger the arranger
     */
    public void addArranger(Arranger arranger) {
        arrangers.put(arranger.getAspect(), arranger);
    }
}
