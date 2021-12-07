package com.ae2dms.Model.GameObject.Sprite.Fruit.fruitFactory;

import com.ae2dms.Model.GameObject.Sprite.Fruit.*;
import com.ae2dms.Model.Scene.GameScene;

public abstract class FruitFactory {
//    public class FruitFactory {
//    public static void generateFruit() {}

    public abstract Fruit getFruit(int x, int y, GameScene gameScene);

//    public Fruit getFruit(int x, int y, GameScene world, Double typeOfFruit) {
////        Double choice = Math.random();
//        if (typeOfFruit < 0.30) {
//            return new Apple(x, y, world);
//        } else if (typeOfFruit < 0.60) {
//            return new Banana(x, y, world);
//        } else if (typeOfFruit < 0.90) {
//            return new StrawBerry(x, y, world);
//        } else {
//            return new Lucky(x, y, world);
//        }
//    }
}
