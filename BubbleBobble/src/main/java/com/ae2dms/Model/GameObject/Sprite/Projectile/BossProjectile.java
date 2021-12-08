package com.ae2dms.Model.GameObject.Sprite.Projectile;

import com.ae2dms.Model.GameObject.Sprite.Boss;
import com.ae2dms.Model.GameObject.Sprite.Bubble;
import com.ae2dms.Model.GameObject.Sprite.Enemy;
import com.ae2dms.Model.GameObject.Sprite.Hero;
import com.ae2dms.Model.Scene.GameScene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * The EnemyProjectile class handles the specificities with the projectile being shot from an enemy.
 * For example, the enemy's projectile has a different color than the projectile of a hero.
 * It also can only hurt a hero.
 */
public class BossProjectile extends Projectile {
    private static final int SIZE = 20;

    protected static Image image = new Image(Bubble.class.getResource("/image/sprite/bubble/bossBubble.png").toString(), SIZE, SIZE, false, false);


    public BossProjectile(GameScene world, int x, int y, GameScene.Direction direction) {
        super(x, y, SIZE, SIZE, world, image);
        activeFrames = 20;
        timer = activeFrames;
        this.direction = direction;
    }

    @Override
    public void drawOn(GraphicsContext g) {
        if (isActive) {
            g.drawImage(image, x, y, width, height);
        } else {
            g.setGlobalAlpha(0.4);
            g.drawImage(image, x, y, width, height);
            g.setGlobalAlpha(1);
        }

    }

    public void collideWith(Hero hero) {
        if(this.overlaps(hero) && isActive) {
            hero.collideWithProjectile();
        }
    }

    public void collideWith(Enemy enemy) {
        //Nothing happens
    }

    public void collideWith(Boss boss) {
        //Nothing happens
    }
}
