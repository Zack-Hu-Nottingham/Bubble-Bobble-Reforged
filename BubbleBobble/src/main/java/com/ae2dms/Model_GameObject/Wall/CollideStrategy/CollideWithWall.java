package com.ae2dms.Model_GameObject.Wall.CollideStrategy;

import com.ae2dms.Model_GameObject.Sprite.SpriteObject;
import com.ae2dms.Model_GameObject.Wall.WallObject.WallObject;

public class CollideWithWall implements CollideStrategy {

    @Override
    public void collideWith(SpriteObject sprite, WallObject wall) {
        double center = sprite.x + sprite.getWidth()/2;
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
