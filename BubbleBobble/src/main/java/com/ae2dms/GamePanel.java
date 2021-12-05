package com.ae2dms;

import com.ae2dms.Controller.GameScene.GameSceneController;
import com.ae2dms.Scene.GameScene;
import com.ae2dms.Scene.Menu;
import com.ae2dms.Util.SoundEffect;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * The GamePanel is where the entire game is constantly updated.
 * After every few milliseconds, GamePanel calls the methods that update its InteractableWorld,
 * then repaints the window to display the new drawn graphics.
 */

public class GamePanel {

	public static Font smartisanMaquetteBold;

	public static final int UNIT_SIZE = 20;
	public static final int WIDTH = 44, HEIGHT = 30;
	private Stage stage;

	private static GamePanel instance = new GamePanel();
//	private GameScene gameScene = new GameScene();
	private GameSceneController gameSceneController = new GameSceneController();


	public GamePanel() {}

	public static GamePanel getInstance() { return instance; }

	public void init(Stage stage) throws IOException {

//		smartisanMaquetteBold = Font.loadFont(Main.class.getResourceAsStream("/font/SmartisanMaquetteBold.ttf"), 20);

		this.stage = stage;
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, UNIT_SIZE * WIDTH, UNIT_SIZE * HEIGHT);

		stage.setTitle("Bubble Bobble");
		String imgUrl = GamePanel.class.getResource("/image/ui/icon/icon.jpg").toString();
		stage.getIcons().add(new Image(imgUrl));

		stage.setResizable(false);
		stage.setScene(scene);
		stage.setWidth(1294);
		stage.setHeight(750);

//		Parent root = FXMLLoader.load(Menu.class.getResource("/fxml/exitGamePopUp.fxml"));
//		Scene scene = new Scene(root, 1280, 720);
//		stage.setScene(scene);

//		GameOver.load();
		toMenu();
		stage.show();
	}

	public void gameStart(GameScene.Theme theme, SoundEffect.Volume volume) {
		GameScene.load();
		gameSceneController.startGame(theme, volume);
//		gameSceneController.initialize();

		//		gameScene.init(stage);
	}

	public void toMenu() {
		Menu.load();
	}
	public void gameOver() {
//		System.out.println("game over");

//		String sound = success? "/sound/success.wav" : "/sound/aiyouwodemaya.mp3";
//		SoundEffect.play(sound);
//		gameScene.clear(stage);
//		GameOver.load(stage, success);
	}

}