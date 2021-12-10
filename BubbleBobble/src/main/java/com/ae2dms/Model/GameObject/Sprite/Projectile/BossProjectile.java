package com.ae2dms.Model.GameObject.Sprite.Projectile;

import com.ae2dms.Model.GameObject.Sprite.Character.Boss;
import com.ae2dms.Model.GameObject.Sprite.Character.Enemy;
import com.ae2dms.Model.GameObject.Sprite.Character.Hero;
import com.ae2dms.Model.Scene.GameScene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
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
        System.out.println(this.overlaps(hero));
        System.out.println(isActive);
        if(this.overlaps(hero) && isActive) {
            System.out.println("shoot");
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
