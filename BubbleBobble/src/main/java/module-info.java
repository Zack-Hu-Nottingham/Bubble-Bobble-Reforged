module com.example.bubblebobble {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires javafx.media;


    opens com.ae2dms to javafx.fxml;
    exports com.ae2dms;
    exports com.ae2dms.Model.Scene;
    opens com.ae2dms.Model.Scene to javafx.fxml;
    exports com.ae2dms.Util;
    opens com.ae2dms.Util to javafx.fxml;
    exports com.ae2dms.Controller.Menu;
    opens com.ae2dms.Controller.Menu to javafx.fxml;
    exports com.ae2dms.Controller.GameScene;
    opens com.ae2dms.Controller.GameScene to javafx.fxml;
    exports com.ae2dms.Model.GameObject.Sprite;
    opens com.ae2dms.Model.GameObject.Sprite to javafx.fxml;
    exports com.ae2dms.Controller.GameOver;
    opens com.ae2dms.Controller.GameOver to javafx.fxml;
    exports com.ae2dms.Model.GameObject.Prompt;
    opens com.ae2dms.Model.GameObject.Prompt to javafx.fxml;
    exports com.ae2dms.Model.GameObject.Sprite.Projectile;
    opens com.ae2dms.Model.GameObject.Sprite.Projectile to javafx.fxml;

}