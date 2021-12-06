package com.ae2dms.Controller.GameOver;

import com.ae2dms.GamePanel;
import com.ae2dms.Util.GameTimer;
import com.ae2dms.Util.SoundEffect;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GameOverLoseController {

    @FXML
    public Label time;

    @FXML
    public Label score;

    @FXML
    public ImageView backToMenu;

    @FXML
    public ImageView playAgain;

    public void initialize() {
        time.textProperty().set(GameTimer.parseToTimeFormat(GamePanel.gameTimer.getTime()));
        score.textProperty().set(GamePanel.bonus.getValue().toString());
    }

    public void clickBackToMenu(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        GamePanel.getInstance().toMenu();
    }

    public void clickBackPlayAgain(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        GamePanel.getInstance().startGame();
    }
}
