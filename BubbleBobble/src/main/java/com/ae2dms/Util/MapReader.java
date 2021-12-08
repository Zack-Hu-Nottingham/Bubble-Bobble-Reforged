package com.ae2dms.Util;

import com.ae2dms.Model.GameObject.Sprite.Boss;
import com.ae2dms.Model.GameObject.Sprite.Enemy;
import com.ae2dms.Model.GameObject.Sprite.Hero;
import com.ae2dms.Model.GameObject.Wall.WallObject.CeilingUnit;
import com.ae2dms.Model.GameObject.Wall.WallObject.FloorUnit;
import com.ae2dms.Model.GameObject.Wall.WallObject.WallUnit;
import com.ae2dms.Model.Scene.GameScene;

import java.io.InputStream;
import java.util.Scanner;

import static com.ae2dms.GamePanel.HEIGHT;
import static com.ae2dms.GamePanel.WIDTH;

public class MapReader {

    MapReader() {}

    private static MapReader instance = new MapReader();

    public static MapReader getInstance() {
        return instance;
    }

    private GameScene gameScene;

    public void setGameScene(GameScene gameScene) {
        this.gameScene = gameScene;
    }

    public void readMap(int level) {
        String level1 = "/world/World1.txt";
        String level2 = "/world/World2.txt";
        String level3 = "/world/World3.txt";
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

