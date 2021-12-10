package com.ae2dms.model.gameObject.sprite.projectile;

import com.ae2dms.model.gameObject.sprite.SpriteObject;
import com.ae2dms.model.scene.GameScene;
import javafx.scene.image.Image;

/**
 * The abstract class projectile, which defines a lot of parameters that could
 * be shared among all kinds of projectile.
 */
public abstract class Projectile extends SpriteObject {

    /**
     * The constant SPEED, the speed of projectile.
     */
    protected static final int SPEED = 15;

    /**
     * The constant TERMINAL_VELOCITY_Y, the max vertical velocity.
     */
    protected static final int TERMINAL_VELOCITY_Y = 5;

    /**
     * The boolean flag tells if the bubble is on active status.
     */
    protected boolean isActive;

    /**
     * The number of frames that the bubble is active.
     */
    protected int activeFrames;

    /**
     * The Timer which counts how long the projectile stays active.
     */
    protected int timer;

    /**
     * Instantiates a new Projectile.
     *
     * @param x      the x-coordinate of projectile
     * @param y      the y-coordinate of projectile
     * @param width  the width
     * @param height the height
     * @param scene  the scene that the projectile belongs to
     * @param image  the image of projectile
     */
    public Projectile(double x, double y, int width, int height, GameScene scene, Image image) {
        super(x, y, width, height, scene, image);

        this.direction = direction;

        xVelocity = SPEED;
        yAccel = 0;

        isActive = true;
    }


    @Override
    public void update() {
        setY(getY() + yVelocity);
        if (direction == GameScene.Direction.LEFT) {
            setX(getX() - xVelocity);
        } else {
            setX(getX() + xVelocity);
        }
        updateVelocity();

        if(getY() < 25) {
            setY(25);
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
}
