package com.ae2dms.Util;

import com.ae2dms.GamePanel;
import com.ae2dms.Main;
import com.ae2dms.Model.GameObject.Sprite.Boss;
import com.ae2dms.Model.GameObject.Sprite.Enemy;
import com.ae2dms.Model.GameObject.Sprite.Hero;
import com.ae2dms.Model.Scene.GameScene;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.util.ArrayList;


class MapReaderTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);
        GamePanel.stage = stage;
//        Main.stage = stage;

        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 24 * 20, 24 * 30);
        stage.setScene(scene);
    }

    @Test
    void readMapOne() {
        MapReader mapReader = MapReader.getInstance();
        GamePanel gamePanel = new GamePanel();

        GamePanel.level = new SimpleIntegerProperty(1);
        GameScene gameScene = new GameScene();
        mapReader.setGameScene(gameScene);

        mapReader.readMap(1);
        ArrayList<Enemy> enemies = gameScene.getEnemies();
        ArrayList<Hero> heroes = gameScene.getHeroes();
        ArrayList<Boss> bosses = gameScene.getBosses();

        Assertions.assertEquals(enemies.size(), 3);
        Assertions.assertNotNull(heroes.get(0));
        Assertions.assertTrue(bosses.isEmpty());

    }

    @Test
    void readMapTwo() {
        MapReader mapReader = MapReader.getInstance();

        GamePanel.level = new SimpleIntegerProperty(1);
        GameScene gameScene = new GameScene();

        mapReader.setGameScene(gameScene);

        mapReader.readMap(2);
        ArrayList<Enemy> enemies = gameScene.getEnemies();
        ArrayList<Hero> heroes = gameScene.getHeroes();
        ArrayList<Boss> bosses = gameScene.getBosses();

        Assertions.assertEquals(enemies.size(), 4);
        Assertions.assertNotNull(heroes.get(0));
        Assertions.assertTrue(bosses.isEmpty());
    }

    @Test
    void readMapThree() {
        MapReader mapReader = MapReader.getInstance();

        GamePanel.level = new SimpleIntegerProperty(1);
        GameScene gameScene = new GameScene();
        mapReader.setGameScene(gameScene);

        mapReader.readMap(3);
        ArrayList<Enemy> enemies = gameScene.getEnemies();
        ArrayList<Hero> heroes = gameScene.getHeroes();
        ArrayList<Boss> bosses = gameScene.getBosses();

        Assertions.assertEquals(enemies.size(), 4);
        Assertions.assertNotNull(heroes.get(0));
        Assertions.assertEquals(bosses.size(), 1);
    }

}