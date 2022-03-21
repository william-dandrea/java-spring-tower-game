package game.board.entities.playerentities.building.towers;

import game.utils.Position;

/**
 * @author D'Andréa William
 */
public class SniperTower extends Tower{


    public SniperTower(Position position, float price, int shootingRange, int simultaneousStrike, int damageToSoldiers, int refundPrice, int upgradePrice, float percentageRewardIfDestroyed, int healthPoint) {
        super(position, price, shootingRange, simultaneousStrike, damageToSoldiers, refundPrice, upgradePrice, percentageRewardIfDestroyed, healthPoint);
    }
}
