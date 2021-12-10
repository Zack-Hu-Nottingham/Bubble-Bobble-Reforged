package com.ae2dms.controller.gameOver;

import com.ae2dms.GamePanel;
import com.ae2dms.util.GameRecorder;
import com.ae2dms.util.GameTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The controller of highScore scene.
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
     * Initialize the highScore controller.
     *
     * @throws IOException the io exception
     */
    public void initialize() throws IOException {
        bindScore();
    }

    private ArrayList<String > name;
    private ArrayList<Integer> score;
    private ArrayList<Integer> timeConsumed;

    /**
     * Get records from records.txt and bind them with the score labels in fxml.
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

    /**
     * Set the first row of record.
     */
    public void setFirstRecord() {
        name1.setText(name.get(0));
        score1.setText(String.valueOf(score.get(0)));
        time1.setText(GameTimer.parseToTimeFormat(timeConsumed.get(0)));
    }

    /**
     * Set the second row of record.
     */
    public void setSecondRecord() {
        name2.setText(name.get(1));
        score2.setText(String.valueOf(score.get(1)));
        time2.setText(GameTimer.parseToTimeFormat(timeConsumed.get(1)));
    }

    /**
     * Set the third row of record.
     */
    public void setThirdRecord() {
        name3.setText(name.get(2));
        score3.setText(String.valueOf(score.get(2)));
        time3.setText(GameTimer.parseToTimeFormat(timeConsumed.get(2)));
    }

    /**
     * Set the forth row of record.
     */
    public void setForthRecord() {
        name4.setText(name.get(3));
        score4.setText(String.valueOf(score.get(3)));
        time4.setText(GameTimer.parseToTimeFormat(timeConsumed.get(3)));
    }

    /**
     * Set the fifth row of record.
     */
    public void setFifthRecord() {
        name5.setText(name.get(4));
        score5.setText(String.valueOf(score.get(4)));
        time5.setText(GameTimer.parseToTimeFormat(timeConsumed.get(4)));
    }

    /**
     * Handle the action that user click back to last scene.
     *
     * @param mouseEvent the mouse event
     */
    public void back(MouseEvent mouseEvent) {
        GamePanel.getInstance().gameOver();
    }
}
