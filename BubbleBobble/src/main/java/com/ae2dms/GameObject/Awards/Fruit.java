package com.ae2dms.GameObject.Awards;

import com.ae2dms.GameObject.GameObject;
import com.ae2dms.GameObject.Objects.Hero;
import com.ae2dms.UI.InteractableWorld;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


/**
 * The Fruit class handles how the fruit is created and interacts with the hero.
 * The fruits are created after a bubble containing an enemy is popped.
 */
public class Fruit extends GameObject {
	private static final int SIZE = 15;
	private static final int TERMINAL_VELOCITY_Y = 10;
	
	private boolean readyToCollect;

	public Fruit(int x, int y, InteractableWorld world) {
		//initializes fruit
		super(x, y, SIZE, SIZE, world);
		terminal_yVelocity = TERMINAL_VELOCITY_Y;
		readyToCollect = false;
	}

	@Override
	public void drawOn(GraphicsContext g) {
		//draws fruit
		g.setFill(new Color(109,58,150, 100));
		g.fillRect(x, y, SIZE, SIZE);
		g.setFill(Color.BLACK);
	}
	
	public void collideWith(Hero hero) {
		//checks for collision with hero and tells it what to do if it is colliding
		if (this.overlaps(hero) && readyToCollect) {
			main.SoundEffect.FRUIT.setToLoud();
			main.SoundEffect.FRUIT.play();
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
