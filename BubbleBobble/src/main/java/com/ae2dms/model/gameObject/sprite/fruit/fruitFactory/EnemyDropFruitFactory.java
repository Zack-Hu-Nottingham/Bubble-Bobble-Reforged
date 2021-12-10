package com.ae2dms.model.gameObject.sprite.fruit.fruitFactory;

import com.ae2dms.model.gameObject.sprite.fruit.fruits.Apple;
import com.ae2dms.model.gameObject.sprite.fruit.fruits.Banana;
import com.ae2dms.model.gameObject.sprite.fruit.fruits.Fruit;
import com.ae2dms.model.gameObject.sprite.fruit.fruits.StrawBerry;
import com.ae2dms.model.scene.GameScene;

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
