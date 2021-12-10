package com.ae2dms;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Main launch the game, then hand over the control to game panel(the director
 * of this program) and passing the stage as parameter to the game panel.
 */

public class Main extends Application {

	public static void main(String[] args) throws IOException {
		launch(args);
	}


	@Override
	public void start(Stage stage) throws Exception {
		GamePanel.getInstance().init(stage);
	}
}

