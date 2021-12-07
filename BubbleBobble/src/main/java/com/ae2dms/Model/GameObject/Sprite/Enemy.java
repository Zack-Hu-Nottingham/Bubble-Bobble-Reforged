package com.ae2dms.Model.GameObject.Sprite;

import com.ae2dms.Model.GameObject.Sprite.Fruit.Fruit;
import com.ae2dms.Model.GameObject.Sprite.Fruit.fruitFactory.EnemyDropFruitFactory;
import com.ae2dms.Model.GameObject.Sprite.Fruit.fruitFactory.FruitFactory;
import com.ae2dms.Model.GameObject.Sprite.Projectile.EnemyProjectile;
import com.ae2dms.Model.GameObject.Wall.WallObject.CeilingUnit;
import com.ae2dms.Model.GameObject.Wall.WallObject.FloorUnit;
import com.ae2dms.Model.GameObject.Wall.WallObject.WallUnit;
import com.ae2dms.GamePanel;
import com.ae2dms.Model.Scene.GameScene;
import com.ae2dms.Util.SoundEffect;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static com.ae2dms.GamePanel.UNIT_SIZE;


/**
 * An Enemy is a non-controllable com.ae2dms.GameObject.GameObject that kills the main.Hero whenever it or its projectile comes in contact.
 * Enemies are able to be bubbled and free themselves from these bubbles after a period of time.
 * Enemies change direction at random intervals, when hitting a wall, and when hitting the main.Hero's shield.
 * Enemies jump at random intervals as well.
 */
public class Enemy extends SpriteObject {
	private static int WIDTH = UNIT_SIZE + 10;
	private static int HEIGHT = UNIT_SIZE + 10;
	private static final int JUMP_SPEED = 20;
	private static final int TERMINAL_VELOCITY_X = 4;
	private static int BUBBLED_FRAMES = 300;
	private static final double CHANGE_MOVEMENT_CHANCE = 0.01;
	private static double SHOOT_BUBBLE_CHANCE = 0.01;

	boolean isBubbled;
	int timer;
	int pointValue;
	private boolean turningAwayFromShield;
	private int turningAwayCount;
	private boolean isOnAPlatform;
	private double jumpSpeed;

	protected static Image enemyImageRight = new Image(Enemy.class.getResource("/image/sprite/enemy/enemyRight.png").toString(), WIDTH, HEIGHT, false, false);
	protected static Image enemyImageLeft = new Image(Enemy.class.getResource("/image/sprite/enemy/enemyLeft.png").toString(), WIDTH, HEIGHT, false, false);
	protected static Image enemyImage = enemyImageRight;

	protected static Image bubbled = new Image(Bubble.class.getResource("/image/sprite/bubble/bubbled.png").toString(), 40, 40, false, false);


	public Enemy(GameScene world, int colNum, int rowNum) {
		//initializes enemy
		super(colNum * UNIT_SIZE, rowNum * UNIT_SIZE, WIDTH, HEIGHT, world, enemyImage);
		isOnAPlatform = false;
		jumpSpeed = JUMP_SPEED;
		terminal_xVelocity = TERMINAL_VELOCITY_X;
		switch (GamePanel.difficulty) {
			case LOW:
				jumpSpeed = JUMP_SPEED-5;
				xAccel = 1.5;
				WIDTH = UNIT_SIZE + 10;
				HEIGHT = UNIT_SIZE + 10;
				BUBBLED_FRAMES = 300;
				SHOOT_BUBBLE_CHANCE = 0;
				break;

			case MEDIUM:
				jumpSpeed = JUMP_SPEED;
				xAccel = 2;
				WIDTH = UNIT_SIZE + 5;
				HEIGHT = UNIT_SIZE + 5;
				BUBBLED_FRAMES = 200;
				SHOOT_BUBBLE_CHANCE = 0.01;
				break;

			case HIGH:
				jumpSpeed = JUMP_SPEED+5;
				xAccel = 2.5;
				WIDTH = UNIT_SIZE-5;
				HEIGHT = UNIT_SIZE-5;
				BUBBLED_FRAMES = 100;
				SHOOT_BUBBLE_CHANCE = 0.01;
				break;
		}

		direction = GameScene.Direction.RIGHT;
		if (Math.random() < 0.5) {
			reverseDirection();
		}
		
		isBubbled = false;
		timer = BUBBLED_FRAMES;
		pointValue = 150;
		turningAwayFromShield = false;
		turningAwayCount = 10;
	}

	@Override
	public void drawOn(GraphicsContext g) {
		if (direction == GameScene.Direction.LEFT) {
			enemyImage = enemyImageLeft;
		} else {
			enemyImage = enemyImageRight;
		}
		//draws mook
		g.drawImage(enemyImage, x, y, WIDTH, HEIGHT);
		if (isBubbled) {
			g.setGlobalAlpha((double) timer/150);
			g.drawImage(bubbled, x-10, y-5, 50, 50);
			g.setGlobalAlpha(1);
		}
	}

	@Override
	public void collideWithFloor() {
		//handles floor collision values
		yVelocity = 0;
		if (!isOnAPlatform) {
			isOnAPlatform = true;
		}
	}

	@Override
	public void collideWithCeiling() {
		//handles ceiling collision values
		yVelocity = 0;
	}

	@Override
	public void update() {
		//updates enemy, handling movement
		super.update();
		if (isBubbled) {
			timer -= 1;
			if (timer <= 0) {
				isBubbled = false;
				timer = BUBBLED_FRAMES;
				xAccel = 1.5;
				direction = GameScene.Direction.RIGHT;
				if (Math.random() < 0.5) {
					reverseDirection();
				}
				yAccel = SpriteObject.GRAVITY;
			}
		} else {
			if (Math.random() < CHANGE_MOVEMENT_CHANCE) {
				jump();
			}
			if (Math.random() < CHANGE_MOVEMENT_CHANCE) {
				reverseDirection();
			}
			if(Math.random() < SHOOT_BUBBLE_CHANCE) {
				shootProjectile();
			}
		}
	}

	private void jump() {
		//handles jumping
		if (isOnAPlatform) {
			y -= 1;
			yVelocity = -jumpSpeed;
			isOnAPlatform = false;
		}
	}

	private void shootProjectile() {
		// Nothing happens
		SoundEffect.getInstance().play("shoot");
		scene.addEnemyProjectile(new EnemyProjectile(scene, x, y, direction));
	}
	
	public void collideWithProjectile() {
		//handles what to do if hit with a projectile by the hero
		if (!isBubbled) {
			SoundEffect.getInstance().play("bubbled");

			isBubbled = true;
			yVelocity = 0;
			xAccel = 0;
			yAccel = -0.1;
		}
	}
	
	public void collideWithWall() {
		//handles what to do on collision with a wall
		reverseDirection();
	}
	
	void die() {
		//handles what to do on death
		FruitFactory enemyDropFruitFactory = new EnemyDropFruitFactory();
		Fruit fruit = enemyDropFruitFactory.getFruit(x, y, scene);
		scene.addFruit(fruit);
		markToRemove();
	}

	public void collideWith(Hero hero) {
		//handles collision with hero and what to do
		if (this.overlaps(hero)) {
			if (!isBubbled) {
				hero.collideWithMook();
				if (hero.getShielding() && !turningAwayFromShield) {
					turningAwayFromShield = true;
					reverseDirection();
				}
			}
			else if (!canRemove){
				SoundEffect.getInstance().play("pop");
				die();
			}
		}
		if (turningAwayFromShield) {
			if (turningAwayCount <= 0) {
				turningAwayCount = 10;
				turningAwayFromShield = false;
			}
			turningAwayCount -= 1;
		}
	}

	public void collideWith(CeilingUnit unit) {
		//handles unit collision
		if (this.overlaps(unit)) {
			if (isBubbled) {
				yVelocity = 0;
				yAccel = 0;
			}
		}
	}

	public void collideWith(FloorUnit floorUnit) {
		//handles unit collision
		if (this.overlaps(floorUnit)) {
			if (isBubbled) {
				yVelocity = 0;
				yAccel = 0;
			}
		}
	}

	public void collideWith(WallUnit wallUnit) {
		//handles unit collision
		if (this.overlaps(wallUnit)) {
			if (isBubbled) {
				yVelocity = 0;
				yAccel = 0;
			}
		}
	}
}

