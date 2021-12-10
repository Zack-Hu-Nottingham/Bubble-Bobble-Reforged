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
 * The GamePanel is the director of this program, which contains
 * the global variable of the game, like difficulty and theme. It
 *
 * The GamePanel is where the entire game is constantly updated.
 * After every few milliseconds, GamePanel calls the methods that update its InteractableWorld,
 * then repaints the window to display the new drawn graphics.
 */
public class GamePanel {

	private GamePanel() {}

	private static GamePanel instance = new GamePanel();

	/**
	 * Gets the instance of GamePanel, as it is not allowed to be created by others.
	 *
	 * @return the instance
	 */
	public static GamePanel getInstance() { return instance; }


	/**
	 * The  theme.
	 */
	public static Theme theme = Theme.RED;
	/**
	 * The constant difficulty.
	 */
	public static Difficulty difficulty = Difficulty.LOW;

	/**
	 * The constant gameTimer.
	 */
	public static GameTimer gameTimer;
	/**
	 * The constant bonus.
	 */
	public static IntegerProperty bonus;
	/**
	 * The constant gameStatus.
	 */
	public static GameStatus gameStatus;
	/**
	 * The constant level.
	 */
	public static IntegerProperty level;
	/**
	 * The constant chargeLevel.
	 */
	public static int chargeLevel;
	/**
	 * The constant stage.
	 */
	public static Stage stage;

	/**
	 * The constant UNIT_SIZE.
	 */
	public static final int UNIT_SIZE = 20;
	/**
	 * The constant WIDTH.
	 */
	public static final int WIDTH = 44, /**
	 * The Height.
	 */
	HEIGHT = 30;

	/**
	 * Initialize the stage with title, icon and width/height, then display the menu and
	 * hand over control to menu's controller
	 *
	 * @param stage the stage
	 * @throws IOException the io exception
	 */
	public void init(Stage stage) throws IOException {
		this.stage = stage;

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

	/**
	 * Load the gameScene's fxml and hand over control to its controller.
	 */
	public void startGame() {
		loadHelper("/View_fxml/GameScene/gameScene.fxml");
	}

	/**
	 * Load the menuScene's fxml and hand over control to its controller.
	 */
	public void toMenu() {
		loadHelper("/View_fxml/menu/Menu.fxml");
	}

	/**
	 * Load the gameOverScene's fxml based on the game stayus, and hand over control to its controller.
	 */
	public void gameOver() {
		if (gameStatus == GameStatus.WIN) {
			loadHelper("/View_fxml/GameOver/gameOverWin.fxml");
		} else {
			loadHelper("/View_fxml/GameOver/gameOverLose.fxml");
		}
	}

	/**
	 * Load the highScoreScene's fxml and hand over control to its controller.
	 */
	public void viewHighScore() {
		loadHelper("/View_fxml/GameOver/HighScore.fxml");
	}


	/**
	 * Increment bonus, when fruit is collected, this method would be called to increment bonus.
	 *
	 * @param bonus the bonus
	 */
	public static void incrementBonus(int bonus) {
		GamePanel.bonus.set(GamePanel.bonus.get()+bonus);
	}

	/**
	 * Load helper, help loading the fxml and set the corresponding scene.
	 *
	 * @param fxmlPath the fxml path
	 */
	public void loadHelper(String fxmlPath) {
		try {
			Parent root = FXMLLoader.load(GamePanel.class.getResource(fxmlPath));
			stage.getScene().setRoot(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The enumeration of game difficulty, which can be modified in seeting
	 * page. With different difficulty level, the enemy's speed, size and the
	 * chance to shoot bubble would vary.
	 */
	public enum Difficulty {
		LOW, MEDIUM, HIGH
    }

	/**
	 * The enumeration of game theme,and can be modified in setting page.
	 * The theme would decide the wall's style and the bubble's style
	 */
	public enum Theme {
		RED, BLUE, GREEN, BLACK, PINK
	}

	/**
	 * The enum Game status, which is the status of the game, with different
	 * status gameScene(the model) would have different behavior.
	 */
	public enum GameStatus {
		READY, PLAYING, PAUSE, LOSE, WIN
	}
}