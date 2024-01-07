package com.mav6.ashleyUtils.buildingUtils.Summon;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.ObjectMap;

public class EntityArranger {
    private final ObjectMap<String, Arranger> arrangers = new ObjectMap<>();

    private final ChainArranger chainArranger = new ChainArranger();
    private Entity prototype;
    private Entity arranged;

    public ChainArranger arrangeBy(Entity prototype, Entity arranged) {
        this.prototype =  prototype;
        this.arranged = arranged;

        return chainArranger;
    }

    public void addArranger(Arranger arranger) {
        arrangers.put(arranger.getAspect(), arranger);
    }

    public Arranger getArrangerOf(String aspect) {
        return arrangers.get(aspect);
    }

    private class ChainArranger {
        public ChainArranger arrange(String aspect) {
            arrangers.get(aspect).arrangeBy(prototype, arranged);

            return this;
        }

        public Entity get() {
            return arranged;
        }
    }
}
