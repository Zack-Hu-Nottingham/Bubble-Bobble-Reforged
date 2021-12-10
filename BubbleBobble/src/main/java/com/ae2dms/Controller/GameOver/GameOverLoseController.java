package com.ae2dms.Controller.GameOver;

import com.ae2dms.GamePanel;
import com.ae2dms.Util.GameTimer;
import com.ae2dms.Util.SoundEffect;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * The controller of gameOver lose scene
 */
public class GameOverLoseController {

    /**
     * The Time consumed to play the game.
     */
    @FXML
    private Label time;

    /**
     * The Score earned through the game.
     */
    @FXML
    private Label score;

    /**
     * The Back to menu button (implement with Imageview).
     */
    @FXML
    private ImageView backToMenu;

    /**
     * The Play again button (implement with Imageview).
     */
    @FXML
    private ImageView playAgain;

    /**
     * Initialize the controller and set time and score on the screen.
     */
    public void initialize() {
        time.textProperty().set(GameTimer.parseToTimeFormat(GamePanel.gameTimer.getTime()));
        score.textProperty().set(GamePanel.bonus.getValue().toString());
    }

    /**
     * Handle user click back to menu button.
     *
     * @param mouseEvent the mouse event
     */
    public void clickBackToMenu(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        GamePanel.getInstance().toMenu();
    }

    /**
     * Hanele user click play again.
     *
     * @param mouseEvent the mouse event
     */
    public void clickBackPlayAgain(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        GamePanel.getInstance().startGame();
    }
}
