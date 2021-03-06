package com.softwaretechnology.tourgame.theknigh.service.game.board.entities.playerentities.building.goldmines;

import com.softwaretechnology.tourgame.theknigh.service.game.board.entities.playerentities.building.BuildingEntity;
import com.softwaretechnology.tourgame.theknigh.service.game.settings.game.GoldSettings;
import com.softwaretechnology.tourgame.theknigh.service.game.utils.Position;

/**
 * @author D'Andréa William
 *
 * - Price of a gold mine
 * - Amount of gold distributed at the beginning of each round for a gold mine
 */
public class GoldMine extends BuildingEntity {


    // Amount of gold distributed at the beginning of each round for a gold mine
    private int goldDistributedAtEachRound;
    private String name = "goldmine_entity";

    public GoldMine(Position position, float price, int goldDistributedAtEachRound, float percentageRewardIfDestroyed) {
        super(position, price, percentageRewardIfDestroyed);
        this.goldDistributedAtEachRound = goldDistributedAtEachRound;
    }

    public GoldMine(Position position, GoldSettings goldSettings) {
        super(position, goldSettings.getPriceOfGoldMine(), 0);
        this.goldDistributedAtEachRound = goldSettings.getAddedGoldAtEachRoundWithGoldMine();
    }

    public int getGoldDistributedAtEachRound() {
        return goldDistributedAtEachRound;
    }

    public void setGoldDistributedAtEachRound(int goldDistributedAtEachRound) {
        this.goldDistributedAtEachRound = goldDistributedAtEachRound;
    }

    @Override
    public String getName() {
        return name;
    }
}
