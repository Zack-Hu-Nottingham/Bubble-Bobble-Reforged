package com.ae2dms.GameObject.Sprite;

import com.ae2dms.GameObject.Award.Award;
import com.ae2dms.GameObject.Award.AwardGenerator;
import com.ae2dms.GameObject.Wall.WallObject.CeilingUnit;
import com.ae2dms.GameObject.Wall.WallObject.FloorUnit;
import com.ae2dms.GameObject.Wall.WallObject.WallUnit;
import com.ae2dms.Scene.GameScene;
import com.ae2dms.Util.Direction;
import com.ae2dms.Util.SoundEffect;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import static com.ae2dms.GamePanel.UNIT_SIZE;


/**
 * An Enemy is a non-controllable com.ae2dms.GameObject.GameObject that kills the main.Hero whenever it or its projectile comes in contact.
 * Enemies are able to be bubbled and free themselves from these bubbles after a period of time.
 * Enemies change direction at random intervals, when hitting a wall, and when hitting the main.Hero's shield.
 * Enemies jump at random intervals as well.
 */
public class Enemy extends SpriteObject {
	private static final int WIDTH = UNIT_SIZE + 10;
	private static final int HEIGHT = UNIT_SIZE + 10;
	private static final int JUMP_SPEED = 20;
	private static final int TERMINAL_VELOCITY_X = 4;
	private static final int BUBBLED_FRAMES = 300;
	private static final double CHANGE_MOVEMENT_CHANCE = 0.01;

	boolean isBubbled;
	int timer;
	int pointValue;
	private boolean turningAwayFromShield;
	private int turningAwayCount;
	private boolean isOnAPlatform;
	private double jumpSpeed;

	protected static Image enemyImageRight = new Image(Enemy.class.getResource("/image/sprite/enemy/enemy01Right.png").toString(), WIDTH, HEIGHT, false, false);
	protected static Image enemyImageLeft = new Image(Enemy.class.getResource("/image/sprite/enemy/enemy01Left.png").toString(), WIDTH, HEIGHT, false, false);
	protected static Image enemyImage = enemyImageRight;


	public Enemy(GameScene world, int colNum, int rowNum) {
		//initializes enemy
		super(colNum * UNIT_SIZE, rowNum * UNIT_SIZE, WIDTH, HEIGHT, world, enemyImage);
		isOnAPlatform = false;
		jumpSpeed = JUMP_SPEED;
		terminal_xVelocity = TERMINAL_VELOCITY_X;
		
		xAccel = 1.5;
//		direction = 1;
		direction = Direction.right;
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
		if (direction == Direction.left) {
			enemyImage = enemyImageLeft;
		} else {
			enemyImage = enemyImageRight;
		}
		//draws mook
		g.drawImage(enemyImage, x, y, WIDTH, HEIGHT);
		if (isBubbled) {
			g.setFill(new Color((double) (timer * ((double) 255 / 300))/255, 0, 255/255, 255/255 ));
			g.fillRect(x - 5, y - 5, WIDTH + 10, HEIGHT + 10);
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
//				direction = 1;
				direction = Direction.right;
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
	}
	
	public void collideWithProjectile() {
		//handles what to do if hit with a projectile by the hero
		if (!isBubbled) {
			SoundEffect.setToLoud();
			SoundEffect.play("/sound/bubbled.wav");
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
//		scene.addFruit(new Fruit(x, y, scene));
		AwardGenerator awardGenerator = new AwardGenerator();
		Award award = awardGenerator.getFruit(x, y, scene);
		scene.addFruit(award);
//		scene.addCollectEffect(award.collectEffect);
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
				SoundEffect.play("/sound/pop.wav");
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

