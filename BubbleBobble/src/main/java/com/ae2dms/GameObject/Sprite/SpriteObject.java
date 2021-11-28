package com.ae2dms.GameObject.Sprite;


import com.ae2dms.GameObject.GameObject;
import com.ae2dms.Scene.GameScene;
import javafx.scene.image.Image;

import javafx.geometry.Rectangle2D;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;


/**
 * GameObjects are the objects on the InteractableWorld screen.
 * Every GameObject has a velocity, acceleration, position, direction, and dimensions.
 * GameObjects can detect if they are overlapping another GameObject and
 * must implement methods for collisions with every type of Unit.
 */
public abstract class SpriteObject extends GameObject {
//	private Image image;
	private static final double STATIC_FRICTION = 0.1;
	protected static final int GRAVITY = 1;
	private static final int TERMINAL_FALL_SPEED = 20;
	
//	public GameScene scene;
//	public int x, y;
//	public int width, height;
	
	public double xVelocity, yVelocity;
	public double xAccel, yAccel;
	public int terminal_xVelocity, terminal_yVelocity;
	
	public boolean canRemove;
	public int direction;

	
	public SpriteObject(int x, int y, int width, int height, GameScene scene, Image image) {
		//initializes the game object
		super(x, y, width, height, scene, image);

		xVelocity = 0;
		yVelocity = 0;
		xAccel = 0;
		yAccel = GRAVITY;
		terminal_xVelocity = 0;
		terminal_yVelocity = TERMINAL_FALL_SPEED;
		canRemove = false;
		direction = -1;
	}

	public void drawOn(GraphicsContext graphicsContext) {
		graphicsContext.drawImage(image, x, y, width, height);
	}
//	public abstract void drawOn(GraphicsContext g);
	public abstract void collideWithFloor();
	public abstract void collideWithCeiling();
	public abstract void collideWithWall();
	
	protected void update() {
		//general update method of every game object
		if (Math.abs(xVelocity) < terminal_xVelocity) {
			xVelocity += xAccel;
		}
		if (Math.abs(xVelocity) > STATIC_FRICTION) {
			if (xVelocity < 0) {
				xVelocity += 1;
			} else {
				xVelocity -= 1;
			}
			x += xVelocity;
		}
		
		if (yVelocity < terminal_yVelocity) {
			yVelocity += yAccel;
		}
		y += yVelocity;

		if (isOffScreen()) {
			System.out.println("out");
			if (y > scene.getHeight()) {
				System.out.println("y>height");
				y = 0;
			} else {
				y = scene.getHeight();
			}
		}
	}
	
	protected void reverseDirection() {
		//reverses game object's direction
		xAccel *= -1;
		direction *= -1;
	}
	
	public double getX() {
		//returns x coordinate of upper left corner
		return x;
	}
	public double getY() {
		//returns y coordinate of upper left corner
		return y;
	}
	public double getWidth() {
		//returns width
		return width;
	}
	public double getHeight() {
		//returns height
		return height;
	}
	
	protected void markToRemove() {
		//sets whether or not something can be removed
		canRemove = true;
	}
	
	public Rectangle2D getHitbox(){
		//sets hitbox for each game object
		return new Rectangle2D(x, y, width, height);
	}
	
	protected boolean overlaps(GameObject obj) {
		//checks if two objects overlap or collide
		return getHitbox().intersects(obj.getHitbox());
	}
	
	protected boolean isOffScreen() {
		//checks if something is offscreen
		boolean xLow = x + width < 0;
		boolean xHigh = x > scene.getWidth();
		boolean yLow = y + height < 0;
		boolean yHigh = y > scene.getHeight();
		return xLow || xHigh || yLow || yHigh;
	}
	
	public void moveTo(Point2D point) {
		//moves object to a point
		x = (int) point.getX();
		y = (int) point.getY();
	}
}
