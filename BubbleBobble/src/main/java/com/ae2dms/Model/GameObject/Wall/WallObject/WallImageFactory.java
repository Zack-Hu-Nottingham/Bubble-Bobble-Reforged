package com.ae2dms.Model.GameObject.Wall.WallObject;

import com.ae2dms.GamePanel;
import javafx.scene.image.Image;

import java.util.ArrayList;

import static com.ae2dms.GamePanel.UNIT_SIZE;

public class WallImageFactory {

    protected static Image red = new Image(WallUnit.class.getResource("/image/wall/red.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);
    protected static Image blue = new Image(WallUnit.class.getResource("/image/wall/blue.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);
    protected static Image black = new Image(WallUnit.class.getResource("/image/wall/black.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);
    protected static Image pink = new Image(WallUnit.class.getResource("/image/wall/pink.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);
    protected static Image green = new Image(WallUnit.class.getResource("/image/wall/green.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);

    protected ArrayList<Image> wallImage;

    WallImageFactory() {
        wallImage = new ArrayList<>();
        wallImage.add(red);
        wallImage.add(blue);
        wallImage.add(black);
        wallImage.add(pink);
        wallImage.add(green);
    }

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
