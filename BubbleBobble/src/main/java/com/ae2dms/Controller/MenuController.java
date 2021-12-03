package com.ae2dms.Controller;

import com.ae2dms.Controller.Menu.HighScoreBarController;
import com.ae2dms.Controller.Menu.InformationController;
import com.ae2dms.GamePanel;
import com.ae2dms.Util.SoundEffect;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MenuController {

    @FXML
    private ImageView informationButton;
    @FXML
    private ImageView exitGameButton;
    @FXML
    private ImageView startGameButton;

    @FXML
    private InformationController informationSceneController;

    @FXML
    private HighScoreBarController highScoreSceneController;


    public void initialize() {

    }


    @FXML
    void mouseClickedStartGame(MouseEvent event) throws IOException {
        SoundEffect.play("/sound/click.mp3");
        GamePanel.getInstance().gameStart();
        System.out.println("start");
    }


    public void mouseClickedExitGame(MouseEvent mouseEvent) {
        SoundEffect.play("/sound/click.mp3");
        System.exit(0);
    }

    public void mouseClickedInformation(MouseEvent mouseEvent) throws IOException {
        informationSceneController.show();
    }

    public void mouseClickedHighScoreList(MouseEvent mouseEvent) {
        highScoreSceneController.show();
    }
}
