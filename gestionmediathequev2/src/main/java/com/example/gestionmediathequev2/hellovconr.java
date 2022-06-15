package com.example.gestionmediathequev2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class hellovconr {
    private Parent root;
    private Scene scene;
    private Stage stage;




    public void goTosgIn5(ActionEvent A) throws IOException {
      root =  FXMLLoader.load(getClass().getResource("hompage.fxml"));
      Node N=(Node) A.getSource();
        stage =(Stage) N.getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
}
