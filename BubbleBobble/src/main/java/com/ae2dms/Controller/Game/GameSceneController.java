package com.ae2dms.Controller.Game;

import com.ae2dms.Scene.GameScene;
import com.ae2dms.Util.GameTimer;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;


public class GameSceneController {


    public static StringProperty bonus = new SimpleStringProperty("0");

    private GameTimer timer = new GameTimer();

    @FXML
    public Label currentScore;

    @FXML
    public Label timeSpend;

    public void initialize() {
        System.out.println("initialize");
        timer.start();
        timeSpend.textProperty().bind(timer.timeToDisplay);
        currentScore.textProperty().bind(bonus);

    }

//    public void assignData(int timeDuration, int score) {
//        this.timeDuration = timeDuration;
//        this.score = score;
//
//        currentScore.setText(String.valueOf(score));
//        timeSpend.setText(String.valueOf(timeDuration));
//    }

    public void mouseClickedBackToMenu(MouseEvent mouseEvent) {
    }

    public void mouseEnteredBackToMenu(MouseEvent mouseEvent) {
    }

    public void mouseExitedBackToMenu(MouseEvent mouseEvent) {
    }

//    private void gaussianBlur() {
//        GaussianBlur gaussianBlur = new GaussianBlur();
//        gaussianBlur.setRadius(20);
//        Can_Blur_Group.setEffect(gaussianBlur);
//        this.isBlur.setValue(true);
//    }
}
