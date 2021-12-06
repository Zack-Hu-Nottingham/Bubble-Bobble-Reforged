package com.ae2dms.Controller.GameOver;

import com.ae2dms.GamePanel;
import com.ae2dms.Util.GameTimer;
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
        GamePanel.getInstance().toMenu();
    }

    public void clickBackPlayAgain(MouseEvent mouseEvent) {
        GamePanel.getInstance().startGame();
    }
}
