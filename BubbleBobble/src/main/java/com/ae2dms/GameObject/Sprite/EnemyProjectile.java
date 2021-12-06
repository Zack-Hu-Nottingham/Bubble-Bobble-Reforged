package com.ae2dms.GameObject.Sprite;


import com.ae2dms.Scene.GameScene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * The EnemyProjectile class handles the specificities with the projectile being shot from an enemy.
 * For example, the enemy's projectile has a different color than the projectile of a hero.
 * It also can only hurt a hero.
 */
public class EnemyProjectile extends SpriteObject {
	private static final int SIZE = 20;
	private static final int SPEED = 15;
	private static final int TERMINAL_VELOCITY_Y = 5;

	private boolean isActive;
	private int activeFrames;
	private int timer;

	protected static Image image = new Image(Bubble.class.getResource("/image/sprite/bubble/bubbled.png").toString(), SIZE, SIZE, false, false);


	public EnemyProjectile(GameScene world, int x, int y, GameScene.Direction direction) {
		super(x, y, SIZE, SIZE, world, image);
		this.direction = direction;

		xVelocity = SPEED;
		yAccel = 0;

		isActive = true;
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

	@Override
	public void update() {
		y += yVelocity;
		if (direction == GameScene.Direction.LEFT) {
			x -= xVelocity;
		} else {
			x += xVelocity;
		}
		updateVelocity();

		if(y < 25) {
			y = 25;
		}

		if (timer < 0) {
			isActive = false;
		}

		if (timer < -200) {
			markToRemove();
		}
		timer -= 1;
	}

	private void updateVelocity() {
		if (xVelocity > 0) {
			xVelocity -= 0.25;
		} else {
			xVelocity = 0;
		}

		if (Math.abs(yVelocity) < TERMINAL_VELOCITY_Y && !isActive) {
			yVelocity -= 0.1;
		}
	}

	@Override
	public void collideWithFloor() {
		// Nothing happen
	}

	@Override
	public void collideWithCeiling() {
		// Nothing happen
	}

	@Override
	public void collideWithWall() {
		// Nothing happen
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
