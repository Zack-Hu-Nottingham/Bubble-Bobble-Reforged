package com.ae2dms.Controller.Menu;

import com.ae2dms.GamePanel;
import com.ae2dms.Util.SoundEffect;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MenuController {
//    public Pane highScoreScene;
    @FXML
    private ImageView exitGameButton;

    @FXML
    private ImageView startGameButton;

//    @FXML
//    private ImageView information;

    @FXML
    private InformationController informationSceneController;

    @FXML
    private HighScoreBarController highScoreSceneController;



    public void initialize() {

    }
    @FXML
    void mouseClickedStartGame(MouseEvent event) {
        SoundEffect.play("/sound/click.mp3");
        GamePanel.getInstance().gameStart();
        System.out.println("start");
    }

    @FXML
    void mouseEnteredStartGame(MouseEvent event) {
        startGameButton.setOpacity(0.8);
//        SoundEffect.play("/sound/Forest.wav");
    }

    @FXML
    void mouseExitStartGame(MouseEvent event) {
        startGameButton.setOpacity(1);
    }

    public void mouseClickedExitGame(MouseEvent mouseEvent) {
        SoundEffect.play("/sound/click.mp3");
        System.exit(0);
    }

    public void mouseClickedInformation(MouseEvent mouseEvent) throws IOException {
        informationSceneController.show();
    }

    public void mouseEnteredExitGame(MouseEvent mouseEvent) {
        exitGameButton.setOpacity(0.8);
    }

    public void mouseEnteredInformation(MouseEvent mouseEvent) {
//        information.setOpacity(0.8);
    }

    public void mouseExitExitGame(MouseEvent mouseEvent) {
        exitGameButton.setOpacity(1);
    }

    public void mouseExitInformation(MouseEvent mouseEvent) {
//        information.setOpacity(1);
    }

    public void mouseClickedHighScoreList(MouseEvent mouseEvent) {
        highScoreSceneController.show();
    }
}
