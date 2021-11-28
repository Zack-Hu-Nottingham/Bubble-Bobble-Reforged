package com.ae2dms.GameObject.Sprite;

import com.ae2dms.Scene.GameScene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * The HeroProjectile class handles the specificities with the projectile being shot from a hero.
 * For example, the hero's projectile has a different color than the projectile of an enemy.
 * It also can only hurt an enemy.
 */
public class HeroProjectile extends SpriteObject {
	private static final int SIZE = 20;
	private static final int SPEED = 15;
	private static final int TERMINAL_VELOCITY_Y = 5;

	private boolean isActive;
	private int activeFrames;
	private int timer;

	protected static Image image = new Image(Bubble.class.getResource("/image/sprite/bubble/starBubble.png").toString(), SIZE, SIZE, false, false);


	public HeroProjectile(GameScene world, int x, int y, int direction) {
		super(x, y, SIZE, SIZE, world, image);
		this.direction = direction;

		xVelocity = SPEED;
		yAccel = 0;

		isActive = true;
		activeFrames = 35;
		timer = activeFrames;
	}

	@Override
	public void drawOn(GraphicsContext g) {
		if (isActive) {
			g.setFill(Color.BLUE);
		} else {
			g.setFill(new Color(0.4, (double) 102/255, (double)204/255, (double) 255/255));
		}
		g.fillOval(x, y, width, height);
		g.setFill(Color.BLACK);
	}

	@Override
	public void update() {
		y += yVelocity;
		x += xVelocity * direction;
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
		// Nothing happens
	}

	@Override
	public void collideWithCeiling() {
		// Nothing happens
	}

	@Override
	public void collideWithWall() {
		// Nothing happens
	}

	public void collideWith(Hero hero) {
		// Nothing happens
	}

	public void collideWith(Enemy enemy) {
		if (this.overlaps(enemy) && isActive) {
			enemy.collideWithProjectile();
		}
	}
}
