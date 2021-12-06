package com.ae2dms.Model_GameObject.Sprite.Projectile;

import com.ae2dms.Model_GameObject.Sprite.Bubble;
import com.ae2dms.Model_GameObject.Sprite.Enemy;
import com.ae2dms.Model_GameObject.Sprite.Hero;
import com.ae2dms.GamePanel;
import com.ae2dms.Scene.GameScene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * The HeroProjectile class handles the specificities with the projectile being shot from a hero.
 * For example, the hero's projectile has a different color than the projectile of an enemy.
 * It also can only hurt an enemy.
 */
public class HeroProjectile extends Projectile {
	private static final int SIZE = 80;

	protected static Image image = new Image(Bubble.class.getResource("/image/sprite/bubble/starBubble.png").toString(), SIZE, SIZE, false, false);
	protected static Image blurImage = new Image(Bubble.class.getResource("/image/sprite/bubble/starBubble2.png").toString(), SIZE, SIZE, false, false);

	public HeroProjectile(GameScene world, int x, int y, GameScene.Direction direction) {
		super(x-40, y-40, SIZE, SIZE, world, image);
		this.direction = direction;

		activeFrames = 35;
		timer = activeFrames;
	}

	@Override
	public void drawOn(GraphicsContext g) {
		switch (GamePanel.theme) {
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

	public void collideWith(Hero hero) {
		// Nothing happens
	}

	public void collideWith(Enemy enemy) {
		if (this.overlaps(enemy) && isActive) {
			enemy.collideWithProjectile();
		}
	}
}
