package com.mav6.ashleyUtils.buildingUtils.Summoners;

import com.badlogic.gdx.utils.ObjectMap;
import com.mav6.ashleyUtils.buildingUtils.SummoningDirector;

public class EntitySummonerProvider {

    private final ObjectMap<String, SummoningDirector> summoners = new ObjectMap<>();

    public EntitySummonerProvider(SummoningDirector defaultSummoner) {
        summoners.put("Default", defaultSummoner);
    }

    public SummoningDirector provide(String summonerType) {
        return summoners.get(summonerType, summoners.get("Default"));
    }

    public void add(SummoningDirector summoningDirector) {
        summoners.put(summoningDirector.getType(), summoningDirector);
    }
}
