package com.ae2dms;

import com.ae2dms.Util.GameTimer;
import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * The GamePanel is where the entire game is constantly updated.
 * After every few milliseconds, GamePanel calls the methods that update its InteractableWorld,
 * then repaints the window to display the new drawn graphics.
 */

public class GamePanel {

	public GamePanel() {}

	private static GamePanel instance = new GamePanel();

	public static GamePanel getInstance() { return instance; }


	public static Theme theme = Theme.RED;
	public static Difficulty difficulty = Difficulty.LOW;

	public static GameTimer gameTimer;
	public static IntegerProperty bonus;
	public static GameStatus gameStatus;
	public static IntegerProperty level;
	public static int chargeLevel;

	public static final int UNIT_SIZE = 20;
	public static final int WIDTH = 44, HEIGHT = 30;

	public void init(Stage stage) throws IOException {

		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, UNIT_SIZE * WIDTH, UNIT_SIZE * HEIGHT);

		stage.setTitle("Bubble Bobble");
		String iconURL = GamePanel.class.getResource("/image/ui/icon/icon.jpg").toString();
		stage.getIcons().add(new Image(iconURL));

		stage.setResizable(false);
		stage.setScene(scene);
		stage.setWidth(1294);
		stage.setHeight(750);

		toMenu();
		stage.show();
	}

	public void startGame() {
		loadHelper("/View_fxml/GameScene/gameScene.fxml");
	}

	public void toMenu() {
		loadHelper("/View_fxml/menu/Menu.fxml");
	}

	public void gameOver() {
		if (gameStatus == GameStatus.WIN) {
			loadHelper("/View_fxml/GameOver/gameOverWin.fxml");
		} else {
			loadHelper("/View_fxml/GameOver/gameOverLose.fxml");
		}
	}


	public static void incrementBonus(int bonus) {
		GamePanel.bonus.set(GamePanel.bonus.get()+bonus);
	}

	public void loadHelper(String fxmlPath) {
		try {
			Parent root = FXMLLoader.load(GamePanel.class.getResource(fxmlPath));
			Main.stage.getScene().setRoot(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public enum Difficulty {
        LOW, MEDIUM, HIGH
    }

	public enum Theme {
		RED, BLUE, GREEN, BLACK, PINK
	}

	public enum GameStatus {
		READY, PLAYING, PAUSE, LOSE, WIN
	}
}