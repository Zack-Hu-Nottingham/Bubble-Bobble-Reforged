module com.example.bubblebobble {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires javafx.media;


    opens com.ae2dms to javafx.fxml;
    exports com.ae2dms;
    exports com.ae2dms.Scene;
    opens com.ae2dms.Scene to javafx.fxml;
//    opens com.ae2dms.GameScene to javafx.fxml;
    exports com.ae2dms.GameObject.Controller;
    opens com.ae2dms.GameObject.Controller to javafx.fxml;
}