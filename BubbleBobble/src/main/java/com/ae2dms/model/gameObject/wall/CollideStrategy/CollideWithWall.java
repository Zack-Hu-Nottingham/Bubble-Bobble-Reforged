package com.ae2dms.model.gameObject.wall.CollideStrategy;

import com.ae2dms.model.gameObject.sprite.SpriteObject;
import com.ae2dms.model.gameObject.wall.WallObject.WallObject;

/**
 * The type Collide with wall.
 */
public class CollideWithWall implements CollideStrategy {

    @Override
    public void collideWith(SpriteObject sprite, WallObject wall) {
        double center = sprite.getX() + sprite.getWidth()/2;
        if (wall.overlaps(sprite)) {
            if (center > wall.getHitbox().getMinX()+wall.getHitbox().getWidth()/2) {
                wall.moveRightOfUnit(sprite);
                sprite.collideWithWall();
            } else if (center < wall.getHitbox().getMinX()+wall.getHitbox().getWidth()/2){
                wall.moveLeftOfUnit(sprite);
                sprite.collideWithWall();
            } else {
                wall.moveBelowUnit(sprite);
                sprite.collideWithCeiling();
            }
        }
    }

}
