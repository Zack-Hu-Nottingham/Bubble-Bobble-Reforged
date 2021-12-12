package com.ae2dms.controller.gameScene;

import com.ae2dms.GamePanel;
import com.ae2dms.model.gameObject.sprite.character.Boss;
import com.ae2dms.model.scene.GameScene;
import com.ae2dms.util.GameRecorder;
import com.ae2dms.util.GameTimer;
import com.ae2dms.util.SoundEffect;
import javafx.animation.AnimationTimer;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


/**
 * The controller of Game scene.
 */
public class GameSceneController {

    /**
     * Hint bar component
     */
    @FXML private ProgressBar bossLife;
    @FXML private Label bestRecord;
    @FXML private Label levelHint;
    @FXML private Label currentScore;
    @FXML private Label timeSpend;
    @FXML private Label chargeState;

    /**
     * The cover for charge state.
     */
    @FXML private ImageView cover1;
    @FXML private ImageView cover2;
    @FXML private ImageView cover3;
    @FXML private ImageView cover4;


    @FXML private Canvas canvas;
    @FXML private Group blurGroup;

    /**
     * The Exit game pop up controller.
     */
    @FXML protected ExitGamePopUpController ExitGamePopUpController;

    private GameScene gameScene;

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

        GameRecorder gameRecorder = new GameRecorder();

        bestRecord.setText(String.valueOf(gameRecorder.getHighestScore()));

        gameScene = new GameScene();

        gameScene.getCanvas(canvas);

        timeSpend.textProperty().bind(GamePanel.gameTimer.timeToDisplayProperty());

        currentScore.textProperty().bind(GamePanel.bonus.asString());

        levelHint.textProperty().bind(gameScene.level.asString());

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

    /**
     * Apply blur effect to background, when confirmation page pop up
     */
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
     * Clear charge status.
     */
    private void clearCharge() {
        cover1.setOpacity(1);
        cover2.setOpacity(1);
        cover3.setOpacity(1);
        cover4.setOpacity(1);
    }

    private void setChargeState() {

        if (gameScene.chargeLevel == 0) {
            clearCharge();
        }
        if (gameScene.chargeLevel >= 1) {
            cover1.setOpacity(0);
        }
        if(gameScene.chargeLevel >= 2) {
            cover2.setOpacity(0);
        }
        if(gameScene.chargeLevel >= 3) {
            cover3.setOpacity(0);
        }
        if (gameScene.chargeLevel >= 4) {
            cover4.setOpacity(0);
            chargeState.setText("Ready");
        }
    }

    private void setBossLife() {
        if (gameScene.level.getValue() == 4) {
            if (!bossLife.visibleProperty().getValue()) {
                bossLife.setVisible(true);
            }
            if (!gameScene.getBosses().isEmpty()) {
                Boss boss = gameScene.getBosses().get(0);
                bossLife.setProgress((double) (boss.getLife()-boss.getDamage())/boss.getLife());
            }
        }
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
            setChargeState();
            setBossLife();
        }
    }
}
