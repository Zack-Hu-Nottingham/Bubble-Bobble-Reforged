package com.ae2dms.Model.GameObject.Wall.WallObject;

import com.ae2dms.GamePanel;
import javafx.scene.image.Image;

import java.util.ArrayList;

import static com.ae2dms.GamePanel.UNIT_SIZE;

/**
 * The type Wall image factory.
 */
public class WallImageFactory {

    /**
     * The constant red.
     */
    protected static Image red = new Image(WallUnit.class.getResource("/image/wall/red.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);
    /**
     * The constant blue.
     */
    protected static Image blue = new Image(WallUnit.class.getResource("/image/wall/blue.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);
    /**
     * The constant black.
     */
    protected static Image black = new Image(WallUnit.class.getResource("/image/wall/black.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);
    /**
     * The constant pink.
     */
    protected static Image pink = new Image(WallUnit.class.getResource("/image/wall/pink.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);
    /**
     * The constant green.
     */
    protected static Image green = new Image(WallUnit.class.getResource("/image/wall/green.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);

    /**
     * The Wall image.
     */
    protected ArrayList<Image> wallImage;

    /**
     * Instantiates a new Wall image factory.
     */
    WallImageFactory() {
        wallImage = new ArrayList<>();
        wallImage.add(red);
        wallImage.add(blue);
        wallImage.add(black);
        wallImage.add(pink);
        wallImage.add(green);
    }

    /**
     * Gets wall image.
     *
     * @param theme the theme
     * @return the wall image
     */
    public Image getWallImage(GamePanel.Theme theme) {
        switch (GamePanel.theme) {

            case BLUE:
                return wallImage.get(1);

            case BLACK:
                return wallImage.get(2);

            case PINK:
                return wallImage.get(3);

            case GREEN:
                return wallImage.get(4);

            default:
                return wallImage.get(0);
        }
    }
}
