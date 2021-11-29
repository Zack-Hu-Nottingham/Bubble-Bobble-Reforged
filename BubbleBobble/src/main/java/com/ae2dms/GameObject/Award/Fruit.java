package com.ae2dms.GameObject.Award;

import com.ae2dms.GameObject.Sprite.Hero;
import com.ae2dms.GameObject.Sprite.SpriteObject;
import com.ae2dms.Scene.GameScene;
import com.ae2dms.Util.SoundEffect;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


/**
 * The Fruit class handles how the fruit is created and interacts with the hero.
 * The fruits are created after a bubble containing an enemy is popped.
 */
public class Fruit extends SpriteObject {
	private static final int bonus = 400;
	private static final int SIZE = 25;
	private static final int TERMINAL_VELOCITY_Y = 10;
	
	private boolean readyToCollect;

	protected static Image fruitImage = new Image(Fruit.class.getResource("/image/award/apple.png").toString(), SIZE, SIZE, false, false);


	public Fruit(int x, int y, GameScene world) {
		//initializes fruit
		super(x, y, SIZE, SIZE, world, fruitImage);
		terminal_yVelocity = TERMINAL_VELOCITY_Y;
		readyToCollect = false;
	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public void drawOn(GraphicsContext g) {
		//draws fruit
		g.drawImage(fruitImage, x, y, SIZE, SIZE);
	}
	
	public void collideWith(Hero hero) {
		//checks for collision with hero and tells it what to do if it is colliding
		if (this.overlaps(hero) && readyToCollect) {
			SoundEffect.setToLoud();
			SoundEffect.play("/sound/fruit.wav");
			readyToCollect = false;
			markToRemove();
		}
	}

	@Override
	public void collideWithFloor() {
		yVelocity = 0;
		if (!canRemove) {
			readyToCollect = true;
		}
	}

	@Override
	public void collideWithCeiling() {
		// Nothing happens
	}

	@Override
	public void collideWithWall() {
		// Nothing happens
	}
}
