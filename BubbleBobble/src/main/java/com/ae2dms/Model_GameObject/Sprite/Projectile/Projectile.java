package com.ae2dms.Model_GameObject.Sprite.Projectile;

import com.ae2dms.Model_GameObject.Sprite.SpriteObject;
import com.ae2dms.Scene.GameScene;
import javafx.scene.image.Image;

public abstract class Projectile extends SpriteObject {

    protected static final int SPEED = 15;
    protected static final int TERMINAL_VELOCITY_Y = 5;

    protected boolean isActive;
    protected int activeFrames;
    protected int timer;

    public Projectile(int x, int y, int width, int height, GameScene scene, Image image) {
        super(x, y, width, height, scene, image);

        this.direction = direction;

        xVelocity = SPEED;
        yAccel = 0;

        isActive = true;
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
}
