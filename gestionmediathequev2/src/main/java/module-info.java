module com.example.gestionmediathequev2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires fontawesomefx;


    opens com.example.gestionmediathequev2 to javafx.fxml;
    exports com.example.gestionmediathequev2;
}