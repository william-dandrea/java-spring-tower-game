package com.softwaretechnology.tourgame.theknigh.service;

import com.softwaretechnology.tourgame.theknigh.service.game.Game;
import com.softwaretechnology.tourgame.theknigh.service.game.board.entities.gameentities.castles.Castle;
import com.softwaretechnology.tourgame.theknigh.service.game.board.entities.gameentities.obstacles.Obstacle;
import com.softwaretechnology.tourgame.theknigh.service.game.settings.Settings;
import com.softwaretechnology.tourgame.theknigh.service.game.settings.game.*;
import com.softwaretechnology.tourgame.theknigh.service.game.settings.soldiers.FastSoldierSettings;
import com.softwaretechnology.tourgame.theknigh.service.game.settings.soldiers.FlightSoldierSettings;
import com.softwaretechnology.tourgame.theknigh.service.game.settings.soldiers.KillerSoldierSettings;
import com.softwaretechnology.tourgame.theknigh.service.game.settings.soldiers.SoldierMainSettings;
import com.softwaretechnology.tourgame.theknigh.service.game.settings.towers.FreezeTowerSettings;
import com.softwaretechnology.tourgame.theknigh.service.game.settings.towers.NormalTowerSettings;
import com.softwaretechnology.tourgame.theknigh.service.game.settings.towers.SniperTowerSettings;
import com.softwaretechnology.tourgame.theknigh.service.game.settings.towers.TowerMainSettings;
import com.softwaretechnology.tourgame.theknigh.service.game.utils.Position;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author D'Andréa William
 * To set up the settings of the game
 */

@Service
@AllArgsConstructor
public class GameService {

    private Game game;
    private static GameService instance;
    private Settings settings;

    private GameService() {

        this.game = new Game(setupSettings());
    }


    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }
    public void launchNewGame() {
        this.game = new Game(this.settings);
    }
    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Change the game settings
     * @param settings
     * the new settings
     * @return
     * the settings of the game after changing
     */
    public Settings setSettings(Settings settings) {
        this.settings = settings;
        this.game = new Game(settings);
        return this.game.getSettings();
    }


    /**
     * Initiate default game settings
     * @return
     * return this default game settings
     */
    private Settings setupSettings() {

        GeneralSettings generalSettings = new GeneralSettings(10, 10, 3, 2);
        CastelSettings castelSettings = new CastelSettings(200, 10);
        GoldSettings goldSettings = new GoldSettings(100, 30, 200, 30);
        MonsterSettings monsterSettings = new MonsterSettings(10, 3);
        ObstacleSettings obstacleSettings = new ObstacleSettings(2, 2);
        SoldierMainSettings soldierMainSettings = new SoldierMainSettings();
        FastSoldierSettings fastSoldierSettings = new FastSoldierSettings(50, 30, 5, 2);
        KillerSoldierSettings killerSoldierSettings = new KillerSoldierSettings(50, 40, 5, 5);
        FlightSoldierSettings flightSoldierSettings = new FlightSoldierSettings(30, 20, 5);
        TowerMainSettings towerMainSettings = new TowerMainSettings();
        FreezeTowerSettings freezeTowerSettings = new FreezeTowerSettings(30, 3,1);
        NormalTowerSettings normalTowerSettings = new NormalTowerSettings(25, 3, 3);
        SniperTowerSettings sniperTowerSettings = new SniperTowerSettings(50, 5, 2);

        Settings settings = new Settings(generalSettings, castelSettings, goldSettings, monsterSettings, obstacleSettings,
                soldierMainSettings, fastSoldierSettings, flightSoldierSettings,killerSoldierSettings, towerMainSettings,
                freezeTowerSettings, normalTowerSettings, sniperTowerSettings);

        return settings;

    }



}
