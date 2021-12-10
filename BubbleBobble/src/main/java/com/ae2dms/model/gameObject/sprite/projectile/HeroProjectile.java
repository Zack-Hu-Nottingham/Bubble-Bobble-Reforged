package com.ae2dms.model.gameObject.sprite.projectile;

import com.ae2dms.model.gameObject.sprite.character.Boss;
import com.ae2dms.model.gameObject.sprite.character.Enemy;
import com.ae2dms.model.gameObject.sprite.character.Hero;
import com.ae2dms.GamePanel;
import com.ae2dms.model.scene.GameScene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * The HeroProjectile class handles the specificities with the projectile being shot from a hero.
 * For example, the hero's projectile has a different color than the projectile of an enemy.
 * It also can only hurt an enemy.
 */
public class HeroProjectile extends Projectile {
	private static final int SIZE = 80;

	private static Image red = new Image(Bubble.class.getResource("/image/sprite/bubble/red.png").toString(), SIZE, SIZE, false, false);
	private static Image blurRed = new Image(Bubble.class.getResource("/image/sprite/bubble/blurBubble/blurRed.png").toString(), SIZE, SIZE, false, false);
	private static Image black = new Image(Bubble.class.getResource("/image/sprite/bubble/black.png").toString(), SIZE, SIZE, false, false);
	private static Image blurBlack = new Image(Bubble.class.getResource("/image/sprite/bubble/blurBubble/blurBlack.png").toString(), SIZE, SIZE, false, false);
	private static Image green = new Image(Bubble.class.getResource("/image/sprite/bubble/green.png").toString(), SIZE, SIZE, false, false);
	private static Image blurGreen = new Image(Bubble.class.getResource("/image/sprite/bubble/blurBubble/blurGreen.png").toString(), SIZE, SIZE, false, false);
	private static Image pink = new Image(Bubble.class.getResource("/image/sprite/bubble/pink.png").toString(), SIZE, SIZE, false, false);
	private static Image blurPink = new Image(Bubble.class.getResource("/image/sprite/bubble/blurBubble/blurPink.png").toString(), SIZE, SIZE, false, false);
	private static Image blue = new Image(Bubble.class.getResource("/image/sprite/bubble/blue.png").toString(), SIZE, SIZE, false, false);
	private static Image blurBlue = new Image(Bubble.class.getResource("/image/sprite/bubble/blurBubble/blurBlue.png").toString(), SIZE, SIZE, false, false);


	private static Image image = red;
	private static Image blurImage = blurRed;

    /**
     * Instantiates a new Hero projectile.
     *
     * @param gameScene the gameScene that projectile belongs to
     * @param x         the x-coordinate of projectile
     * @param y         the y-coordinate of projectile
     * @param direction the direction of projectile
     */
    public HeroProjectile(GameScene gameScene, double x, double y, GameScene.Direction direction) {
		super(x-40, y-40, SIZE, SIZE, gameScene, image);
		this.direction = direction;

		activeFrames = 35;
		timer = activeFrames;
	}

	@Override
	public void drawOn(GraphicsContext g) {
		switch (GamePanel.theme) {
			case RED:
				image = red;
				blurImage = blurRed;
				break;

			case BLACK:
				image = black;
				blurImage = blurBlack;
				break;

			case GREEN:
				image = green;
				blurImage = blurGreen;
				break;

			case PINK:
				image = pink;
				blurImage = blurPink;
				break;

			case BLUE:
				image = blue;
				blurImage = blurBlue;
		}
		if (isActive) {
			g.drawImage(image, getX(), getY(), getWidth(), getHeight());
		} else {
			g.drawImage(blurImage, getX(), getY(), getWidth(), getHeight());
		}
	}

    /**
     * Collide with hero.
     *
     * @param hero the hero
     */
    public void collideWith(Hero hero) {
		// Nothing happens
	}

    /**
     * Collide with enemy.
     *
     * @param enemy the enemy
     */
    public void collideWith(Enemy enemy) {
		if (this.overlaps(enemy) && isActive && !enemy.isBubbled()) {
			enemy.collideWithProjectile();
			markToRemove();
		}
	}

    /**
     * Collide with boss.
     *
     * @param boss the boss
     */
    public void collideWith(Boss boss) {
		if (this.overlaps(boss) && isActive && !boss.isBubbled()) {
			boss.collideWithProjectile();
			markToRemove();
		}
	}
}
