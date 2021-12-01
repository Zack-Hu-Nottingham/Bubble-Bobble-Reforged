package com.ae2dms.Scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {
    public static void load(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Menu.class.getResource("/fxml/menu/Menu.fxml"));
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}