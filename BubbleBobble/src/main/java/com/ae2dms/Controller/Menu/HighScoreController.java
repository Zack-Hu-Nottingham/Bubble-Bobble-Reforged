package com.ae2dms.Controller.Menu;

import com.ae2dms.Controller.MenuController;
import com.ae2dms.Util.GameRecord;
import com.ae2dms.Util.GameTimer;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class HighScoreController {

    @FXML
    private Label name1;
    @FXML
    private Label score1;
    @FXML
    private Label time1;
    @FXML
    private Label name2;
    @FXML
    private Label score2;
    @FXML
    private Label time2;
    @FXML
    private Label name3;
    @FXML
    private Label score3;
    @FXML
    private Label time3;
    @FXML
    private Label name4;
    @FXML
    private Label score4;
    @FXML
    private Label time4;
    @FXML
    private Label name5;
    @FXML
    private Label score5;
    @FXML
    private Label time5;


    @FXML
    private Pane HighScoreBar;

    @FXML
    MenuController menuController;

    public void getController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void show() throws IOException {
        menuController.hideButton();
        HighScoreBar.setVisible(true);
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), HighScoreBar);
        translateTransition.setByY(-731);
        bindScore();
        translateTransition.play();
    }

    @FXML
    public void hide() {
        menuController.showButton();
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), HighScoreBar);
        translateTransition.setByY(731);
        translateTransition.play();
//        HighScoreBar.setVisible(false);
    }

    private ArrayList<String > name;
    private ArrayList<Integer> score;
    private ArrayList<Integer> timeConsumed;
    public void bindScore() throws IOException {
        GameRecord gameRecord = new GameRecord();
		gameRecord.readRecord();
        name = gameRecord.getName();
        score = gameRecord.getScore();
        timeConsumed = gameRecord.getTimeConsumed();
        int recordNum = gameRecord.getRecordNum();
        if (recordNum == 0) {
            ;
        }
        if (recordNum == 1) {
            setFirstRecord();
        }
        if (recordNum == 2) {
            setFirstRecord();
            setSecondRecord();
        }
        if (recordNum == 3) {
            setFirstRecord();
            setSecondRecord();
            setThirdRecord();
        }
        if (recordNum == 4) {
            setFirstRecord();
            setSecondRecord();
            setThirdRecord();
            setForthRecord();
        }
        if (recordNum == 5) {
            setFirstRecord();
            setSecondRecord();
            setThirdRecord();
            setForthRecord();
            setFifthRecord();
        }
    }

    public void setFirstRecord() {
        System.out.println("1");
        name1.setText(name.get(0));
        score1.setText(String.valueOf(score.get(0)));
        time1.setText(GameTimer.parseToTimeFormat(timeConsumed.get(0)));
    }

    public void setSecondRecord() {
        System.out.println("2");
        name2.setText(name.get(1));
        score2.setText(String.valueOf(score.get(1)));
        time2.setText(GameTimer.parseToTimeFormat(timeConsumed.get(1)));
    }

    public void setThirdRecord() {
        System.out.println("3");
        name3.setText(name.get(2));
        score3.setText(String.valueOf(score.get(2)));
        time3.setText(GameTimer.parseToTimeFormat(timeConsumed.get(2)));
    }

    public void setForthRecord() {
        System.out.println("4");
        name4.setText(name.get(3));
        score4.setText(String.valueOf(score.get(3)));
        time4.setText(GameTimer.parseToTimeFormat(timeConsumed.get(3)));
    }

    public void setFifthRecord() {
        System.out.println("5");
        name5.setText(name.get(4));
        score5.setText(String.valueOf(score.get(4)));
        time5.setText(GameTimer.parseToTimeFormat(timeConsumed.get(4)));
    }


}
