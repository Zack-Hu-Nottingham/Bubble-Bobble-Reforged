package com.ae2dms.GameObject.Sprite.Projectile;


import com.ae2dms.GameObject.Sprite.Bubble;
import com.ae2dms.GameObject.Sprite.Enemy;
import com.ae2dms.GameObject.Sprite.Hero;
import com.ae2dms.Scene.GameScene;
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

	protected static Image image = new Image(Bubble.class.getResource("/image/sprite/bubble/bubbled.png").toString(), SIZE, SIZE, false, false);


	public EnemyProjectile(GameScene world, int x, int y, GameScene.Direction direction) {
		super(x, y, SIZE, SIZE, world, image);
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
		g.fillOval(x, y, width, height);
		g.setFill(Color.BLACK);
	}

	public void collideWith(Hero hero) {
		if(this.overlaps(hero) && isActive) {
			hero.collideWithProjectile();
		}
	}

	public void collideWith(Enemy enemy) {
		//Nothing happens
	}
}
