package com.ae2dms.GameObject;

import com.ae2dms.GameObject.Sprite.SpriteObject;
import com.ae2dms.Scene.GameScene;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class GameObject {

    public Image image;
    public GameScene scene;
    public int x, y;
    public int width, height;

    public GameObject(int x, int y, int width, int height, GameScene scene, Image image) {
        //initializes the game object

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.scene = scene;
        this.image = image;
    }

    public void drawOn(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(image, x, y, width, height);
//        graphicsContext.drawImage(image, x+240, y+20, width, height);
    }

    public Rectangle2D getHitbox(){
        //sets hitbox for each game object
        return new Rectangle2D(x, y, width, height);
    }

    public boolean overlaps(GameObject obj) {
        //checks if two objects overlap or collide
        return getHitbox().intersects(obj.getHitbox());
    }
}
