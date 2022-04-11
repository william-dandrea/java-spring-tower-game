package com.softwaretechnology.tourgame.theknigh.service.game.gamemanaging;

import com.softwaretechnology.tourgame.theknigh.service.game.board.entities.Entity;
import com.softwaretechnology.tourgame.theknigh.service.game.board.entities.gameentities.castles.Castle;
import com.softwaretechnology.tourgame.theknigh.service.game.board.entities.playerentities.PlayerEntity;
import com.softwaretechnology.tourgame.theknigh.service.game.board.entities.playerentities.building.BuildingEntity;
import com.softwaretechnology.tourgame.theknigh.service.game.board.entities.playerentities.building.goldmines.GoldMine;
import com.softwaretechnology.tourgame.theknigh.service.game.board.entities.playerentities.building.towers.Tower;
import com.softwaretechnology.tourgame.theknigh.service.game.board.entities.playerentities.soldiers.Soldier;
import com.softwaretechnology.tourgame.theknigh.service.game.utils.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author D'Andréa William
 */
public class Player {

    private int id;
    private int currentGold;
    private Castle castle;
    private List<PlayerEntity> entities;
    private boolean isPlaying;


    public Player(int id, int currentGold, Castle castle) {
        this.id = id;
        this.currentGold = currentGold;
        this.castle = castle;
        this.entities = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getCurrentGold() {
        return currentGold;
    }

    public Castle getCastle() {
        return castle;
    }

    public List<PlayerEntity> getEntities() {
        return entities;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }


    public void decreaseCurrentGold(int amount) {
        this.currentGold -= amount;
    }

    public void increaseCurrentGold(int gldToAdd) {
        this.currentGold += gldToAdd;
    }


    public List<Entity> getBuildingEntities() {

        List<Entity> bEntities = new ArrayList<>();
        // bEntities.add(castle);
        bEntities.addAll(this.entities.stream().filter(e -> e instanceof BuildingEntity).collect(Collectors.toList()));

        return bEntities;

    }

    public List<GoldMine> getAllGoldMines() {

        List<GoldMine> bEntities = new ArrayList<>();

        for (Entity entity : this.entities) {
            if (entity instanceof GoldMine) {
                bEntities.add((GoldMine) entity);
            }
        }

        return bEntities;
    }


    public List<Soldier> getAllSoldiers() {

        List<PlayerEntity> soldiersP = this.entities.stream().filter(e -> e instanceof Soldier).collect(Collectors.toList());

        List<Soldier> soldiers = new ArrayList<>();

        for (PlayerEntity s : soldiersP) {
            if (s instanceof Soldier) {
                soldiers.add((Soldier) s);
            }
        }


        return soldiers;

    }

    public List<Tower> getAllTowers() {
        List<Tower> towers =  new ArrayList<>();

        for (Entity e : this.entities) {
            if (e instanceof Tower) {
                towers.add((Tower) e);
            }
        }

        return towers;
    }



    public void removeSoldierAtThisPositon(Position position) {
        List<PlayerEntity> newEntities = new ArrayList<>();

        for (PlayerEntity entity : this.entities) {
            if (!entity.getPosition().equals(position)){
                newEntities.add(entity);
            }
        }

        this.entities = newEntities;
    }


    public List<Soldier> soldierAtThisPositions(List<Position> positions) {

        List<Soldier> soldierAtThisPosition = new ArrayList<>();

        for (Soldier soldier : this.getAllSoldiers()) {

            for (Position pos : positions) {
                if (pos.equals(soldier.getPosition())) {
                    soldierAtThisPosition.add(soldier);
                    break;
                }
            }
        }

        return soldierAtThisPosition;
    }


    public void removeHealthPointToSoldier(Soldier soldier, int numberOfHealthPointToRemove) {

        soldier.removeHealthPoints(numberOfHealthPointToRemove);

        if (soldier.getHealthPoint() <= 0) {
            this.entities.remove(soldier);
        }
    }



    public List<Soldier> getEntitiesInThisPosition(Position position) {

        List<Soldier> entitiesAtThisPosition = new ArrayList<>();

        for (Soldier entity : this.getAllSoldiers()) {

            if (entity.getPosition().equals(position)) {
                entitiesAtThisPosition.add(entity);
            }
        }

        return entitiesAtThisPosition;
    }





}