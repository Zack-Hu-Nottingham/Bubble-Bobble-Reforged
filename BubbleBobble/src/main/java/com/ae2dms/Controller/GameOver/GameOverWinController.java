package com.ae2dms.Controller.GameOver;

import com.ae2dms.Controller.Menu.SettingController;
import com.ae2dms.GamePanel;
import com.ae2dms.Util.GameRecorder;
import com.ae2dms.Util.GameTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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

    private Image saved = new Image(SettingController.class.getResource("/image/ui/gameScene/endGamePopUp/savedRecord.png").toString());
    private boolean isSaved = false;
    public void clickSaveRecord(MouseEvent mouseEvent) throws IOException {
        if (!isSaved) {
            GameRecorder gameRecorder = new GameRecorder();
            gameRecorder.saveRecord(userName.getText(), GamePanel.bonus.getValue(), GamePanel.gameTimer.getTime());
            saveRecord.setImage(saved);
            isSaved = true;
        }
    }

    public void initialize() {
        time.textProperty().set(GameTimer.parseToTimeFormat(GamePanel.gameTimer.getTime()));
        score.textProperty().set(GamePanel.bonus.getValue().toString());
    }

    public void clickBackToMenu(MouseEvent mouseEvent) {
        GamePanel.getInstance().toMenu();
    }

    public void clickPlayAgain(MouseEvent mouseEvent) {
        GamePanel.getInstance().startGame();
    }
}
