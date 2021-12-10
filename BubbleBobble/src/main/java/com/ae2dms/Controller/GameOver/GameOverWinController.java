package com.ae2dms.Controller.GameOver;

import com.ae2dms.Controller.Menu.SettingController;
import com.ae2dms.GamePanel;
import com.ae2dms.Util.GameRecorder;
import com.ae2dms.Util.GameTimer;
import com.ae2dms.Util.SoundEffect;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * The controller of gameOver win scene.
 */
public class GameOverWinController {
    /**
     * The Back to menu button(implement with Imageview).
     */
    @FXML
    private ImageView backToMenu;

    /**
     * The Play again button (implement with Imageview).
     */
    @FXML
    private ImageView playAgain;

    /**
     * The text field that let player enter his name.
     */
    @FXML
    private TextField userName;

    /**
     * The Save record button (implement with Imageview).
     */
    @FXML
    private ImageView saveRecord;

    @FXML
    private Label time;

    @FXML
    private Label score;

    private Image saved = new Image(SettingController.class.getResource("/image/ui/gameScene/endGamePopUp/savedRecord.png").toString());
    private boolean isSaved = false;

    /**
     * Handles the action that user click save records button.
     *
     * @param mouseEvent the mouse event
     * @throws IOException the io exception
     */
    public void clickSaveRecord(MouseEvent mouseEvent) throws IOException {
        SoundEffect.getInstance().play("click");

        if (!isSaved) {
            GameRecorder gameRecorder = new GameRecorder();
            gameRecorder.saveRecord(userName.getText(), GamePanel.bonus.getValue(), GamePanel.gameTimer.getTime());
            saveRecord.setImage(saved);
            isSaved = true;
        }
    }

    /**
     * Initialize the controller and set the label "score" and "time" with corresponding value.
     */
    public void initialize() {
        time.textProperty().set(GameTimer.parseToTimeFormat(GamePanel.gameTimer.getTime()));
        score.textProperty().set(GamePanel.bonus.getValue().toString());
    }

    /**
     * Handle the action that user click back to menu button.
     *
     * @param mouseEvent the mouse event
     */
    public void clickBackToMenu(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        GamePanel.getInstance().toMenu();
    }

    /**
     * Handle the action that user click play again button.
     *
     * @param mouseEvent the mouse event
     */
    public void clickPlayAgain(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        GamePanel.getInstance().startGame();
    }

    /**
     * Handle the action that user click view high score cutton.
     *
     * @param mouseEvent the mouse event
     */
    public void clickViewHighScore(MouseEvent mouseEvent) {
        GamePanel.getInstance().viewHighScore();
    }
}
