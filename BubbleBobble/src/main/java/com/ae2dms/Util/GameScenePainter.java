package com.ae2dms.Util;

import com.ae2dms.Model.GameObject.Sprite.Character.Boss;
import com.ae2dms.Model.GameObject.Sprite.Character.Enemy;
import com.ae2dms.Model.GameObject.Sprite.Character.Hero;
import com.ae2dms.Model.GameObject.Sprite.Projectile.Bubble;
import com.ae2dms.Model.GameObject.Sprite.Prompt.CollectEffect;
import com.ae2dms.Model.GameObject.Sprite.Fruit.Fruit;
import com.ae2dms.Model.GameObject.Sprite.Projectile.BossProjectile;
import com.ae2dms.Model.GameObject.Sprite.Projectile.EnemyProjectile;
import com.ae2dms.Model.GameObject.Sprite.Projectile.HeroProjectile;
import com.ae2dms.Model.GameObject.Wall.WallObject.CeilingUnit;
import com.ae2dms.Model.GameObject.Wall.WallObject.FloorUnit;
import com.ae2dms.Model.GameObject.Wall.WallObject.WallUnit;
import com.ae2dms.Model.Scene.GameScene;
import javafx.scene.canvas.GraphicsContext;

/**
 * The painter for game scene, which has an updater for .
 */
public class GameScenePainter {
    /**
     * Instantiates a new Game scene painter.
     */
    GameScenePainter() {}

    private static GameScenePainter instance = new GameScenePainter();

    /**
     * Gets instance of gameScenePainter.
     *
     * @return the instance
     */
    public static GameScenePainter getInstance() {
        return instance;
    }

    private GameScene gameScene;
    private GraphicsContext graphicsContext;

    /**
     * Sets the specific game scene of this .
     *
     * @param gameScene the game scene
     */
    public void setGameScene(GameScene gameScene) {
        this.gameScene = gameScene;
    }

    private GameSceneUpdater gameSceneUpdater = GameSceneUpdater.getInstance();

    /**
     * Paint the game scene component according to the arraylist of sub-models
     * in game scene.
     */
    public void paintComponent() {
        //paints everything on the world
        graphicsContext = gameScene.getGraphicsContext();

        gameSceneUpdater.setGameScene(this.gameScene);

        gameSceneUpdater.updatePosition();

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
        for (Boss boss : gameScene.getBosses()) {
            boss.drawOn(graphicsContext);
        }
        for (BossProjectile bossProjectile : gameScene.getBossProjectiles()) {
            bossProjectile.drawOn(graphicsContext);
        }
    }
}
