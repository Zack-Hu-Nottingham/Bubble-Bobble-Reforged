package com.ae2dms.model.gameObject.wall.collideStrategy;

import com.ae2dms.model.gameObject.sprite.SpriteObject;
import com.ae2dms.model.gameObject.wall.wallObject.WallObject;

/**
 * The collide strategy of ceiling.
 */
public class CollideWithCeiling implements CollideStrategy {

    @Override
    public void collideWith(SpriteObject sprite, WallObject wall) {
        if (wall.overlaps(sprite)) {
            wall.moveBelowUnit(sprite);
            sprite.collideWithCeiling();
        }
    }
}
