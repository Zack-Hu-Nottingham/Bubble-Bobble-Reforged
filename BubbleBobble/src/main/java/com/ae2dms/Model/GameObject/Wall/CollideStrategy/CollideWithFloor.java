package com.ae2dms.Model.GameObject.Wall.CollideStrategy;

import com.ae2dms.Model.GameObject.Sprite.SpriteObject;
import com.ae2dms.Model.GameObject.Wall.WallObject.WallObject;

public class CollideWithFloor implements CollideStrategy {

    @Override
    public void collideWith(SpriteObject sprite, WallObject wall) {
        double top = sprite.getY();
        double bottom = top + sprite.getHeight();
        if (wall.overlaps(sprite) && sprite.yVelocity > 0) {
            if (bottom < wall.y + wall.height) {
                wall.moveAboveUnit(sprite);
                sprite.collideWithFloor();
            }
            if (top > wall.y){
                wall.moveBelowUnit(sprite);
                sprite.collideWithCeiling();
            }
        }
    }
}
