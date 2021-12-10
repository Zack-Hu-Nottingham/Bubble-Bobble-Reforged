package com.ae2dms.Model.GameObject.Sprite.Character;

import com.ae2dms.GamePanel;
import com.ae2dms.Model.GameObject.Sprite.Projectile.Bubble;
import com.ae2dms.Model.GameObject.Sprite.Fruit.Fruit;
import com.ae2dms.Model.GameObject.Sprite.Fruit.fruitFactory.BossDropFruitFactory;
import com.ae2dms.Model.GameObject.Sprite.Fruit.fruitFactory.FruitFactory;
import com.ae2dms.Model.GameObject.Sprite.Projectile.BossProjectile;
import com.ae2dms.Model.GameObject.Sprite.SpriteObject;
import com.ae2dms.Model.GameObject.Wall.WallObject.CeilingUnit;
import com.ae2dms.Model.GameObject.Wall.WallObject.FloorUnit;
import com.ae2dms.Model.GameObject.Wall.WallObject.WallUnit;
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
//public class Enemy extends SpriteObject {
public class Boss extends SpriteObject {

    private static int WIDTH = UNIT_SIZE + 10;
    private static int HEIGHT = UNIT_SIZE + 10;
    private static final int JUMP_SPEED = 20;
    private static final int TERMINAL_VELOCITY_X = 4;
    private static int BUBBLED_FRAMES = 300;
    private static final double CHANGE_MOVEMENT_CHANCE = 0.01;
    private static double SHOOT_BUBBLE_CHANCE = 0.01;

    /**
     * The boolean which tells if boss is bubbled.
     */
    boolean isBubbled;

    /**
     * The Timer for how long the boss is bubbled.
     */
    int timer;

    private boolean turningAwayFromShield;
    private int turningAwayCount;
    private boolean isOnAPlatform;
    private int jumpSpeed;


    private int sizeRange;
    private int life;
    private int damage;

    /**
     * The Is bombed flag which tells if the boss already being attacked by hero's ultimate bubble.
     */
    public boolean isBombed;

    /**
     * The image of boss turns right.
     */
    protected static Image bossRightImage = new Image(Enemy.class.getResource("/image/sprite/enemy/bossRight.png").toString(), WIDTH, HEIGHT, false, false);

    /**
     * The image of boss turns left.
     */
    protected static Image bossLeftImage = new Image(Enemy.class.getResource("/image/sprite/enemy/bossLeft.png").toString(), WIDTH, HEIGHT, false, false);

    /**
     * The image of boss that is currently using.
     */
    protected static Image enemyImage = bossRightImage;

    /**
     * The image of boss being bubbled.
     */
    protected static Image bubbled = new Image(Bubble.class.getResource("/image/sprite/bubble/bubbled.png").toString(), 40, 40, false, false);


    /**
     * Instantiates a new Boss.
     *
     * @param gameScene the gameScene that boss in
     * @param colNum    the column that boss would be placed
     * @param rowNum    the row that boss would be placed
     */
    public Boss(GameScene gameScene, int colNum, int rowNum) {
        //initializes enemy
        super(colNum * UNIT_SIZE, rowNum * UNIT_SIZE, WIDTH, HEIGHT, gameScene, enemyImage);
        isOnAPlatform = false;
        jumpSpeed = JUMP_SPEED;
        terminal_xVelocity = TERMINAL_VELOCITY_X;
        switch (GamePanel.difficulty) {
            case LOW:
                sizeRange = 15;
                jumpSpeed = JUMP_SPEED-5;
                xAccel = 1.5;
                WIDTH = UNIT_SIZE + sizeRange;
                HEIGHT = UNIT_SIZE + sizeRange;
                BUBBLED_FRAMES = 300;
                SHOOT_BUBBLE_CHANCE = 0.01;
                life = 5;
                break;

            case MEDIUM:
                sizeRange = 10;
                jumpSpeed = JUMP_SPEED;
                xAccel = 2;
                WIDTH = UNIT_SIZE + sizeRange;
                HEIGHT = UNIT_SIZE + sizeRange;
                BUBBLED_FRAMES = 200;
                SHOOT_BUBBLE_CHANCE = 0.02;
                life = 8;
                break;

            case HIGH:
                jumpSpeed = JUMP_SPEED+5;
                xAccel = 2.5;
                WIDTH = UNIT_SIZE-5;
                HEIGHT = UNIT_SIZE-5;
                BUBBLED_FRAMES = 100;
                SHOOT_BUBBLE_CHANCE = 0.03;
                life = 10;
                break;
        }

        direction = GameScene.Direction.RIGHT;
        if (Math.random() < 0.5) {
            reverseDirection();
        }

        isBubbled = false;
        timer = BUBBLED_FRAMES;
        turningAwayFromShield = false;
        turningAwayCount = 10;
    }

    @Override
    public void drawOn(GraphicsContext g) {
        if (direction == GameScene.Direction.LEFT) {
            enemyImage = bossLeftImage;
        } else {
            enemyImage = bossRightImage;
        }
        //draws mook
        if (isBubbled) {
            g.drawImage(enemyImage, getX(), getY(), WIDTH, HEIGHT);

            g.setGlobalAlpha((double) timer/150);
            g.drawImage(bubbled, getX()-10, getY()-5, 50+sizeRange, 50+sizeRange);
            g.setGlobalAlpha(1);
        } else {
            g.drawImage(enemyImage, getX(), getY(), WIDTH, HEIGHT);
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
//            y -= 1;
            setY(getY()-1);
            yVelocity = -jumpSpeed;
            isOnAPlatform = false;
        }
    }

    /**
     * Shoot boss's projectile.
     */
    public void shootProjectile() {
        // Nothing happens
        SoundEffect.getInstance().play("shoot");

        System.out.println(direction);
        this.getScene().addBossProjectile(new BossProjectile(this.getScene(), getX(), getY(), direction));
    }

    /**
     * Boss collide with hero's projectile.
     */
    public void collideWithProjectile() {
        damage ++;
        System.out.println("damage: "+damage);
        if (!isBubbled && damage >= life) {
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

    /**
     * Handles that boss is killed.
     */
    public void die() {
        //handles what to do on death
        getScene().chargeLevel += 1;
        FruitFactory bossDropFruitFactory = new BossDropFruitFactory();
        Fruit fruit = bossDropFruitFactory.getFruit(getX(), getY(), this.getScene());
        this.getScene().addFruit(fruit);
        markToRemove();
    }

    /**
     * Return the boss whether is bubbled.
     *
     * @return the boolean
     */
    public boolean isBubbled() {
        return isBubbled;
    }


    /**
     * Boss collide with hero.
     *
     * @param hero the hero
     */
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

    /**
     * Collide with ceiling.
     *
     * @param unit the unit
     */
    public void collideWith(CeilingUnit unit) {
        //handles unit collision
        if (this.overlaps(unit)) {
            if (isBubbled) {
                yVelocity = 0;
                yAccel = 0;
            }
        }
    }

    /**
     * Collide with floor.
     *
     * @param floorUnit the floor unit
     */
    public void collideWith(FloorUnit floorUnit) {
        //handles unit collision
        if (this.overlaps(floorUnit)) {
            if (isBubbled) {
                yVelocity = 0;
                yAccel = 0;
            }
        }
    }

    /**
     * Collide with wallUnit.
     *
     * @param wallUnit the wall unit
     */
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

