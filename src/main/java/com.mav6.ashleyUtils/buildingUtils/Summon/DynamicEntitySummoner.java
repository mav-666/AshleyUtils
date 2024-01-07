package com.mav6.ashleyUtils.buildingUtils.Summon;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.ObjectMap;

public class DynamicEntitySummoner {
    private final ObjectMap<String, Arranger> arrangers = new ObjectMap<>();
    private Entity summoner;

    public DynamicEntitySummoner summonBy(Entity summoner) {
        this.summoner = summoner;

        return this;
    }

    public DynamicEntitySummoner arrange(String aspect) {
        arrangers.get(aspect).arrangeBy(summoner);

        return this;
    }

    public void addArranger(Arranger arranger) {
        arrangers.put(arranger.getAspect(), arranger);
    }
}
