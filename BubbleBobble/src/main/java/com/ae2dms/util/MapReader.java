package com.ae2dms.util;

import com.ae2dms.model.gameObject.sprite.character.Boss;
import com.ae2dms.model.gameObject.sprite.character.Enemy;
import com.ae2dms.model.gameObject.sprite.character.Hero;
import com.ae2dms.model.gameObject.wall.wallObject.CeilingUnit;
import com.ae2dms.model.gameObject.wall.wallObject.FloorUnit;
import com.ae2dms.model.gameObject.wall.wallObject.WallUnit;
import com.ae2dms.model.scene.GameScene;

import java.io.InputStream;
import java.util.Scanner;

import static com.ae2dms.GamePanel.HEIGHT;
import static com.ae2dms.GamePanel.WIDTH;

/**
 * Map reader, which reads the map and according to the map add elements to the gameScene.
 */
public class MapReader {

    private MapReader() {}

    private static MapReader instance = new MapReader();

    /**
     * Gets the instance of mapReader.
     *
     * @return the instance
     */
    public static MapReader getInstance() {
        return instance;
    }

    private GameScene gameScene;

    /**
     * Sets game scene of the map reader and later would add elements to this game scene.
     *
     * @param gameScene the game scene
     */
    public void setGameScene(GameScene gameScene) {
        this.gameScene = gameScene;
    }

    /**
     * According to the required level read the corresponding map to the game scene.
     *
     * @param level the level
     */
    public void readMap(int level) {
        String level1 = "/world/World1.txt";
        String level2 = "/world/World2.txt";
        String level3 = "/world/World3.txt";
        String level4 = "/world/World4.txt";
        String map = level1;

        switch (level) {
            case 1:
                map = level1;
                break;
            case 2:
                map = level2;
                break;
            case 3:
                map = level3;
                break;
            case 4:
                map = level4;
        }

        InputStream input = this.getClass().getResourceAsStream(map);
        Scanner scanner = new Scanner(input);

        gameScene.clearContents();
        for (int row = 0; row < HEIGHT; row++) {
            String currentLine = scanner.next();
            for (int col = 0; col < WIDTH; col++) {
                if (currentLine.charAt(col) == '*') {
                    gameScene.addFloorUnit(new FloorUnit(gameScene, col, row));
                } else if (currentLine.charAt(col) == 'H') {
                    gameScene.addHero(new Hero(gameScene, col, row));
                } else if (currentLine.charAt(col) == '|') {
                    gameScene.addWallUnit(new WallUnit(gameScene, col, row));
                } else if (currentLine.charAt(col) == '_') {
                    gameScene.addCeilingUnit(new CeilingUnit(gameScene, col, row));
                } else if (currentLine.charAt(col) == 'M') {
                    gameScene.addEnemy(new Enemy(gameScene, col, row));
                } else if (currentLine.charAt(col) == 'B') {
                    gameScene.addBoss(new Boss(gameScene, col, row));
                }
            }
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
        scanner.close();
    }

}

