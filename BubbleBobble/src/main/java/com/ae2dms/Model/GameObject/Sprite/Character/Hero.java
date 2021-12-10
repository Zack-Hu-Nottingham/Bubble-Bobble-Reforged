package com.ae2dms.Model.GameObject.Sprite.Character;

import com.ae2dms.Model.GameObject.Sprite.Projectile.Bubble;
import com.ae2dms.Model.GameObject.Sprite.Projectile.HeroProjectile;
import com.ae2dms.GamePanel;
import com.ae2dms.Model.GameObject.Sprite.SpriteObject;
import com.ae2dms.Model.Scene.GameScene;
import com.ae2dms.Util.SoundEffect;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

import static com.ae2dms.GamePanel.UNIT_SIZE;


/**
 * A Hero is a com.ae2dms.GameObject.GameObject that is controllable by the player.
 * Of all the com.ae2dms.GameObject.GameObject, only Hero has KeyBindings.
 * Hero can shoot HeroProjectiles, shield from attacks, trigger a special attack and
 * collect Fruits for points.
 */
public class Hero extends SpriteObject {
	private static final int JUMP_SPEED = 20;
	private static final int TERMINAL_VELOCITY_X = 6;
	private static final int SIZE = 35;
	private static final int WALK = 5;
	private static final int RUN = 10;
	private static final double RUN_ACCEL = 5;
	private static final int SHIELD_TIME = 100;
	
	private boolean isShielding;
	private int shieldTimer;
	private boolean isStunned;
	private int stunTimer;
	private int shootDelay;
	private boolean readyToCharge;
	private boolean isOnAPlatform;
	private int jumpSpeed;

    /**
     * The constant imageBubLeft.
     */
    protected static Image imageBubLeft = new Image(Hero.class.getResource("/image/sprite/hero/BubLeft.png").toString(), SIZE, SIZE, false, false);
    /**
     * The constant imageBubRight.
     */
    protected static Image imageBubRight = new Image(Hero.class.getResource("/image/sprite/hero/BubRight.png").toString(), SIZE, SIZE, false, false);
    /**
     * The constant imageBub.
     */
    protected static Image imageBub = imageBubRight;

    /**
     * Instantiates a new Hero.
     *
     * @param gameScene the game scene
     * @param colNum    the col num
     * @param rowNum    the row num
     */
    public Hero(GameScene gameScene, int colNum, int rowNum) {
		//initializes hero
		super(colNum * UNIT_SIZE, rowNum * UNIT_SIZE, SIZE, SIZE, gameScene, imageBub);
		isOnAPlatform = false;

		terminal_xVelocity = TERMINAL_VELOCITY_X;
		jumpSpeed = JUMP_SPEED;
		
		isShielding = false;
		shieldTimer = SHIELD_TIME;
		isStunned = false;
		stunTimer = 250;
		shootDelay = 0;
		readyToCharge = false;

//		addKeyHandler(Main.stage.getScene());
		addKeyHandler(GamePanel.stage.getScene());
	}

	@Override
	public void drawOn(GraphicsContext g) {
		//draws hero
		if (direction == GameScene.Direction.LEFT) {
			imageBub = imageBubLeft;
		} else {
			imageBub = imageBubRight;
		}

		if (isShielding) {
			g.drawImage(imageBub, this.getX(), this.getY(), SIZE, SIZE);
			Image shield = new Image(Hero.class.getResource("/image/sprite/hero/shield.png").toString(), SIZE, SIZE, false, false);
			g.setGlobalAlpha((double) (shieldTimer * ((double) 255 / SHIELD_TIME))/255);
			g.drawImage(shield, this.getX(), this.getY(), getWidth(), getHeight());
			g.setGlobalAlpha(1);

		} else if (isStunned) {
			g.setGlobalAlpha(0.5);
			g.drawImage(imageBub, getX(), getY(), SIZE, SIZE);
			g.setGlobalAlpha(1);
//		}else if (GamePanel.gameStatus == GamePanel.GameStatus.LOSE) {

		} else {
			g.drawImage(imageBub, getX(), getY(), SIZE, SIZE);

		}

	}

    /**
     * Shoot projectile.
     */
    public void shootProjectile() {
		//makes hero shoot projectile
		SoundEffect.getInstance().play("shoot");

		this.getScene().addHeroProjectile(new HeroProjectile(this.getScene(), getX(), getY(), direction));
	}

    /**
     * Collide with mook.
     */
    void collideWithMook() {
		//handles colliding with a mook
		if (!isShielding) {
			die();
		}
	}

	private void jump() {
		//handles jumping
		if (isOnAPlatform) {
//			y -= 1;
			setY(getY()-1);
			yVelocity = -jumpSpeed;
			isOnAPlatform = false;
		}
	}

    /**
     * Add key handler.
     *
     * @param scene the scene
     */
    public void addKeyHandler(Scene scene) {
		scene.setOnKeyPressed(event -> {
			KeyCode keyCode = event.getCode();
			switch (keyCode) {
				case RIGHT:
					if (!isShielding && !isStunned) {
						xAccel = RUN_ACCEL;
						direction = GameScene.Direction.RIGHT;
					}
					break;
				case LEFT:
					if (!isShielding && !isStunned) {
						xAccel = -RUN_ACCEL;
						direction = GameScene.Direction.LEFT;
					}
					break;
				case UP:
					if (!isShielding && !isStunned) {
						jump();
						SoundEffect.getInstance().play("jump");
					}
					break;
				case E:
					if (!isShielding && !isStunned) {
						shootDelay -= 1;
						if (shootDelay <= 0) {
							shootProjectile();
							shootDelay = 10;
						}
					}
					break;
				case SPACE:
					terminal_xVelocity = RUN;
					break;
				case Q:
					if (!isStunned) {
						xVelocity = 0;
						xAccel = 0;
						isShielding = true;
					}
					break;
				case W:
					if (readyToCharge) {
						this.getScene().chargeLevel = 0;
						readyToCharge = false;
						this.getScene().addBubble(new Bubble(this.getScene(), getX(), getY()));
						SoundEffect.getInstance().play("explode");
//						readyToCharge = false;
					}
					break;
			}
		});

		scene.setOnKeyReleased(event -> {
			switch (event.getCode()) {
				case RIGHT:
				case LEFT:
					xAccel = 0;
					break;
				case E:
					shootDelay = 0;
					break;
				case SPACE:
					terminal_xVelocity = WALK;
					break;
				case Q:
					isShielding = false;
					break;
			}
		});
	}

	@Override
	public void collideWithWall() {
		// Nothing happens
	}

    /**
     * Die.
     */
    public void die() {
		//handles death
		SoundEffect.getInstance().play("death");
		// not mark to reset but let the game over.
		GamePanel.gameStatus = GamePanel.GameStatus.LOSE;
	}

    /**
     * Collide with projectile.
     */
    public void collideWithProjectile() {
		System.out.println(isShielding);
		//handles collision with projectiles
		if (!isShielding) {
			die();
			System.out.println("die");

		}
	}
	@Override
	public void update() {
		//updates position of hero, according to many variables 
		//including whether or not the hero is shielding,
		//or if the hero is stunned
		super.update();
		if (isShielding) {
			shieldTimer -= 1;
			if (shieldTimer <= 0) {
				shieldTimer = 0;
				isShielding = false;
				isStunned = true;
			}
		} else {
			if (shieldTimer < SHIELD_TIME && !isStunned) {
				shieldTimer += 1;
			}
		}
		if (isStunned) {
			stunTimer -= 1;
			if (stunTimer <= 0) {
				isStunned = false;
				stunTimer = 250;
				shieldTimer = SHIELD_TIME;
			}
		}
		if (getScene().chargeLevel >= 4) {
			setChargeToReady();
		}
	}
	
	@Override
	public void collideWithFloor() {
		//handles collision with floor
		yVelocity = 0;
		if (!isOnAPlatform) {
			isOnAPlatform = true;
			SoundEffect.getInstance().play("land");
		}
	}

	@Override
	public void collideWithCeiling() {

	}

    /**
     * Gets shielding.
     *
     * @return the shielding
     */
    public boolean getShielding() {
		//gets whether or not the hero is shielding on this frame and returns it
		return isShielding;
	}

    /**
     * Sets charge to ready.
     */
    public void setChargeToReady() {
		//sets whether or not the hero is ready to charge the charge shot
		readyToCharge = true;
	}
}