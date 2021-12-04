package com.ae2dms.GameObject.Sprite;

import com.ae2dms.Scene.GameScene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * The HeroProjectile class handles the specificities with the projectile being shot from a hero.
 * For example, the hero's projectile has a different color than the projectile of an enemy.
 * It also can only hurt an enemy.
 */
public class HeroProjectile extends SpriteObject {
	private static final int SIZE = 80;
	private static final int SPEED = 15;
//	private static final int SPEED = 15;
	private static final int TERMINAL_VELOCITY_Y = 5;

	private boolean isActive;
	private int activeFrames;
	private int timer;
//	private Theme theme;

	protected static Image image = new Image(Bubble.class.getResource("/image/sprite/bubble/starBubble.png").toString(), SIZE, SIZE, false, false);
	protected static Image blurImage = new Image(Bubble.class.getResource("/image/sprite/bubble/starBubble2.png").toString(), SIZE, SIZE, false, false);


	public HeroProjectile(GameScene world, int x, int y, GameScene.Direction direction) {
		super(x-40, y-40, SIZE, SIZE, world, image);
		this.direction = direction;

		xVelocity = SPEED;
		yAccel = 0;

		isActive = true;
		activeFrames = 35;
		timer = activeFrames;
	}

	@Override
	public void drawOn(GraphicsContext g) {
		switch (this.scene.getTheme()) {
			case RED:
				image = new Image(Bubble.class.getResource("/image/sprite/bubble/red.png").toString(), SIZE, SIZE, false, false);
				blurImage = new Image(Bubble.class.getResource("/image/sprite/bubble/blurRed.png").toString(), SIZE, SIZE, false, false);
				break;

			case BLACK:
				image = new Image(Bubble.class.getResource("/image/sprite/bubble/black.png").toString(), SIZE, SIZE, false, false);
				blurImage = new Image(Bubble.class.getResource("/image/sprite/bubble/blurBlack.png").toString(), SIZE, SIZE, false, false);
				break;

			case GREEN:
				image = new Image(Bubble.class.getResource("/image/sprite/bubble/green.png").toString(), SIZE, SIZE, false, false);
				blurImage = new Image(Bubble.class.getResource("/image/sprite/bubble/blurGreen.png").toString(), SIZE, SIZE, false, false);
				break;

			case PINK:
				image = new Image(Bubble.class.getResource("/image/sprite/bubble/pink.png").toString(), SIZE, SIZE, false, false);
				blurImage = new Image(Bubble.class.getResource("/image/sprite/bubble/blurPink.png").toString(), SIZE, SIZE, false, false);
				break;

			case BLUE:
				image = new Image(Bubble.class.getResource("/image/sprite/bubble/blue.png").toString(), SIZE, SIZE, false, false);
				blurImage = new Image(Bubble.class.getResource("/image/sprite/bubble/blurBlue.png").toString(), SIZE, SIZE, false, false);
		}
		if (isActive) {
			g.drawImage(image, x, y, width, height);
		} else {
			g.drawImage(blurImage, x, y, width, height);
		}
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
