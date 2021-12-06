package com.ae2dms.Controller.GameScene;

import com.ae2dms.GamePanel;
import com.ae2dms.Scene.GameScene;
import com.ae2dms.Util.GameTimer;
import javafx.animation.AnimationTimer;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;


public class GameSceneController {

    private GameScene gameScene;

    // View Node
    @FXML private Canvas canvas;
    @FXML public Group blurGroup;
    @FXML private Label currentScore;
    @FXML private Label timeSpend;
    @FXML protected ExitGamePopUpController ExitGamePopUpController;


    public static GamePanel.GameStatus gameState = GamePanel.GameStatus.READY;

    private Refresh refresh = new Refresh();

    private int timeDelay = 120;

    public void initialize() {

        GamePanel.gameTimer = new GameTimer();

        GamePanel.bonus = new SimpleIntegerProperty(0);

        GamePanel.gameTimer.start();

        timeSpend.textProperty().bind(GamePanel.gameTimer.timeToDisplay);

        currentScore.textProperty().bind(GamePanel.bonus.asString());

        gameScene = new GameScene();

        gameScene.readMap(1);

        GameSceneController.gameState = GamePanel.GameStatus.PLAYING;

        gameScene.getCanvas(canvas);

        refresh.start();
    }


    public void mouseClickedBackToMenu(MouseEvent mouseEvent) {
        gameState = GamePanel.GameStatus.PAUSE;
        GamePanel.gameTimer.pause();
        blurEffect();
        ExitGamePopUpController.show();

        ExitGamePopUpController.confirmBack.setOnMouseClicked((event) -> {
            ExitGamePopUpController.hide();
            clearEffect();
            GamePanel.gameTimer.resume();
            gameState = GamePanel.GameStatus.PLAYING;

        });

        ExitGamePopUpController.confirmExit.setOnMouseClicked((event) -> {
            GamePanel.gameTimer.stop();
            ExitGamePopUpController.hide();
            clearEffect();
            GamePanel.getInstance().toMenu();
        });
    }

    private void blurEffect() {
        GaussianBlur gaussianBlur = new GaussianBlur();
        gaussianBlur.setRadius(22);
        blurGroup.setEffect(gaussianBlur);
    }

    public void clearEffect() {
        blurGroup.setEffect(null);
    }


    private class Refresh extends AnimationTimer {
        @Override
        public void handle(long currentTime) {
            switch (GameSceneController.gameState){
                case PLAYING:
                    gameScene.updatePosition();
                    gameScene.paintComponent();
                    break;

                case WIN:
                case LOSE:
                    if (timeDelay <= 0) {
                        GamePanel.getInstance().gameOver();
                        stop();
                    } else {
                        gameScene.updatePosition();
                        gameScene.paintComponent();
                        timeDelay -= 1;
                    }
                    break;
            }
        }
    }
}
