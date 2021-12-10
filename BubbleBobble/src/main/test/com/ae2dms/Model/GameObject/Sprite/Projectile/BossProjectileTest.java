package com.ae2dms.Model.GameObject.Sprite.Projectile;

import com.ae2dms.GamePanel;
import com.ae2dms.Main;
import com.ae2dms.Model.GameObject.Sprite.Hero;
import com.ae2dms.Model.Scene.GameScene;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BossProjectileTest extends ApplicationTest {


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
    void collideWithHero() throws NoSuchFieldException, IllegalAccessException {
        GamePanel gamePanel = new GamePanel();
        GamePanel.level = new SimpleIntegerProperty(1);

        GameScene gameScene = new GameScene();

        Hero hero = new Hero(gameScene, 5, 5);

        BossProjectile bossProjectile = mock(BossProjectile.class);
        when(bossProjectile.overlaps(hero)).thenReturn(true);
        bossProjectile.isActive = true;

        bossProjectile.collideWith(hero);
        Field field = hero.getClass().getDeclaredField("isShielding");
        field.setAccessible(true);
        field.setBoolean(hero, false);

        Assertions.assertNotEquals(GamePanel.GameStatus.WIN, GamePanel.gameStatus);
    }

}