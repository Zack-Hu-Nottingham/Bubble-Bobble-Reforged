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
    exports com.ae2dms.Controller;
    opens com.ae2dms.Controller to javafx.fxml;
    exports com.ae2dms.Util;
    opens com.ae2dms.Util to javafx.fxml;
    exports com.ae2dms.Controller.Menu;
    opens com.ae2dms.Controller.Menu to javafx.fxml;
    exports com.ae2dms.Controller.Game;
    opens com.ae2dms.Controller.Game to javafx.fxml;
    exports com.ae2dms.Controller.Game.PopUp;
    opens com.ae2dms.Controller.Game.PopUp to javafx.fxml;

}