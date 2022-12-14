package com.ae2dms.model.gameObject.sprite.projectile;

import com.ae2dms.model.gameObject.sprite.character.Boss;
import com.ae2dms.model.gameObject.sprite.character.Enemy;
import com.ae2dms.model.gameObject.sprite.character.Hero;
import com.ae2dms.model.scene.GameScene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Boss projectile
 * The EnemyProjectile class handles the specificities with the projectile being shot from an enemy.
 * For example, the enemy's projectile has a different color than the projectile of a hero.
 * It also can only hurt a hero.
 */
public class BossProjectile extends Projectile {
    private static final int SIZE = 20;

    /**
     * The image of boss's projectile.
     */
    protected static Image image = new Image(Bubble.class.getResource("/image/sprite/bubble/bossBubble.png").toString(), SIZE, SIZE, false, false);


    /**
     * Instantiates a new Boss projectile.
     *
     * @param gameScene the gameScene that the projectile belongs to
     * @param x         the x-coordinate of projectile
     * @param y         the y-coordinate of projectile
     * @param direction the direction
     */
    public BossProjectile(GameScene gameScene, double x, double y, GameScene.Direction direction) {
        super(x, y, SIZE, SIZE, gameScene, image);
        activeFrames = 20;
        timer = activeFrames;
        this.direction = direction;
    }

    @Override
    public void drawOn(GraphicsContext g) {
        if (isActive) {
            g.drawImage(image, getX(), getY(), getWidth(), getHeight());
        } else {
            g.setGlobalAlpha(0.4);
            g.drawImage(image, getX(), getY(), getWidth(), getHeight());
            g.setGlobalAlpha(1);
        }

    }

    /**
     * Collide with hero.
     *
     * @param hero the hero
     */
    public void collideWith(Hero hero) {
        if(this.overlaps(hero) && isActive) {
            hero.collideWithProjectile();
        }
    }

    /**
     * Collide with enemy.
     *
     * @param enemy the enemy
     */
    public void collideWith(Enemy enemy) {
        //Nothing happens
    }

    /**
     * Collide with boss.
     *
     * @param boss the boss
     */
    public void collideWith(Boss boss) {
        //Nothing happens
    }
}
