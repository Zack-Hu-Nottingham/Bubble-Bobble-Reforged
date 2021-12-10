package com.ae2dms.model.gameObject;

import com.ae2dms.model.scene.GameScene;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * The type Game object defines common behavior and parameter among all
 * the game objects. All the objects would have its x-coordinate, y-coordinate
 * , width, height and image.
 */
public abstract class GameObject {

    /**
     * Gets image.
     *
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * Gets scene.
     *
     * @return the scene
     */
    public GameScene getScene() {
        return scene;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets image.
     *
     * @param image the image
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Sets scene.
     *
     * @param scene the scene
     */
    public void setScene(GameScene scene) {
        this.scene = scene;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Sets width.
     *
     * @param width the width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Sets height.
     *
     * @param height the height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * The Image of the gameObject.
     */
    private Image image;

    /**
     * The Scene that this object would be displayed on.
     */
    private GameScene scene;

    /**
     * The X-coordinate of the object .
     */
    private double x;

    /**
     * The Y-coordinate of the object.
     */
    private double y;

    /**
     * The Width of the object.
     */
    private int width;

    /**
     * The Height of the object.
     */
    private int height;

    /**
     * Instantiates a new Game object.
     *
     * @param x      the x-coordinate
     * @param y      the y-coordinate
     * @param width  the width
     * @param height the height
     * @param scene  the scene that object belong to
     * @param image  the image of the object
     */
    public GameObject(double x, double y, int width, int height, GameScene scene, Image image) {
        //initializes the game object

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.scene = scene;
        this.image = image;
    }

    /**
     * The default draw method for all the game object, could be overWritten & redesigned by subclass.
     *
     * @param graphicsContext the graphics context
     */
    public void drawOn(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(image, x, y, width, height);
    }

    /**
     * Get the hitbox of the box, which could help to decide if two object collide.
     *
     * @return the rectangle 2 d
     */
    public Rectangle2D getHitbox(){
        //sets hitbox for each game object
        return new Rectangle2D(x, y, width, height);
    }

    /**
     * Decide if two object collide with each other, if yes return true, else false.
     *
     * @param obj the obj
     * @return the boolean
     */
    public boolean overlaps(GameObject obj) {
        //checks if two objects overlap or collide
        return getHitbox().intersects(obj.getHitbox());
    }
}
