package com.ae2dms.Model.GameObject.Sprite.Projectile;


import com.ae2dms.Model.GameObject.Sprite.Character.Boss;
import com.ae2dms.Model.GameObject.Sprite.Character.Enemy;
import com.ae2dms.Model.GameObject.Sprite.Character.Hero;
import com.ae2dms.Model.Scene.GameScene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * The EnemyProjectile class handles the specificities with the projectile being shot from an enemy.
 * For example, the enemy's projectile has a different color than the projectile of a hero.
 * It also can only hurt a hero.
 */
public class EnemyProjectile extends Projectile {
	private static final int SIZE = 20;

	/**
	 * Instantiates a new Enemy projectile.
	 *
	 * @param gameScene the gameScene that projectile belongs to
	 * @param x         the x-coordinate of projectile
	 * @param y         the y-coordinate of projectile
	 * @param direction the direction of projectile
	 */
	public EnemyProjectile(GameScene gameScene, double x, double y, GameScene.Direction direction) {
		super(x, y, SIZE, SIZE, gameScene, null);
		activeFrames = 20;
		timer = activeFrames;
	}
	
	@Override
	public void drawOn(GraphicsContext g) {
		if (isActive) {
			g.setFill(new Color(0, 102/255, 0, 100/100));
		} else {
			g.setFill(new Color(0, 102/255, 0, 40/100));
		}
		g.fillOval(getX(), getY(), getWidth(), getHeight());
		g.setFill(Color.BLACK);
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
