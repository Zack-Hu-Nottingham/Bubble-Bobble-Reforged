package com.ae2dms;

import com.ae2dms.util.GameTimer;
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
 * contains method that can switch the scene, for example from
 * menu page to game scene, from game scene to game over scene
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
	 * The theme of the game (shared among the whole game).
	 */
	public static Theme theme = Theme.RED;
	/**
	 * The difficulty of the game (shared among the whole game).
	 */
	public static Difficulty difficulty = Difficulty.LOW;

	/**
	 * The gameTimer that records the time of the game (shared among the whole game).
	 */
	public static GameTimer gameTimer;
	/**
	 * The bonus earned through the game (shared among the whole game).
	 */
	public static IntegerProperty bonus;
	/**
	 * The gameStatus of the game (shared among the whole game).
	 */
	public static GameStatus gameStatus;
	/**
	 * The stage of the program.
	 */
	public static Stage stage;

	/**
	 * The constant UNIT_SIZE.
	 */
	public static final int UNIT_SIZE = 20;
	/**
	 * The constant WIDTH.
	 */
	public static final int WIDTH = 44,
	/**
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
		loadHelper("/view_fxml/GameScene/gameScene.fxml");
	}

	/**
	 * Load the menuScene's fxml and hand over control to its controller.
	 */
	public void toMenu() {
		loadHelper("/view_fxml/menu/Menu.fxml");
	}

	/**
	 * Load the gameOverScene's fxml based on the game stayus, and hand over control to its controller.
	 */
	public void gameOver() {
		if (gameStatus == GameStatus.WIN) {
			loadHelper("/view_fxml/GameOver/gameOverWin.fxml");
		} else {
			loadHelper("/view_fxml/GameOver/gameOverLose.fxml");
		}
	}

	/**
	 * Load the highScoreScene's fxml and hand over control to its controller.
	 */
	public void viewHighScore() {
		loadHelper("/view_fxml/GameOver/HighScore.fxml");
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
		/**
		 * Low difficulty.
		 */
		LOW,
		/**
		 * Medium difficulty.
		 */
		MEDIUM,
		/**
		 * High difficulty.
		 */
		HIGH
    }

	/**
	 * The enumeration of game theme,and can be modified in setting page.
	 * The theme would decide the wall's style and the bubble's style
	 */
	public enum Theme {
		/**
		 * Red theme.
		 */
		RED,
		/**
		 * Blue theme.
		 */
		BLUE,
		/**
		 * Green theme.
		 */
		GREEN,
		/**
		 * Black theme.
		 */
		BLACK,
		/**
		 * Pink theme.
		 */
		PINK
	}

	/**
	 * The enum Game status, which is the status of the game, with different
	 * status gameScene(the model) would have different behavior.
	 */
	public enum GameStatus {
		/**
		 * Ready game status.
		 */
		READY,
		/**
		 * Playing game status.
		 */
		PLAYING,
		/**
		 * Pause game status.
		 */
		PAUSE,
		/**
		 * Lose game status.
		 */
		LOSE,
		/**
		 * Win game status.
		 */
		WIN
	}
}