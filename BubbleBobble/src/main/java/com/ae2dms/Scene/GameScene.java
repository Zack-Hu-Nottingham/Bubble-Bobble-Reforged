package com.ae2dms.Scene;

import com.ae2dms.Controller.Game.GameSceneController;
import com.ae2dms.GameObject.Award.Fruit;
import com.ae2dms.GameObject.Sprite.SpriteObject;
import com.ae2dms.GameObject.Sprite.*;
import com.ae2dms.GameObject.Wall.WallObject.CeilingUnit;
import com.ae2dms.GameObject.Wall.WallObject.FloorUnit;
import com.ae2dms.GameObject.Wall.WallObject.WallUnit;
import com.ae2dms.Util.GameStatus;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static com.ae2dms.GamePanel.*;

/**
 * InteractableWorld handles all of the game's operations:
 * updating positions, checking for collisions, and removing objects.
 */
public class GameScene {
//	public class GameScene extends Canvas {
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


	public static int bonus = 0;

	private Refresh refresh = new Refresh();

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

	}

	public void paintComponent(GraphicsContext g) {
		//paints everything on the world
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

		if (GameSceneController.gameState == GameStatus.win) {

		} else if (GameSceneController.gameState == GameStatus.lose){

		}
//			init(stage);
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

	void addHero(Hero hero) {
		//adds a hero to the map
		heroes.add(hero);
	}

	void addEnemy(Enemy enemy) {
		//adds a mook to the map
		enemies.add(enemy);
	}

	public void addHeroProjectile(HeroProjectile heroProjectile) {
		//adds a projectile to where necessary
		heroProjectiles.add(heroProjectile);
	}

	public void addFruit(Fruit fruit) {
		//adds fruit on bubble pop
		fruits.add(fruit);
	}

	public void addBubble(Bubble bubble) {
		//adds special bubble
		bubbles.add(bubble);
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
	}

//	public void markToReset() {
//		//sets boolean to make sure the world is ready to be reset
//		readyToReset = true;
//	}

	public void readMap(String mapName) {
		InputStream input = this.getClass().getResourceAsStream(mapName);
		Scanner scanner = new Scanner(input);

		clearContents();
		for (int row = 0; row < HEIGHT; row++) {
			String currentLine = scanner.next();
			for (int col = 0; col < WIDTH; col++) {
				if (currentLine.charAt(col) == '*') {
					addFloorUnit(new FloorUnit(this, col, row));
				} else if (currentLine.charAt(col) == 'H') {
					addHero(new Hero(this, col, row));
				} else if (currentLine.charAt(col) == '|') {
					addWallUnit(new WallUnit(this, col, row));
				} else if (currentLine.charAt(col) == '_') {
					addCeilingUnit(new CeilingUnit(this, col, row));
				} else if (currentLine.charAt(col) == 'M') {
					addEnemy(new Enemy(this, col, row));
				}
			}
			if (scanner.hasNextLine()) {
				scanner.nextLine();
			}
		}
		scanner.close();

	}

	private Stage stage;


	private Canvas canvas;
	GraphicsContext graphicsContext;

	public void init(Stage stage) {
		AnchorPane root = null;
		try {
			root = FXMLLoader.load(Menu.class.getResource("/fxml/gameScene.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		stage.getScene().setRoot(root);

		Group temp = (Group) root.getChildren().get(0);
		canvas = (Canvas) temp.getChildren().get(3);
		graphicsContext = canvas.getGraphicsContext2D();
//		System.out.println(root.getChildren());
//		root.getChildren().add(canvas);
//		System.out.println(root.getChildren());

		this.stage = stage;
		readMap("/world/World3.txt");
//		readMap("/world/World1.txt");

		GameSceneController.gameState = GameStatus.playing;
		refresh.start();

	}

	private class Refresh extends AnimationTimer {
		@Override
		public void handle(long currentTime) {
			if (GameSceneController.gameState == GameStatus.playing) {
				updatePosition();
				paintComponent(graphicsContext);
			}


		}
	}


	public int getHeight() {
		return HEIGHT * UNIT_SIZE;
	}

	public int getWidth() {
		return WIDTH * UNIT_SIZE;
	}

	public Scene getScene() {
		return stage.getScene();
	}

}
