package com.ae2dms.util;

import com.ae2dms.GamePanel;
import com.ae2dms.model.gameObject.sprite.character.Boss;
import com.ae2dms.model.gameObject.sprite.character.Enemy;
import com.ae2dms.model.gameObject.sprite.character.Hero;
import com.ae2dms.model.gameObject.sprite.projectile.Bubble;
import com.ae2dms.model.gameObject.sprite.prompt.CollectEffect;
import com.ae2dms.model.gameObject.sprite.*;
import com.ae2dms.model.gameObject.sprite.fruit.Fruit;
import com.ae2dms.model.gameObject.sprite.projectile.BossProjectile;
import com.ae2dms.model.gameObject.sprite.projectile.EnemyProjectile;
import com.ae2dms.model.gameObject.sprite.projectile.HeroProjectile;
import com.ae2dms.model.gameObject.wall.wallObject.CeilingUnit;
import com.ae2dms.model.gameObject.wall.wallObject.FloorUnit;
import com.ae2dms.model.gameObject.wall.wallObject.WallUnit;
import com.ae2dms.model.scene.GameScene;

import static com.ae2dms.GamePanel.gameStatus;

/**
 * The Game scene updater, which takes a game scene and invoke the update method
 * of all the models in game scene.
 */
public class GameSceneUpdater {

    private GameSceneUpdater() {}

    private static GameSceneUpdater instance = new GameSceneUpdater();

    /**
     * Gets instance of GameSceneUpdater.
     *
     * @return the instance
     */
    public static GameSceneUpdater getInstance() {
        return instance;
    }

    private GameScene gameScene;

    /**
     * Sets game scene to be updated.
     *
     * @param gameScene the game scene
     */
    public void setGameScene(GameScene gameScene) {
        this.gameScene = gameScene;
    }

    private int delay = 180;

    /**
     * Invoke the update method in each element in gameScene, and at the end
     * check if all the enemy is killed. If all are killed, play the corresponding
     * music and set the game status to win.
     */
    public void updatePosition() {
        //updates positions of everything on screen
        for (Hero hero : gameScene.getHeroes()) {
            hero.update();
        }
        for (Enemy enemy : gameScene.getEnemies()) {
            enemy.update();
            if(enemy.canRemove) {
                gameScene.getToBeRemoved().add(enemy);
            }
        }
        for (EnemyProjectile enemyProjectile : gameScene.getEnemyProjectiles()) {
            enemyProjectile.update();
            if (enemyProjectile.canRemove) {
                gameScene.getToBeRemoved().add(enemyProjectile);
            }
        }
        for (HeroProjectile heroProjectile : gameScene.getHeroProjectiles()) {
            heroProjectile.update();
            if (heroProjectile.canRemove) {
                gameScene.getToBeRemoved().add(heroProjectile);
            }
        }
        for (Fruit fruit : gameScene.getFruits()) {
            fruit.update();
            if (fruit.canRemove) {
                gameScene.getToBeRemoved().add(fruit);
            }
        }
        for (Bubble bubble : gameScene.getBubbles()) {
            //charge = 0;
            bubble.update();
            if (bubble.canRemove) {
                gameScene.getToBeRemoved().add(bubble);
            }
        }
        for (CollectEffect collectEffect : gameScene.getCollectEffects()) {
            collectEffect.update();
            if (collectEffect.canRemove) {
                gameScene.getToBeRemoved().add(collectEffect);
            }
        }
        for (Boss boss : gameScene.getBosses()) {
            boss.update();
            if(boss.canRemove) {
                gameScene.getToBeRemoved().add(boss);
            }
        }
        for (BossProjectile bossProjectile : gameScene.getBossProjectiles()) {
            bossProjectile.update();
            if (bossProjectile.canRemove) {
                gameScene.getToBeRemoved().add(bossProjectile);
            }
        }

        // Colliding...
        // Units initiate collisions with Heroes, Enemies, and Fruits
        for (CeilingUnit ceilingUnit : gameScene.getCeilingUnits()) {
            for (Hero hero : gameScene.getHeroes()) {
                ceilingUnit.collideWith(hero);
            }
            for (Enemy enemy : gameScene.getEnemies()) {
                ceilingUnit.collideWith(enemy);
                enemy.collideWith(ceilingUnit);
            }
            for (Fruit fruit : gameScene.getFruits()) {
                ceilingUnit.collideWith(fruit);
            }
            for (EnemyProjectile enemyProjectile : gameScene.getEnemyProjectiles()) {
                ceilingUnit.collideWith(enemyProjectile);
            }
            for (HeroProjectile heroProjectile : gameScene.getHeroProjectiles()) {
                ceilingUnit.collideWith(heroProjectile);
            }
            for (Boss boss : gameScene.getBosses()) {
                ceilingUnit.collideWith(boss);
                boss.collideWith(ceilingUnit);
            }
        }
        for (FloorUnit floorUnit: gameScene.getFloorUnits()) {
            for (Hero hero : gameScene.getHeroes()) {
                floorUnit.collideWith(hero);
            }
            for (Enemy enemy : gameScene.getEnemies()) {
                floorUnit.collideWith(enemy);
                enemy.collideWith(floorUnit);
            }
            for (Fruit fruit : gameScene.getFruits()) {
                floorUnit.collideWith(fruit);
            }
            for (EnemyProjectile enemyProjectile : gameScene.getEnemyProjectiles()) {
                floorUnit.collideWith(enemyProjectile);
            }
            for (HeroProjectile heroProjectile : gameScene.getHeroProjectiles()) {
                floorUnit.collideWith(heroProjectile);
            }
            for (Boss boss : gameScene.getBosses()) {
                floorUnit.collideWith(boss);
                boss.collideWith(floorUnit);
            }
        }
        for (WallUnit wallUnit : gameScene.getWallUnits()) {
            for (Hero hero : gameScene.getHeroes()) {
                wallUnit.collideWith(hero);
            }
            for (Enemy enemy : gameScene.getEnemies()) {
                wallUnit.collideWith(enemy);
                enemy.collideWith(wallUnit);
            }
            for (Fruit fruit : gameScene.getFruits()) {
                wallUnit.collideWith(fruit);
            }
            for (EnemyProjectile enemyProjectile : gameScene.getEnemyProjectiles()) {
                wallUnit.collideWith(enemyProjectile);
            }
            for (HeroProjectile heroProjectile : gameScene.getHeroProjectiles()) {
                wallUnit.collideWith(heroProjectile);
            }
            for (Boss boss : gameScene.getBosses()) {
                wallUnit.collideWith(boss);
                boss.collideWith(wallUnit);
            }
        }
        // Enemies initiate collisions with Heroes
        for (Enemy enemy : gameScene.getEnemies()) {
            for (Hero hero : gameScene.getHeroes()) {
                enemy.collideWith(hero);
            }
        }
        for (Boss boss : gameScene.getBosses()) {
            for (Hero hero : gameScene.getHeroes()) {
                boss.collideWith(hero);
            }
        }
        // HeroProjectiles initiate collisions with Heroes and Enemies
        for (HeroProjectile heroProjectile : gameScene.getHeroProjectiles()) {
            for (Hero hero : gameScene.getHeroes()) {
                heroProjectile.collideWith(hero);
            }
            for (Enemy enemy : gameScene.getEnemies()) {
                heroProjectile.collideWith(enemy);
            }
            for (Boss boss : gameScene.getBosses()) {
                heroProjectile.collideWith(boss);
            }
        }
        for (EnemyProjectile enemyProjectile  : gameScene.getEnemyProjectiles()) {
            for (Hero hero : gameScene.getHeroes()) {
                enemyProjectile.collideWith(hero);
            }
            for (Enemy enemy : gameScene.getEnemies()) {
                enemyProjectile.collideWith(enemy);
            }
            for (Boss boss : gameScene.getBosses()) {
                enemyProjectile.collideWith(boss);
            }
        }
        for (BossProjectile bossProjectile  : gameScene.getBossProjectiles()) {
            for (Hero hero : gameScene.getHeroes()) {
                bossProjectile.collideWith(hero);
            }
            for (Enemy enemy : gameScene.getEnemies()) {
                bossProjectile.collideWith(enemy);
            }
            for (Boss boss : gameScene.getBosses()) {
                bossProjectile.collideWith(boss);
            }
        }
        // Fruits intiate collisions with Heroes
        for (Fruit fruit : gameScene.getFruits()) {
            for (Hero hero : gameScene.getHeroes()) {
                fruit.collideWith(hero);
            }
        }
        for (Bubble bubble : gameScene.getBubbles()) {
            for (Enemy enemy : gameScene.getEnemies()) {
                bubble.collideWith(enemy);
            }
            for (Boss boss : gameScene.getBosses()) {
//                System.out.println(boss.isBombed);
                if (!boss.isBombed) {
                    bubble.collideWith(boss);
                    boss.isBombed = true;
                }
            }
        }

        // Removing...
        for (SpriteObject obj : gameScene.getToBeRemoved()) {
            gameScene.remove(obj);
        }
        gameScene.getToBeRemoved().removeAll(gameScene.getToBeRemoved());

        // end game logic
        if (gameScene.getEnemies().isEmpty() && gameStatus != GamePanel.GameStatus.WIN) {
//            System.out.println(delay);
//            System.out.println("isEmpty");
            if (delay == 90) {
                SoundEffect.getInstance().play("nextLevel");
                delay -= 1;
            } else if (delay == 0) {
                if (gameScene.level.getValue() == 4 ) {
                    if (gameScene.getBosses().isEmpty()) {
//                        System.out.println("no boss");
                        gameStatus = GamePanel.GameStatus.WIN;
                        SoundEffect.getInstance().play("victory");
                        delay = 180;
//                        delay -= 1;
//                        if (delay == -110) {
//                            delay = 190;
//                        }
                    }
                } else {
                    gameScene.level.set(gameScene.level.getValue() + 1);
                    gameScene.getMapReader().readMap(gameScene.level.getValue());
                    delay = 180;
                }
            } else {
                delay -= 1;
            }
        }
    }
}
