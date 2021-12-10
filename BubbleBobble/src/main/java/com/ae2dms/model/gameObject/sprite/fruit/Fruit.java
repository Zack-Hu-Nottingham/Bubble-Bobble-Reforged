package com.ae2dms.model.gameObject.sprite.fruit;

import com.ae2dms.model.gameObject.sprite.character.Hero;
import com.ae2dms.model.gameObject.sprite.SpriteObject;
import com.ae2dms.GamePanel;
import com.ae2dms.model.scene.GameScene;
import com.ae2dms.model.gameObject.sprite.prompt.CollectEffect;
import com.ae2dms.util.SoundEffect;
import javafx.scene.image.Image;


/**
 * The Fruit class handles how the fruit is created and interacts with the hero.
 * The fruits are created after a bubble containing an enemy is popped.
 */
public abstract class Fruit extends SpriteObject {
	private static final int SIZE = 30;
	private static final int TERMINAL_VELOCITY_Y = 10;
	
	private boolean readyToCollect;
    /**
     * The Bonus.
     */
    protected int bonus;
    /**
     * The Collect effect.
     */
    public CollectEffect collectEffect ;


    /**
     * Instantiates a new Fruit.
     *
     * @param x     the x
     * @param y     the y
     * @param world the world
     * @param image the image
     */
    public Fruit(double x, double y, GameScene world, Image image) {
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


    /**
     * Collide with.
     *
     * @param hero the hero
     */
    public void collideWith(Hero hero) {
		//checks for collision with hero and tells it what to do if it is colliding
		if (this.overlaps(hero) && readyToCollect) {
			SoundEffect.getInstance().play("fruit");
			collectEffect = new CollectEffect(getX(), getY(), getScene(), null, bonus);
			getScene().addCollectEffect(this.collectEffect);
			GamePanel.incrementBonus(bonus);
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
