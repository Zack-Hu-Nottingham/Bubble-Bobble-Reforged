module com.example.bubblebobble {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.bubblebobble to javafx.fxml;
    exports com.example.bubblebobble;
}