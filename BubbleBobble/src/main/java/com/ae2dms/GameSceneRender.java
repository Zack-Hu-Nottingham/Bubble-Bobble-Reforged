package com.ae2dms;

import com.ae2dms.GameObject.Award.Fruit;
import com.ae2dms.GameObject.Sprite.*;
import com.ae2dms.GameObject.Wall.WallObject.CeilingUnit;
import com.ae2dms.GameObject.Wall.WallObject.FloorUnit;
import com.ae2dms.GameObject.Wall.WallObject.WallUnit;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class GameSceneRender {

    private ArrayList<CeilingUnit> ceilingUnits;
    private ArrayList<FloorUnit> floorUnits;
    private ArrayList<WallUnit> wallUnits;
    private ArrayList<Hero> heroes;
    private ArrayList<Enemy> enemies;
    private ArrayList<HeroProjectile> heroProjectiles;
    private ArrayList<EnemyProjectile> enemyProjectiles;
    private ArrayList<Fruit> fruits;
    private ArrayList<SpriteObject> toBeRemoved;
    private ArrayList<Bubble> bubbles;

    public GameSceneRender() {

        ceilingUnits = new ArrayList<CeilingUnit>();
        floorUnits = new ArrayList<FloorUnit>();
        wallUnits = new ArrayList<WallUnit>();
        heroes = new ArrayList<Hero>();
        enemies = new ArrayList<Enemy>();
        heroProjectiles = new ArrayList<HeroProjectile>();
        enemyProjectiles = new ArrayList<EnemyProjectile>();
        fruits = new ArrayList<Fruit>();
        toBeRemoved = new ArrayList<SpriteObject>();
        bubbles = new ArrayList<Bubble>();

    }



    public void paintComponent(GraphicsContext g) {
        //paints everything on the world
//        System.out.println(bonus);
        GraphicsContext g2 = (GraphicsContext) g;
        g2.clearRect(0, 0, 1280, 720);

        for (CeilingUnit ceilingUnit : ceilingUnits) {
            ceilingUnit.drawOn(g2);
        }
        for (FloorUnit floorUnit : floorUnits) {
            floorUnit.drawOn(g2);
        }
        for (WallUnit wallUnit : wallUnits) {
            wallUnit.drawOn(g2);
        }
        for (Hero hero : heroes) {
            hero.drawOn(g2);
        }
        for (Enemy enemy : enemies) {
            enemy.drawOn(g2);
        }
        for (EnemyProjectile enemyProjectile : enemyProjectiles) {
            enemyProjectile.drawOn(g2);
        }
        for (HeroProjectile heroProjectile : heroProjectiles) {
            heroProjectile.drawOn(g2);
        }
        for (Fruit fruit : fruits) {
            fruit.drawOn(g2);
        }
        for (Bubble bubble : bubbles) {
            bubble.drawOn(g2);
        }
    }

}
