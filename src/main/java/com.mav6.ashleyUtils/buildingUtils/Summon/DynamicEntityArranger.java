package com.mav6.ashleyUtils.buildingUtils.Summon;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.ObjectMap;

public class DynamicEntityArranger {
    private final ObjectMap<String, Arranger> arrangers = new ObjectMap<>();
    private Entity prototype;
    private Entity arranged;

    public DynamicEntityArranger summonBy(Entity prototype, Entity arranged) {
        this.prototype =  prototype;
        this.arranged = arranged;
        return this;
    }

    public DynamicEntityArranger arrange(String aspect) {
        arrangers.get(aspect).arrangeBy(prototype, arranged);

        return this;
    }

    public Entity get() {
        return arranged;
    }

    public void addArranger(Arranger arranger) {
        arrangers.put(arranger.getAspect(), arranger);
    }
}
