package com.softwaretechnology.tourgame.theknigh.service.game.gamemanaging;

import com.softwaretechnology.tourgame.theknigh.service.game.board.entities.Entity;
import com.softwaretechnology.tourgame.theknigh.service.game.board.entities.gameentities.castles.Castle;
import com.softwaretechnology.tourgame.theknigh.service.game.board.entities.playerentities.PlayerEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author D'Andréa William
 */
public class Player {

    private int id;
    private int currentGold;
    private Castle castle;
    private List<PlayerEntity> entities;


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
}
