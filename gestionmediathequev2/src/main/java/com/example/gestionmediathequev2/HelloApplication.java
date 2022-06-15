package com.example.gestionmediathequev2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root= FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            //String css =this.getClass().getResource("style.css").toExternalForm();
            Scene scene = new Scene(root);
            scene.setFill(Color.BLACK);
            stage.initStyle(StageStyle.DECORATED);
            //scene.getStylesheets().add(css);
            stage.setTitle("Médiathèque");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("img/media.png")));
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}