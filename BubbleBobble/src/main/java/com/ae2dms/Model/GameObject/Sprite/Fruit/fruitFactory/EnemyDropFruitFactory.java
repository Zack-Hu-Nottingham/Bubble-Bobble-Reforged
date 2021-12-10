package com.ae2dms.Model.GameObject.Sprite.Fruit.fruitFactory;

import com.ae2dms.Model.GameObject.Sprite.Fruit.fruit.Apple;
import com.ae2dms.Model.GameObject.Sprite.Fruit.fruit.Banana;
import com.ae2dms.Model.GameObject.Sprite.Fruit.Fruit;
import com.ae2dms.Model.GameObject.Sprite.Fruit.fruit.StrawBerry;
import com.ae2dms.Model.Scene.GameScene;

/**
 * The type Enemy drop fruit factory.
 */
public class EnemyDropFruitFactory extends FruitFactory{

    @Override
    public Fruit getFruit(double x, double y, GameScene gameScene) {
        Double typeOfFruit = Math.random();
        if (typeOfFruit < 0.60) {
            return new Apple(x, y, gameScene);
        } else if (typeOfFruit < 0.80) {
            return new Banana(x, y, gameScene);
        } else  {
            return new StrawBerry(x, y, gameScene);
        }
    }

}
