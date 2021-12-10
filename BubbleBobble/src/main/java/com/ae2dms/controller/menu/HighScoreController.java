package com.ae2dms.controller.menu;

import com.ae2dms.util.GameRecorder;
import com.ae2dms.util.GameTimer;
import com.ae2dms.util.SoundEffect;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The controller of High score page.
 */
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

    /**
     * The Menu controller.
     */
    @FXML
    private MenuController menuController;

    /**
     * Gets controller.
     *
     * @param menuController the menu controller
     */
    public void getController(MenuController menuController) {
        this.menuController = menuController;
    }

    /**
     * Show.
     *
     * @throws IOException the io exception
     */
    public void show() throws IOException {
        HighScoreBar.setVisible(true);

        menuController.hideButton();
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), HighScoreBar);
        translateTransition.setByY(-731);
        bindScore();
        translateTransition.play();
    }

    /**
     * Hide.
     */
    @FXML
    public void hide() {
        SoundEffect.getInstance().play("click");

        menuController.showButton();
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), HighScoreBar);
        translateTransition.setByY(731);
        translateTransition.play();
    }

    private ArrayList<String > name;
    private ArrayList<Integer> score;
    private ArrayList<Integer> timeConsumed;

    /**
     * Bind score.
     *
     * @throws IOException the io exception
     */
    public void bindScore() throws IOException {
        GameRecorder gameRecorder = new GameRecorder();
		gameRecorder.readRecord();
        name = gameRecorder.getName();
        score = gameRecorder.getScore();
        timeConsumed = gameRecorder.getTimeConsumed();
        int recordNum = gameRecorder.getRecordNum();
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
        if (recordNum >= 5) {
            setFirstRecord();
            setSecondRecord();
            setThirdRecord();
            setForthRecord();
            setFifthRecord();
        }
    }

    private void setFirstRecord() {
        name1.setText(name.get(0));
        score1.setText(String.valueOf(score.get(0)));
        time1.setText(GameTimer.parseToTimeFormat(timeConsumed.get(0)));
    }

    private void setSecondRecord() {
        name2.setText(name.get(1));
        score2.setText(String.valueOf(score.get(1)));
        time2.setText(GameTimer.parseToTimeFormat(timeConsumed.get(1)));
    }

    private void setThirdRecord() {
        name3.setText(name.get(2));
        score3.setText(String.valueOf(score.get(2)));
        time3.setText(GameTimer.parseToTimeFormat(timeConsumed.get(2)));
    }

    private void setForthRecord() {
        name4.setText(name.get(3));
        score4.setText(String.valueOf(score.get(3)));
        time4.setText(GameTimer.parseToTimeFormat(timeConsumed.get(3)));
    }

    private void setFifthRecord() {
        name5.setText(name.get(4));
        score5.setText(String.valueOf(score.get(4)));
        time5.setText(GameTimer.parseToTimeFormat(timeConsumed.get(4)));
    }
}
