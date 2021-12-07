package com.ae2dms.Model.GameObject.Wall.CollideStrategy;

import com.ae2dms.Model.GameObject.Sprite.SpriteObject;
import com.ae2dms.Model.GameObject.Wall.WallObject.WallObject;

public interface CollideStrategy {

    public void collideWith(SpriteObject sprite, WallObject wall);

}
