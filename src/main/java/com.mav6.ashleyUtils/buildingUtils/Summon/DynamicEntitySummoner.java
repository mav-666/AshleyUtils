package com.mav6.ashleyUtils.buildingUtils.Summon;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.ObjectMap;

public class DynamicEntitySummoner {
    private final ObjectMap<String, Arranger> arrangers = new ObjectMap<>();
    private Entity summoner;
    private Entity summoned;

    public DynamicEntitySummoner summonBy(Entity summoner, Entity summoned) {
        this.summoner = summoner;
        this.summoned = summoned;
        return this;
    }

    public DynamicEntitySummoner arrange(String aspect) {
        arrangers.get(aspect).arrangeBy(summoner, summoned);

        return this;
    }

    public void addArranger(Arranger arranger) {
        arrangers.put(arranger.getAspect(), arranger);
    }
}
