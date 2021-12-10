package com.ae2dms.Controller.GameScene;

import com.ae2dms.GamePanel;
import com.ae2dms.Model.Scene.GameScene;
import com.ae2dms.Util.GameRecorder;
import com.ae2dms.Util.GameTimer;
import com.ae2dms.Util.SoundEffect;
import javafx.animation.AnimationTimer;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


/**
 * The type Game scene controller.
 */
public class GameSceneController {

    private GameScene gameScene;

    /**
     * The Best record.
     */
    @FXML private Label bestRecord;
    /**
     * The Charge state.
     */
    @FXML private Label chargeState;
    /**
     * The Cover 1.
     */
    @FXML private ImageView cover1;
    /**
     * The Cover 2.
     */
    @FXML private ImageView cover2;
    /**
     * The Cover 3.
     */
    @FXML private ImageView cover3;
    /**
     * The Cover 4.
     */
    @FXML private ImageView cover4;

    // View Node
    @FXML private Canvas canvas;
    /**
     * The Blur group.
     */
    @FXML private Group blurGroup;
    @FXML private Label currentScore;
    @FXML private Label timeSpend;
    /**
     * The Exit game pop up controller.
     */
    @FXML protected ExitGamePopUpController ExitGamePopUpController;
    @FXML private Label levelHint;


    private Refresher refresher = new Refresher();

    private int timeDelay = 120;

    /**
     * Initialize the gameScene controller, which initialize a set of
     * settings that is important for game and then initialize the
     * game.
     */
    public void initialize() {

        GamePanel.gameTimer = new GameTimer();

        GamePanel.bonus = new SimpleIntegerProperty(0);

        GamePanel.gameTimer.start();

        GamePanel.level = new SimpleIntegerProperty(1);

        GamePanel.chargeLevel = 0;

        GameRecorder gameRecorder = new GameRecorder();

        bestRecord.setText(String.valueOf(gameRecorder.getHighestScore()));

        gameScene = new GameScene();

        gameScene.getCanvas(canvas);

        timeSpend.textProperty().bind(GamePanel.gameTimer.timeToDisplay);

        currentScore.textProperty().bind(GamePanel.bonus.asString());

        levelHint.textProperty().bind(GamePanel.level.asString());

        GamePanel.gameStatus = GamePanel.GameStatus.PLAYING;

        refresher.start();
    }


    /**
     * Handle the action that user click back to menu.
     *
     * @param mouseEvent the mouse event
     */
    public void mouseClickedBackToMenu(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        GamePanel.gameStatus = GamePanel.GameStatus.PAUSE;
        GamePanel.gameTimer.pause();
        blurEffect();
        ExitGamePopUpController.show();

        ExitGamePopUpController.confirmBack.setOnMouseClicked((event) -> {
            SoundEffect.getInstance().play("click");

            ExitGamePopUpController.hide();
            clearEffect();
            GamePanel.gameTimer.resume();
            GamePanel.gameStatus = GamePanel.GameStatus.PLAYING;

        });

        ExitGamePopUpController.confirmExit.setOnMouseClicked((event) -> {
            SoundEffect.getInstance().play("click");

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

    /**
     * Clear the blur effect that apply on the blurGroup.
     */
    private void clearEffect() {
        blurGroup.setEffect(null);
    }

    /**
     * Clear charge.
     */
    private void clearCharge() {
        cover1.setOpacity(1);
        cover2.setOpacity(1);
        cover3.setOpacity(1);
        cover4.setOpacity(1);
    }


    private class Refresher extends AnimationTimer {
        @Override
        public void handle(long currentTime) {
            switch (GamePanel.gameStatus){
                case PLAYING:
                    gameScene.getGameScenePainter().paintComponent();
                    break;

                case WIN:
                case LOSE:
                    if (timeDelay <= 0) {
                        GamePanel.getInstance().gameOver();
                        stop();
                    } else {
                        gameScene.getGameScenePainter().paintComponent();
                        timeDelay -= 1;
                    }
                    break;
            }

            if (GamePanel.chargeLevel == 0) {
                clearCharge();
            }
            if (GamePanel.chargeLevel >= 1) {
                cover1.setOpacity(0);
            }
            if(GamePanel.chargeLevel >= 2) {
                cover2.setOpacity(0);
            }
            if(GamePanel.chargeLevel >= 3) {
                cover3.setOpacity(0);
            }
            if (GamePanel.chargeLevel >= 4) {
                cover4.setOpacity(0);
                chargeState.setText("Ready");
            }
        }
    }
}
