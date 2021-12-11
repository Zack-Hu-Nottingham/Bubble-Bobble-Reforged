package com.ae2dms.model.gameObject.wall.CollideStrategy;

import com.ae2dms.model.gameObject.sprite.SpriteObject;
import com.ae2dms.model.gameObject.wall.WallObject.WallObject;

/**
 * The collide strategy of floor.
 */
public class CollideWithFloor implements CollideStrategy {

    @Override
    public void collideWith(SpriteObject sprite, WallObject wall) {
        double top = sprite.getY();
        double bottom = top + sprite.getHeight();
        if (wall.overlaps(sprite) && sprite.yVelocity > 0) {
            if (bottom < wall.getY() + wall.getHeight()) {
                wall.moveAboveUnit(sprite);
                sprite.collideWithFloor();
            }
            if (top > wall.getY()){
                wall.moveBelowUnit(sprite);
                sprite.collideWithCeiling();
            }
        }
    }
}
