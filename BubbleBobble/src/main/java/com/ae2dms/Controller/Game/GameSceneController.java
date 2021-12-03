package com.ae2dms.Controller.Game;

import com.ae2dms.Controller.Game.PopUp.ExitGamePopUpController;
import com.ae2dms.Controller.Game.PopUp.GameCompletePopUpController;
import com.ae2dms.Controller.Game.PopUp.LoseGamePopUpController;
import com.ae2dms.GamePanel;
import com.ae2dms.Main;
import com.ae2dms.Scene.GameScene;
import com.ae2dms.Scene.Menu;
import com.ae2dms.Util.GameStatus;
import com.ae2dms.Util.GameTimer;
import javafx.animation.AnimationTimer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class GameSceneController {

    // Model
    private GameScene gameScene = new GameScene();

    // View Node
    @FXML private Canvas canvas;
    @FXML public Group blurGroup;
    @FXML private Label currentScore;
    @FXML private Label timeSpend;
    @FXML private ExitGamePopUpController exitGamePopUpController;
    @FXML private GameCompletePopUpController gameCompletePopUpController;
    @FXML private LoseGamePopUpController loseGamePopUpController;


    public static GameStatus gameState = GameStatus.ready;

    private GameTimer timer;

    private Refresh refresh = new Refresh();

    private int timeDelay = 300;

    public void startGame() {
        gameScene.readMap("/world/World3.txt");

        gameScene.getCanvas();

        GameSceneController.gameState = GameStatus.playing;

        refresh.start();

    }

    public void initialize() {

        timer = new GameTimer();

        timer.start();

        timeSpend.textProperty().bind(timer.timeToDisplay);

        currentScore.textProperty().bind(gameScene.bonusProperty().asString());

    }

//    public void assignData(int timeDuration, int score) {
//        this.timeDuration = timeDuration;
//        this.score = score;
//s
//        currentScore.setText(String.valueOf(score));
//        timeSpend.setText(String.valueOf(timeDuration));
//    }

    public void mouseClickedBackToMenu(MouseEvent mouseEvent) {
        gameState = GameStatus.pause;
        timer.pause();
        gaussianBlur();
        exitGamePopUpController.show();

        exitGamePopUpController.confirmBack.setOnMouseClicked((event) -> {
            exitGamePopUpController.hide();
            clearEffect();
            timer.resume();
            gameState = GameStatus.playing;

        });

        exitGamePopUpController.confirmExit.setOnMouseClicked((event) -> {
            timer.stop();
            exitGamePopUpController.hide();
            clearEffect();
            GamePanel.getInstance().toIndex();
        });
    }

    private void gaussianBlur() {
        GaussianBlur gaussianBlur = new GaussianBlur();
        gaussianBlur.setRadius(20);
        blurGroup.setEffect(gaussianBlur);
//        this.isBlur.setValue(true);
    }

    public void clearEffect() {
        blurGroup.setEffect(null);
    }


    private class Refresh extends AnimationTimer {
        @Override
        public void handle(long currentTime) {
            switch (GameSceneController.gameState){
                case playing:
                    gameScene.updatePosition();
                    gameScene.paintComponent();
                    break;

                case pause:
                    break;

                case win:
                    if (timeDelay <= 0) {
                        win();
                    } else {
                        gameScene.updatePosition();
                        gameScene.paintComponent();
                        timeDelay -= 1;
                    }
                    break;

                case lose:
                    if (timeDelay <= 0) {
                        lose();
                    } else {
                        gameScene.updatePosition();
                        gameScene.paintComponent();
                        timeDelay -= 1;
                    }
                    break;
            }
        }
    }

    private void win() {
        gameCompletePopUpController.show();
    }

    private void lose() {
        loseGamePopUpController.show();

    }



}
