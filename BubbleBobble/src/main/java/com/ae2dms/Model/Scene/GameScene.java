package com.ae2dms.Model.Scene;

import com.ae2dms.GamePanel;
import com.ae2dms.Model.GameObject.Sprite.Fruit.Fruit;
import com.ae2dms.Model.GameObject.Sprite.Projectile.BossProjectile;
import com.ae2dms.Model.GameObject.Sprite.Projectile.EnemyProjectile;
import com.ae2dms.Model.GameObject.Sprite.Projectile.HeroProjectile;
import com.ae2dms.Model.GameObject.Sprite.SpriteObject;
import com.ae2dms.Model.GameObject.Sprite.*;
import com.ae2dms.Model.GameObject.Wall.WallObject.CeilingUnit;
import com.ae2dms.Model.GameObject.Wall.WallObject.FloorUnit;
import com.ae2dms.Model.GameObject.Wall.WallObject.WallUnit;
import com.ae2dms.Model.GameObject.Prompt.CollectEffect;
import com.ae2dms.Util.GameScenePainter;
import com.ae2dms.Util.MapReader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

import static com.ae2dms.GamePanel.*;

/**
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


	public ArrayList<CeilingUnit> getCeilingUnits() {
		return ceilingUnits;
	}

	public ArrayList<FloorUnit> getFloorUnits() {
		return floorUnits;
	}

	public ArrayList<WallUnit> getWallUnits() {
		return wallUnits;
	}

	public ArrayList<Hero> getHeroes() {
		return heroes;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public ArrayList<HeroProjectile> getHeroProjectiles() {
		return heroProjectiles;
	}

	public ArrayList<EnemyProjectile> getEnemyProjectiles() {
		return enemyProjectiles;
	}

	public ArrayList<BossProjectile> getBossProjectiles() {
		return bossProjectiles;
	}

	public ArrayList<Fruit> getFruits() {
		return fruits;
	}

	public ArrayList<SpriteObject> getToBeRemoved() {
		return toBeRemoved;
	}

	public ArrayList<Bubble> getBubbles() {
		return bubbles;
	}

	public ArrayList<CollectEffect> getCollectEffects() {
		return collectEffects;
	}

	public ArrayList<Boss> getBosses() {
		return bosses;
	}

	public GraphicsContext getGraphicsContext() {
		return graphicsContext;
	}

	public MapReader getMapReader() { return mapReader; }

	public GameScenePainter getGameScenePainter() {	return gameScenePainter; }



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

		mapReader = MapReader.getInstance();

		mapReader.setGameScene(this);

		mapReader.readMap(GamePanel.level.getValue());

		gameScenePainter = GameScenePainter.getInstance();

		gameScenePainter.setGameScene(this);
	}

	public void addCeilingUnit(CeilingUnit ceilingUnit) {
		ceilingUnits.add(ceilingUnit);
	}

	public void addFloorUnit(FloorUnit floorUnit) {
		floorUnits.add(floorUnit);
	}

	public void addWallUnit(WallUnit wallUnit) {
		wallUnits.add(wallUnit);
	}

	public void addHero(Hero hero) {
		//adds a hero to the map
		heroes.add(hero);
	}

	public void addEnemy(Enemy enemy) {
		//adds a mook to the map
		enemies.add(enemy);
	}

	public void addHeroProjectile(HeroProjectile heroProjectile) {
		//adds a projectile to where necessary
		heroProjectiles.add(heroProjectile);
	}

	public void addEnemyProjectile(EnemyProjectile enemyProjectile) {
		//adds a projectile to where necessary
		enemyProjectiles.add(enemyProjectile);
	}

	public void addBossProjectile(BossProjectile bossProjectile) {
		//adds a projectile to where necessary
		bossProjectiles.add(bossProjectile);
	}

	public void addFruit(Fruit fruit) {
		//adds fruit on bubble pop
		fruits.add(fruit);
	}

	public void addBubble(Bubble bubble) {
		//adds special bubble
		bubbles.add(bubble);
	}

	public void addCollectEffect(CollectEffect collectEffect) {
		collectEffects.add(collectEffect);
	}

	public void addBoss(Boss boss) { bosses.add(boss); }

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
	}


	public int getHeight() {
		return HEIGHT * UNIT_SIZE;
	}

	public int getWidth() {
		return WIDTH * UNIT_SIZE;
	}

	public void getCanvas(Canvas canvas) {
		graphicsContext = canvas.getGraphicsContext2D();
	}

	public enum Direction {
		LEFT, RIGHT
	}
}
