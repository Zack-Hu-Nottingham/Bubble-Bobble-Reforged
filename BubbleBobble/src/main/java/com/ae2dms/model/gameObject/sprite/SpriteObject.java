package com.ae2dms.model.gameObject.sprite;

import com.ae2dms.model.gameObject.GameObject;
import com.ae2dms.model.scene.GameScene;
import javafx.scene.image.Image;
import javafx.geometry.Point2D;

/**
 * GameObjects are the objects on the InteractableWorld screen.
 * Every GameObject has a velocity, acceleration, position, direction, and dimensions.
 * GameObjects can detect if they are overlapping another GameObject and
 * must implement methods for collisions with every type of Unit.
 */
public abstract class SpriteObject extends GameObject {

	private static final double STATIC_FRICTION = 0.1;
    /**
     * The constant GRAVITY that apply to all the spriteObject.
     */
    protected static final int GRAVITY = 1;
	private static final int TERMINAL_FALL_SPEED = 15;
    /**
     * The Direction of each spriteObject, which would be used to decide
     * which image of sprite would be displayed.
     */
    protected GameScene.Direction direction = GameScene.Direction.RIGHT;

    /**
     * The horizontal velocity of object.
     */
    public double xVelocity;

    /**
     * The vertical velocity of object.
     */
    public double yVelocity;

    /**
     * The horizontal acceleration.
     */
    public double xAccel;

    /**
     * The vertical acceleration.
     */
    public double yAccel;

    /**
     * The max horizontal velocity.
     */
    public int terminal_xVelocity;
    /**
     * The max vertical velocity.
     */
    public int terminal_yVelocity;

    /**
     * The boolean which decides if the object can be removed.
     */
    public boolean canRemove;

    /**
     * Instantiates a new Sprite object.
     *
     * @param x      the x
     * @param y      the y
     * @param width  the width
     * @param height the height
     * @param scene  the scene
     * @param image  the image
     */
    public SpriteObject(double x, double y, int width, int height, GameScene scene, Image image) {
		//initializes the game object
		super(x, y, width, height, scene, image);

		xVelocity = 0;
		yVelocity = 0;
		xAccel = 0;
		yAccel = GRAVITY;
		terminal_xVelocity = 0;
		terminal_yVelocity = TERMINAL_FALL_SPEED;
		canRemove = false;
	}

    /**
     * Turn around the sprite object.
     */
    public void turnAround() {
		if (direction == GameScene.Direction.RIGHT) {
			direction = GameScene.Direction.LEFT;
		} else {
			direction = GameScene.Direction.RIGHT;
		}
	}

    /**
     * Object collide with floor.
     */
    public abstract void collideWithFloor();

    /**
     * Object collide with ceiling.
     */
    public abstract void collideWithCeiling();

    /**
     * Object collide with wall.
     */
    public abstract void collideWithWall();

    /**
     * Update the status of the sprite object, which includes
     * update speed, x-coordinate, y-coordinate.
     */
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
			setX(getX() + xVelocity);
		}
		
		if (yVelocity < terminal_yVelocity) {
			yVelocity += yAccel;
		}
		setY(getY() + yVelocity);

		if (isOffScreen()) {
			if (getY() > getScene().getHeight()) {
				setY(20);
			} else {
				setY(getScene().getHeight());
			}
		}
	}

    /**
     * Reverse direction of sprite object.
     */
    protected void reverseDirection() {
		//reverses game object's direction
		xAccel *= -1;
		turnAround();
	}

    /**
     * Mark that this sprite can be removed.
     */
    protected void markToRemove() {
		//sets whether or not something can be removed
		canRemove = true;
	}

    /**
     * Decides if the sprite is off screen.
     *
     * @return the boolean
     */
    protected boolean isOffScreen() {
		//checks if something is offscreen
		boolean xLow = getX() + getWidth() < 0;
		boolean xHigh = getX() > getScene().getWidth();
		boolean yLow = getY() + getHeight() < 0;
		boolean yHigh = getY() > getScene().getHeight();
		return xLow || xHigh || yLow || yHigh;
	}

    /**
     * Move the sprite object to the required point.
     *
     * @param point the point
     */
    public void moveTo(Point2D point) {
		//moves object to a point
		setX((int) point.getX());
		setY((int) point.getY());
	}
}
