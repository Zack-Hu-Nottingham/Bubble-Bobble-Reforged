package com.ae2dms.Controller.GameScene;

import com.ae2dms.GamePanel;
import com.ae2dms.Scene.GameOver;
import com.ae2dms.Scene.GameScene;
import com.ae2dms.Util.GameStatus;
import com.ae2dms.Util.GameTimer;
import javafx.animation.AnimationTimer;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;


public class GameSceneController {

//    public BorderPane GameCompletePopUp;
//    @FXML
//    protected BorderPane ExitGamePopUp;

    private GameScene gameScene = new GameScene();

    // View Node
    @FXML private Canvas canvas;
    @FXML public Group blurGroup;
    @FXML private Label currentScore;
    @FXML private Label timeSpend;
//    exitGamePopUp
    @FXML protected ExitGamePopUpController ExitGamePopUpController;
//    @FXML protected GameCompletePopUpController GameCompletePopUpController;


    public static GameStatus gameState = GameStatus.READY;

    private GameTimer timer = new GameTimer();

    private IntegerProperty timeConsumed = new SimpleIntegerProperty(0);

    private Refresh refresh = new Refresh();

    private int timeDelay = 120;

    GamePanel gamePanel = GamePanel.getInstance();

    public void startGame() {
        gameScene.readMap("/world/World3.txt");

        gameScene.getCanvas();

        GameSceneController.gameState = GameStatus.PLAYING;

        refresh.start();

    }

    public void initialize() {

//        timer = new GameTimer();

        timer.start();

        timeSpend.textProperty().bind(timer.timeToDisplay);
//        timeSpend.textProperty().bind(timeConsumed.asString());

        currentScore.textProperty().bind(gameScene.bonusProperty().asString());

    }
    public int getTime() {
        return timeConsumed.getValue().intValue();
    }


//    public void assignData(int timeDuration, int score) {
//        this.timeDuration = timeDuration;
//        this.score = score;
//s
//        currentScore.setText(String.valueOf(score));
//        timeSpend.setText(String.valueOf(timeDuration));
//    }

    public void mouseClickedBackToMenu(MouseEvent mouseEvent) {
        gameState = GameStatus.PAUSE;
        timer.pause();
        blurEffect();
        ExitGamePopUpController.show();

        ExitGamePopUpController.confirmBack.setOnMouseClicked((event) -> {
            ExitGamePopUpController.hide();
            clearEffect();
            timer.resume();
            gameState = GameStatus.PLAYING;

        });

        ExitGamePopUpController.confirmExit.setOnMouseClicked((event) -> {
            timer.stop();
            ExitGamePopUpController.hide();
            clearEffect();
            GamePanel.getInstance().toIndex();
        });
    }

    private void blurEffect() {
        GaussianBlur gaussianBlur = new GaussianBlur();
        gaussianBlur.setRadius(22);
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
                case PLAYING:

//                    timeSpend.textProperty().set(String.valueOf(timeConsumed.getValue().intValue()));
                    timeConsumed.set(timeConsumed.getValue().intValue() + 1);
                    System.out.println(timeConsumed.getValue().intValue()/60);
//                    System.out.println(getTime());
                    gameScene.updatePosition();
                    gameScene.paintComponent();
                    break;

                case PAUSE:
                    break;

                case WIN:
                case LOSE:
                    if (timeDelay <= 0) {
                        GameOver gameOver = new GameOver();
                        gameOver.init(gameState, timeConsumed.getValue().intValue()/60, gameScene.bonusProperty().getValue().intValue());
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