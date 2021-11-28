package com.ae2dms.GameObject.Wall.CollideStrategy;

import com.ae2dms.GameObject.Sprite.SpriteObject;
import com.ae2dms.GameObject.Wall.WallObject.WallObject;

public interface CollideStrategy {

    public void collideWith(SpriteObject sprite, WallObject wall);

}
