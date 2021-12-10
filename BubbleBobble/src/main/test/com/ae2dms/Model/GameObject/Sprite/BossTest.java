package com.ae2dms.Model.GameObject.Sprite;

import com.ae2dms.GamePanel;
import com.ae2dms.Model.GameObject.Sprite.Character.Boss;
import com.ae2dms.Model.Scene.GameScene;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import org.testfx.framework.junit5.ApplicationTest;

class BossTest extends ApplicationTest{


    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);
        GamePanel.stage = stage;

        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 24 * 20, 24 * 30);
        stage.setScene(scene);
    }

    @Test
    void update() {
    }


    @Test
    void collideWithProjectile() throws NoSuchFieldException, IllegalAccessException {

        GameScene gameScene = new GameScene();
        Boss boss = new Boss(new GameScene(), 5, 5);
        gameScene.addBoss(boss);

        Field bossDamage = Boss.class.getDeclaredField("damage");
        bossDamage.setAccessible(true);

        boss.collideWithProjectile();
        Assertions.assertEquals(1, bossDamage.getInt(boss));

        boss.collideWithProjectile();
        boss.collideWithProjectile();
        boss.collideWithProjectile();

        Assertions.assertEquals(4, bossDamage.getInt(boss));

    }


    @Test
    void die() throws NoSuchFieldException, IllegalAccessException {

        GameScene gameScene = new GameScene();
        Boss boss = new Boss(gameScene, 5, 5);
        gameScene.addBoss(boss);

        boss.die();
        Assertions.assertEquals(1, gameScene.chargeLevel);
        Assertions.assertEquals(1, gameScene.getFruits().size());

        Field canRemove = Boss.class.getSuperclass().getDeclaredField("canRemove");

        Assertions.assertTrue(canRemove.getBoolean(boss));

    }

    @Test
    void isBubbled() throws NoSuchFieldException, IllegalAccessException {

        GameScene gameScene = new GameScene();
        Boss boss = new Boss(gameScene, 5, 5);

        Field field = boss.getClass().getDeclaredField("isBubbled");
        field.setAccessible(true);

        Assertions.assertEquals(field.getBoolean(boss), boss.isBubbled());
    }

    @Test
    void shootProjectile() {

        GameScene gameScene = new GameScene();
        Boss boss = new Boss(gameScene, 5, 5);
        boss.shootProjectile();
        Assertions.assertEquals(1, gameScene.getBossProjectiles().size());
    }
}