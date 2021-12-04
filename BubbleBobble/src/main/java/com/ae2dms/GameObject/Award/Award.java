package com.ae2dms.GameObject.Award;

import com.ae2dms.GameObject.Sprite.Hero;
import com.ae2dms.GameObject.Sprite.SpriteObject;
import com.ae2dms.Scene.GameScene;
import com.ae2dms.GameObject.Sprite.CollectEffect;
import com.ae2dms.Util.SoundEffect;
import javafx.scene.image.Image;


/**
 * The Fruit class handles how the fruit is created and interacts with the hero.
 * The fruits are created after a bubble containing an enemy is popped.
 */
public abstract class Award extends SpriteObject {
	private static final int SIZE = 30;
	private static final int TERMINAL_VELOCITY_Y = 10;
	
	private boolean readyToCollect;
	protected int bonus;
	public CollectEffect collectEffect ;

//	protected Image awardImage;



	public Award(int x, int y, GameScene world, Image image) {
		//initializes fruit
		super(x, y, SIZE, SIZE, world, image);
//		this.awardImage = fruitImage;
		terminal_yVelocity = TERMINAL_VELOCITY_Y;
		readyToCollect = false;
	}

	@Override
	public void update() {
		super.update();
	}

//	@Override
//	public void drawOn(GraphicsContext g) {
//		//draws fruit
//		g.drawImage(awardImage, x, y, SIZE, SIZE);
//	}
	
	public void collideWith(Hero hero) {
		//checks for collision with hero and tells it what to do if it is colliding
		if (this.overlaps(hero) && readyToCollect) {
//			SoundEffect.setToLoud();
			SoundEffect.play("/sound/fruit.wav");
//			GameScene.score  += this.bonus;
//			GameScene.bonus += this.bonus;
//			this.x;
//			this.y;
			collectEffect = new CollectEffect(x, y, scene, null, bonus);
			scene.addCollectEffect(this.collectEffect);
			// 不规范
//			collectEffect.canRemove = true;
//			this.collectEffect

//			hero.
//			GameSceneController.bonus.set(String.valueOf(GameScene.bonus));
			scene.incrementBonus(bonus);
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
