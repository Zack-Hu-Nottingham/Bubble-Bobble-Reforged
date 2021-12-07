package com.ae2dms.Model.GameObject.Sprite.Fruit.fruitFactory;

import com.ae2dms.Model.GameObject.Sprite.Fruit.*;
import com.ae2dms.Model.Scene.GameScene;

public abstract class FruitFactory {

    public abstract Fruit getFruit(int x, int y, GameScene gameScene);

}
