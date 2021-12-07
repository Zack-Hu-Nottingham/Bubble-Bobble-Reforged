package com.ae2dms.Util;

import com.ae2dms.Model_GameObject.Prompt.CollectEffect;
import com.ae2dms.Model_GameObject.Sprite.Bubble;
import com.ae2dms.Model_GameObject.Sprite.Enemy;
import com.ae2dms.Model_GameObject.Sprite.Fruit.Fruit;
import com.ae2dms.Model_GameObject.Sprite.Hero;
import com.ae2dms.Model_GameObject.Sprite.Projectile.EnemyProjectile;
import com.ae2dms.Model_GameObject.Sprite.Projectile.HeroProjectile;
import com.ae2dms.Model_GameObject.Wall.WallObject.CeilingUnit;
import com.ae2dms.Model_GameObject.Wall.WallObject.FloorUnit;
import com.ae2dms.Model_GameObject.Wall.WallObject.WallUnit;
import com.ae2dms.Scene.GameScene;
import javafx.scene.canvas.GraphicsContext;

public class GameScenePainter {
    GameScenePainter() {}

    private static GameScenePainter instance = new GameScenePainter();

    public static GameScenePainter getInstance() {
        return instance;
    }

    private GameScene gameScene;
    private GraphicsContext graphicsContext;

    public void setGameScene(GameScene gameScene) {
        this.gameScene = gameScene;
    }


    public void paintComponent() {
        //paints everything on the world
        graphicsContext = gameScene.getGraphicsContext();

        graphicsContext.clearRect(0, 0, 1280, 720);

        for (CeilingUnit ceilingUnit : gameScene.getCeilingUnits()) {
            ceilingUnit.drawOn(graphicsContext);
        }
        for (FloorUnit floorUnit : gameScene.getFloorUnits()) {
            floorUnit.drawOn(graphicsContext);
        }
        for (WallUnit wallUnit : gameScene.getWallUnits()) {
            wallUnit.drawOn(graphicsContext);
        }
        for (Hero hero : gameScene.getHeroes()) {
            hero.drawOn(graphicsContext);
        }
        for (Enemy enemy : gameScene.getEnemies()) {
            enemy.drawOn(graphicsContext);
        }
        for (EnemyProjectile enemyProjectile : gameScene.getEnemyProjectiles()) {
            enemyProjectile.drawOn(graphicsContext);
        }
        for (HeroProjectile heroProjectile : gameScene.getHeroProjectiles()) {
            heroProjectile.drawOn(graphicsContext);
        }
        for (Fruit fruit : gameScene.getFruits()) {
            fruit.drawOn(graphicsContext);
        }
        for (Bubble bubble : gameScene.getBubbles()) {
            bubble.drawOn(graphicsContext);
        }
        for (CollectEffect collectEffect : gameScene.getCollectEffects()) {
            collectEffect.drawOn(graphicsContext);
        }
    }
}
