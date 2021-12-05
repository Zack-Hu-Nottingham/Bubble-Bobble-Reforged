package com.ae2dms.Controller.GameOver;

import com.ae2dms.Scene.GameOver;
import com.ae2dms.Util.GameRecord;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class GameOverWinController {
    @FXML
    public ImageView backToMenu;

    @FXML
    public ImageView playAgain;

    @FXML
    public TextField userName;

    @FXML
    public ImageView saveRecord;

    @FXML
    private Label time;

    @FXML
    private Label score;

//    GameOver gameOver;

    public void clickSaveRecord(MouseEvent mouseEvent) throws IOException {
        GameRecord gameRecord = new GameRecord();
        gameRecord.saveRecord(userName.getText(), GameOver.bonusEarned, GameOver.time);
    }


    public void initialize() {
        time.textProperty().bind(GameOver.timeConsumed);
        score.textProperty().set(String.valueOf(GameOver.bonusEarned));
    }

    public void clickBackToMenu(MouseEvent mouseEvent) {
    }

    public void clickPlayAgain(MouseEvent mouseEvent) {
    }
}
