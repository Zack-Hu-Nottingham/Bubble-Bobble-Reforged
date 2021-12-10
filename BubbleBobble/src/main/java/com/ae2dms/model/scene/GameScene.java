package com.ae2dms.model.scene;

import com.ae2dms.model.gameObject.sprite.character.Boss;
import com.ae2dms.model.gameObject.sprite.character.Enemy;
import com.ae2dms.model.gameObject.sprite.character.Hero;
import com.ae2dms.model.gameObject.sprite.fruit.Fruit;
import com.ae2dms.model.gameObject.sprite.projectile.BossProjectile;
import com.ae2dms.model.gameObject.sprite.projectile.Bubble;
import com.ae2dms.model.gameObject.sprite.projectile.EnemyProjectile;
import com.ae2dms.model.gameObject.sprite.projectile.HeroProjectile;
import com.ae2dms.model.gameObject.sprite.SpriteObject;
import com.ae2dms.model.gameObject.wall.WallObject.CeilingUnit;
import com.ae2dms.model.gameObject.wall.WallObject.FloorUnit;
import com.ae2dms.model.gameObject.wall.WallObject.WallUnit;
import com.ae2dms.model.gameObject.sprite.prompt.CollectEffect;
import com.ae2dms.util.GameScenePainter;
import com.ae2dms.util.MapReader;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

import static com.ae2dms.GamePanel.*;

/**
 * GameScene is an overall model, its controller is GameSceneController,
 * with GameScene.fxml as view. GameScene contains smaller model such as hero,
 * enemy, furit.. it maintains a set of array of these smaller models, and when
 * gameScene is initialized all these small models would be initialized as well.
 * <p>
 * InteractableWorld handles all of the game's operations:
 * updating positions, checking for collisions, and removing objects.
 */
public class GameScene {

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
	private ArrayList<CollectEffect> collectEffects;
	private ArrayList<BossProjectile> bossProjectiles;
	private ArrayList<Boss> bosses;

	private GraphicsContext graphicsContext;
	private MapReader mapReader;
	private GameScenePainter gameScenePainter;



//	/**
//	 * The gameTimer that records the time of the game.
//	 */
//	public static GameTimer gameTimer;
//	/**
//	 * The bonus earned through the game.
//	 */
//	public static IntegerProperty bonus;
	/**
	 * The gameStatus of the game.
	 */
	public static GameStatus gameStatus;
	/**
	 * The level of the current game.
	 */
	public static IntegerProperty level;
	/**
	 * The chargeLevel of hero.
	 */
	public static int chargeLevel;

    /**
     * Gets ceiling units.
     *
     * @return the ceiling units
     */
    public ArrayList<CeilingUnit> getCeilingUnits() {
		return ceilingUnits;
	}

    /**
     * Gets floor units.
     *
     * @return the floor units
     */
    public ArrayList<FloorUnit> getFloorUnits() {
		return floorUnits;
	}

    /**
     * Gets wall units.
     *
     * @return the wall units
     */
    public ArrayList<WallUnit> getWallUnits() {
		return wallUnits;
	}

    /**
     * Gets heroes.
     *
     * @return the heroes
     */
    public ArrayList<Hero> getHeroes() {
		return heroes;
	}

    /**
     * Gets enemies.
     *
     * @return the enemies
     */
    public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

    /**
     * Gets hero projectiles.
     *
     * @return the hero projectiles
     */
    public ArrayList<HeroProjectile> getHeroProjectiles() {
		return heroProjectiles;
	}

    /**
     * Gets enemy projectiles.
     *
     * @return the enemy projectiles
     */
    public ArrayList<EnemyProjectile> getEnemyProjectiles() {
		return enemyProjectiles;
	}

    /**
     * Gets boss projectiles.
     *
     * @return the boss projectiles
     */
    public ArrayList<BossProjectile> getBossProjectiles() {
		return bossProjectiles;
	}

    /**
     * Gets fruits.
     *
     * @return the fruits
     */
    public ArrayList<Fruit> getFruits() {
		return fruits;
	}

    /**
     * Gets to be removed.
     *
     * @return the to be removed
     */
    public ArrayList<SpriteObject> getToBeRemoved() {
		return toBeRemoved;
	}

    /**
     * Gets bubbles.
     *
     * @return the bubbles
     */
    public ArrayList<Bubble> getBubbles() {
		return bubbles;
	}

    /**
     * Gets collect effects.
     *
     * @return the collect effects
     */
    public ArrayList<CollectEffect> getCollectEffects() {
		return collectEffects;
	}

    /**
     * Gets bosses.
     *
     * @return the bosses
     */
    public ArrayList<Boss> getBosses() {
		return bosses;
	}

    /**
     * Gets graphics context.
     *
     * @return the graphics context
     */
    public GraphicsContext getGraphicsContext() {
		return graphicsContext;
	}

    /**
     * Gets map reader.
     *
     * @return the map reader
     */
    public MapReader getMapReader() {
		return mapReader;
	}

    /**
     * Gets game scene painter.
     *
     * @return the game scene painter
     */
    public GameScenePainter getGameScenePainter() {
		return gameScenePainter;
	}

    /**
     * Gets height.
     *
     * @return the height
     */
    public int getHeight() {
		return HEIGHT * UNIT_SIZE;
	}

    /**
     * Gets width.
     *
     * @return the width
     */
    public int getWidth() {
		return WIDTH * UNIT_SIZE;
	}

    /**
     * Gets canvas.
     *
     * @param canvas the canvas
     */
    public void getCanvas(Canvas canvas) {
		graphicsContext = canvas.getGraphicsContext2D();
	}


    /**
     * Add ceiling unit.
     *
     * @param ceilingUnit the ceiling unit
     */
    public void addCeilingUnit(CeilingUnit ceilingUnit) {
		ceilingUnits.add(ceilingUnit);
	}

    /**
     * Add floor unit.
     *
     * @param floorUnit the floor unit
     */
    public void addFloorUnit(FloorUnit floorUnit) {
		floorUnits.add(floorUnit);
	}

    /**
     * Add wall unit.
     *
     * @param wallUnit the wall unit
     */
    public void addWallUnit(WallUnit wallUnit) {
		wallUnits.add(wallUnit);
	}

    /**
     * Add hero.
     *
     * @param hero the hero
     */
    public void addHero(Hero hero) {
		//adds a hero to the map
		heroes.add(hero);
	}

    /**
     * Add enemy.
     *
     * @param enemy the enemy
     */
    public void addEnemy(Enemy enemy) {
		//adds a mook to the map
		enemies.add(enemy);
	}

    /**
     * Add hero projectile.
     *
     * @param heroProjectile the hero projectile
     */
    public void addHeroProjectile(HeroProjectile heroProjectile) {
		//adds a projectile to where necessary
		heroProjectiles.add(heroProjectile);
	}

    /**
     * Add enemy projectile.
     *
     * @param enemyProjectile the enemy projectile
     */
    public void addEnemyProjectile(EnemyProjectile enemyProjectile) {
		//adds a projectile to where necessary
		enemyProjectiles.add(enemyProjectile);
	}

    /**
     * Add boss projectile.
     *
     * @param bossProjectile the boss projectile
     */
    public void addBossProjectile(BossProjectile bossProjectile) {
		//adds a projectile to where necessary
		bossProjectiles.add(bossProjectile);
	}

    /**
     * Add fruit.
     *
     * @param fruit the fruit
     */
    public void addFruit(Fruit fruit) {
		//adds fruit on bubble pop
		fruits.add(fruit);
	}

    /**
     * Add bubble.
     *
     * @param bubble the bubble
     */
    public void addBubble(Bubble bubble) {
		//adds special bubble
		bubbles.add(bubble);
	}

    /**
     * Add collect effect.
     *
     * @param collectEffect the collect effect
     */
    public void addCollectEffect(CollectEffect collectEffect) {
		collectEffects.add(collectEffect);
	}

    /**
     * Add boss.
     *
     * @param boss the boss
     */
    public void addBoss(Boss boss) { bosses.add(boss); }


    /**
     * Instantiates a new Game scene, which would initialize all the
     * sub-models that might be used according to map. And it would
     * initialize an gamePainter to constantly refresh the game scene.
     */
    public GameScene() {
		//initializes interactableworld
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
		collectEffects = new ArrayList<CollectEffect>();
		bosses = new ArrayList<Boss>();
		bossProjectiles = new ArrayList<BossProjectile>();

		chargeLevel = 0;

		level = new SimpleIntegerProperty(1);

		mapReader = MapReader.getInstance();

		mapReader.setGameScene(this);

		mapReader.readMap(level.getValue());

		gameScenePainter = GameScenePainter.getInstance();

		gameScenePainter.setGameScene(this);
	}

    /**
     * Remove all the objects to clear all the sub-models in GameScene.
     */
    public void clearContents() {
		//clears everything from the screen
		ceilingUnits.removeAll(ceilingUnits);
		floorUnits.removeAll(floorUnits);
		wallUnits.removeAll(wallUnits);
		heroes.removeAll(heroes);
		enemies.removeAll(enemies);
		enemyProjectiles.removeAll(enemyProjectiles);
		heroProjectiles.removeAll(heroProjectiles);
		fruits.removeAll(fruits);
	}

    /**
     * Remove object from the corresponding arraylist.
     *
     * @param obj the obj
     */
    public void remove(SpriteObject obj) {
		//removes a single object from the screen
		ceilingUnits.remove(obj);
		floorUnits.remove(obj);
		wallUnits.remove(obj);
		heroes.remove(obj);
		enemies.remove(obj);
		enemyProjectiles.remove(obj);
		heroProjectiles.remove(obj);
		fruits.remove(obj);
		bubbles.remove(obj);
		collectEffects.remove(obj);
		bosses.remove(obj);
		bossProjectiles.remove(obj);
	}


    /**
     * The enumeration direction, which is used to represent the direction of sprite
     * such as hero, enemy and boss.
     */
    public enum Direction {
        /**
         * Left direction.
         */
        LEFT,
        /**
         * Right direction.
         */
        RIGHT
	}
}
