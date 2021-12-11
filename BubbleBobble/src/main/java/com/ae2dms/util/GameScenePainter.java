package com.ae2dms.util;

import com.ae2dms.model.gameObject.sprite.character.Boss;
import com.ae2dms.model.gameObject.sprite.character.Enemy;
import com.ae2dms.model.gameObject.sprite.character.Hero;
import com.ae2dms.model.gameObject.sprite.projectile.Bubble;
import com.ae2dms.model.gameObject.sprite.prompt.CollectEffect;
import com.ae2dms.model.gameObject.sprite.fruit.fruits.Fruit;
import com.ae2dms.model.gameObject.sprite.projectile.BossProjectile;
import com.ae2dms.model.gameObject.sprite.projectile.EnemyProjectile;
import com.ae2dms.model.gameObject.sprite.projectile.HeroProjectile;
import com.ae2dms.model.gameObject.wall.WallObject.CeilingUnit;
import com.ae2dms.model.gameObject.wall.WallObject.FloorUnit;
import com.ae2dms.model.gameObject.wall.WallObject.WallUnit;
import com.ae2dms.model.scene.GameScene;
import javafx.scene.canvas.GraphicsContext;

/**
 * The painter for game scene, which initialize an updater inside and would
 * update all the models in game scene before refresh.
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
