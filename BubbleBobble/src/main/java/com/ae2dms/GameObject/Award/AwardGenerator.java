package com.ae2dms.GameObject.Award;

import com.ae2dms.Scene.GameScene;

public class AwardGenerator {
    public static void generateFruit() {}

    public Award getFruit(int x, int y, GameScene world) {
        Double choice = Math.random();
        if (choice < 0.30) {
            return new Apple(x, y, world);
        } else if (choice < 0.60) {
            return new Banana(x, y, world);
        } else if (choice < 0.90) {
            return new StrawBerry(x, y, world);
        } else {
            return new Lucky(x, y, world);
        }
    }
}
