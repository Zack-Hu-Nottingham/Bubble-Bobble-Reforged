package com.ae2dms.Scene;

import com.ae2dms.Model_GameObject.Sprite.Fruit.Fruit;
import com.ae2dms.Model_GameObject.Sprite.Projectile.EnemyProjectile;
import com.ae2dms.Model_GameObject.Sprite.Projectile.HeroProjectile;
import com.ae2dms.Model_GameObject.Sprite.SpriteObject;
import com.ae2dms.Model_GameObject.Sprite.*;
import com.ae2dms.Model_GameObject.Wall.WallObject.CeilingUnit;
import com.ae2dms.Model_GameObject.Wall.WallObject.FloorUnit;
import com.ae2dms.Model_GameObject.Wall.WallObject.WallUnit;
import com.ae2dms.Model_GameObject.Prompt.CollectEffect;
import com.ae2dms.Util.MapReader;
import com.ae2dms.Util.SoundEffect;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

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


	public ArrayList<CeilingUnit> getCeilingUnits() {
		return ceilingUnits;
	}

	public void setCeilingUnits(ArrayList<CeilingUnit> ceilingUnits) {
		this.ceilingUnits = ceilingUnits;
	}

	public ArrayList<FloorUnit> getFloorUnits() {
		return floorUnits;
	}

	public void setFloorUnits(ArrayList<FloorUnit> floorUnits) {
		this.floorUnits = floorUnits;
	}

	public ArrayList<WallUnit> getWallUnits() {
		return wallUnits;
	}

	public void setWallUnits(ArrayList<WallUnit> wallUnits) {
		this.wallUnits = wallUnits;
	}

	public ArrayList<Hero> getHeroes() {
		return heroes;
	}

	public void setHeroes(ArrayList<Hero> heroes) {
		this.heroes = heroes;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public ArrayList<HeroProjectile> getHeroProjectiles() {
		return heroProjectiles;
	}

	public void setHeroProjectiles(ArrayList<HeroProjectile> heroProjectiles) {
		this.heroProjectiles = heroProjectiles;
	}

	public ArrayList<EnemyProjectile> getEnemyProjectiles() {
		return enemyProjectiles;
	}

	public void setEnemyProjectiles(ArrayList<EnemyProjectile> enemyProjectiles) {
		this.enemyProjectiles = enemyProjectiles;
	}

	public ArrayList<Fruit> getFruits() {
		return fruits;
	}

	public void setFruits(ArrayList<Fruit> fruits) {
		this.fruits = fruits;
	}

	public ArrayList<SpriteObject> getToBeRemoved() {
		return toBeRemoved;
	}

	public void setToBeRemoved(ArrayList<SpriteObject> toBeRemoved) {
		this.toBeRemoved = toBeRemoved;
	}

	public ArrayList<Bubble> getBubbles() {
		return bubbles;
	}

	public void setBubbles(ArrayList<Bubble> bubbles) {
		this.bubbles = bubbles;
	}

	public ArrayList<CollectEffect> getCollectEffects() {
		return collectEffects;
	}

	public void setCollectEffects(ArrayList<CollectEffect> collectEffects) {
		this.collectEffects = collectEffects;
	}

	public GraphicsContext getGraphicsContext() {
		return graphicsContext;
	}

	public void setGraphicsContext(GraphicsContext graphicsContext) {
		this.graphicsContext = graphicsContext;
	}

	private GraphicsContext graphicsContext;


	private MapReader mapReader;

	public int delay = 180;

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

		mapReader = MapReader.getInstance();
		mapReader.setGameScene(this);
	}


	public void updatePosition() {
		//updates positions of everything on screen
		for (Hero hero : heroes) {
			hero.update();
		}
		for (Enemy enemy : enemies) {
			enemy.update();
			if(enemy.canRemove) {
				toBeRemoved.add(enemy);
			}
		}
		for (EnemyProjectile enemyProjectile : enemyProjectiles) {
			enemyProjectile.update();
			if (enemyProjectile.canRemove) {
				toBeRemoved.add(enemyProjectile);
			}
		}
		for (HeroProjectile heroProjectile : heroProjectiles) {
			heroProjectile.update();
			if (heroProjectile.canRemove) {
				toBeRemoved.add(heroProjectile);
			}
		}
		for (Fruit fruit : fruits) {
			fruit.update();
			if (fruit.canRemove) {
				toBeRemoved.add(fruit);
			}
		}
		for (Bubble bubble : bubbles) {
			//charge = 0;
			bubble.update();
			if (bubble.canRemove) {
				toBeRemoved.add(bubble);
			}
		}
		for (CollectEffect collectEffect : collectEffects) {
			collectEffect.update();
			if (collectEffect.canRemove) {
				toBeRemoved.add(collectEffect);
			}
		}

		// Colliding...
		// Units initiate collisions with Heroes, Enemies, and Fruits
		for (CeilingUnit ceilingUnit : ceilingUnits) {
			for (Hero hero : heroes) {
				ceilingUnit.collideWith(hero);
			}
			for (Enemy enemy : enemies) {
				ceilingUnit.collideWith(enemy);
				enemy.collideWith(ceilingUnit);
			}
			for (Fruit fruit : fruits) {
				ceilingUnit.collideWith(fruit);
			}
			for (EnemyProjectile enemyProjectile : enemyProjectiles) {
				ceilingUnit.collideWith(enemyProjectile);
			}
			for (HeroProjectile heroProjectile : heroProjectiles) {
				ceilingUnit.collideWith(heroProjectile);
			}
		}
		for (FloorUnit floorUnit: floorUnits) {
			for (Hero hero : heroes) {
				floorUnit.collideWith(hero);
			}
			for (Enemy enemy : enemies) {
				floorUnit.collideWith(enemy);
				enemy.collideWith(floorUnit);
			}
			for (Fruit fruit : fruits) {
				floorUnit.collideWith(fruit);
			}
			for (EnemyProjectile enemyProjectile : enemyProjectiles) {
				floorUnit.collideWith(enemyProjectile);
			}
			for (HeroProjectile heroProjectile : heroProjectiles) {
				floorUnit.collideWith(heroProjectile);
			}
		}
		for (WallUnit wallUnit : wallUnits) {
			for (Hero hero : heroes) {
				wallUnit.collideWith(hero);
			}
			for (Enemy enemy : enemies) {
				wallUnit.collideWith(enemy);
				enemy.collideWith(wallUnit);
			}
			for (Fruit fruit : fruits) {
				wallUnit.collideWith(fruit);
			}
			for (EnemyProjectile enemyProjectile : enemyProjectiles) {
				wallUnit.collideWith(enemyProjectile);
			}
			for (HeroProjectile heroProjectile : heroProjectiles) {
				wallUnit.collideWith(heroProjectile);
			}
		}
		// Enemies initiate collisions with Heroes
		for (Enemy enemy : enemies) {
			for (Hero hero : heroes) {
				enemy.collideWith(hero);
			}
		}
		// HeroProjectiles initiate collisions with Heroes and Enemies
		for (HeroProjectile heroProjectile : heroProjectiles) {
			for (Hero hero : heroes) {
				heroProjectile.collideWith(hero);
			}
			for (Enemy enemy : enemies) {
				heroProjectile.collideWith(enemy);
			}
		}
		for (EnemyProjectile enemyProjectile  : enemyProjectiles) {
			for (Hero hero : heroes) {
				enemyProjectile.collideWith(hero);
			}
			for (Enemy enemy : enemies) {
				enemyProjectile.collideWith(enemy);
			}
		}
		// Fruits intiate collisions with Heroes
		for (Fruit fruit : fruits) {
			for (Hero hero : heroes) {
				fruit.collideWith(hero);
			}
		}
		for (Bubble bubble : bubbles) {
			for (Enemy enemy : enemies) {
				bubble.collideWith(enemy);
			}
		}

		// Removing...
		for (SpriteObject obj : toBeRemoved) {
			remove(obj);
		}
		toBeRemoved.removeAll(toBeRemoved);

		if (enemies.isEmpty()) {

//			if (level.getValue() == 3) {
//				if (delay = 0) {
//
//				}
//			}

			if (delay == 90) {
				SoundEffect.getInstance().play("nextLevel");
			}
			if (delay == 0) {
				if (level.getValue() == 3) {
					gameStatus = GameStatus.WIN;
					SoundEffect.getInstance().play("victory");
					delay -= 1;
				} else {
					level.set(level.getValue() + 1);

					mapReader.readMap(level.getValue());
//					readMap(level.getValue());
					delay = 180;
				}
			} else {
				delay -= 1;
			}
			}
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
