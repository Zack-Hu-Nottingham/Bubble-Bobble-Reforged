package com.ae2dms.Controller.Game;

import com.ae2dms.Controller.Game.PopUp.ExitGamePopUpController;
import com.ae2dms.GamePanel;
import com.ae2dms.Scene.GameScene;
import com.ae2dms.Util.GameStatus;
import com.ae2dms.Util.GameTimer;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class GameSceneController {

    @FXML
    private Canvas canvas;
    @FXML
    public Group blurGroup;

    public static GameStatus gameState = GameStatus.ready;
    public static StringProperty bonus = new SimpleStringProperty("0");

    private GameTimer timer = new GameTimer();

    @FXML
    private Label currentScore;

    @FXML
    private Label timeSpend;

    @FXML
    private ExitGamePopUpController exitGamePopUpController;

    public void initialize() {
        System.out.println("initialize");
        timer.start();
        timeSpend.textProperty().bind(timer.timeToDisplay);
        currentScore.textProperty().bind(bonus);

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
}
