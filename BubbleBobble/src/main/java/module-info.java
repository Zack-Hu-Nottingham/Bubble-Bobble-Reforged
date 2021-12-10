module com.example.bubblebobble {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires javafx.media;


    opens com.ae2dms to javafx.fxml;
    exports com.ae2dms;
    exports com.ae2dms.model.scene;
    opens com.ae2dms.model.scene to javafx.fxml;
    exports com.ae2dms.util;
    opens com.ae2dms.util to javafx.fxml;
    exports com.ae2dms.controller.menu;
    opens com.ae2dms.controller.menu to javafx.fxml;
    exports com.ae2dms.controller.gameScene;
    opens com.ae2dms.controller.gameScene to javafx.fxml;
    exports com.ae2dms.model.gameObject.sprite;
    opens com.ae2dms.model.gameObject.sprite to javafx.fxml;
    exports com.ae2dms.controller.gameOver;
    opens com.ae2dms.controller.gameOver to javafx.fxml;
    exports com.ae2dms.model.gameObject.sprite.prompt;
    opens com.ae2dms.model.gameObject.sprite.prompt to javafx.fxml;
    exports com.ae2dms.model.gameObject.sprite.projectile;
    opens com.ae2dms.model.gameObject.sprite.projectile to javafx.fxml;
    exports com.ae2dms.model.gameObject.sprite.character;
    opens com.ae2dms.model.gameObject.sprite.character to javafx.fxml;

}