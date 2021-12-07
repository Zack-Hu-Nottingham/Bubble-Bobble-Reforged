package com.ae2dms.Model.GameObject.Sprite.Fruit.fruitFactory;

import com.ae2dms.Model.GameObject.Sprite.Fruit.Apple;
import com.ae2dms.Model.GameObject.Sprite.Fruit.Banana;
import com.ae2dms.Model.GameObject.Sprite.Fruit.Fruit;
import com.ae2dms.Model.GameObject.Sprite.Fruit.StrawBerry;
import com.ae2dms.Model.Scene.GameScene;

public class EnemyDropFruitFactory extends FruitFactory{

    @Override
    public Fruit getFruit(int x, int y, GameScene gameScene) {
        Double typeOfFruit = Math.random();
        if (typeOfFruit < 0.33) {
            return new Apple(x, y, gameScene);
        } else if (typeOfFruit < 0.66) {
            return new Banana(x, y, gameScene);
        } else  {
            return new StrawBerry(x, y, gameScene);
        }
    }
}
