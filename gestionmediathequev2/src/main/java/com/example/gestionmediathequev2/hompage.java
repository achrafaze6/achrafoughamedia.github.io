package com.example.gestionmediathequev2;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class hompage {

    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;


    @FXML
    private BorderPane backhpage;

    @FXML
    private TextField serchb1;

    @FXML
    public void gotologing(MouseEvent A)  throws IOException {
        root =  FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Node N=(Node) A.getSource();
        stage =(Stage) N.getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void gotoaudio1(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("audiopage.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void gotofilmeage1(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("filmepage.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void gotoinfo(MouseEvent event) throws IOException {
        FXMLLoader newlaod = new  FXMLLoader(getClass().getResource("userinfo.fxml"));
        Parent root = newlaod.load();
        //Node N = (Node) event.getSource();
        //stage = (Stage) N.getScene().getWindow();
        Stage stage13 = new Stage();

        stage13.setScene(new Scene(root));
        stage13.show();
    }



        @FXML
    void gotolivre1(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("bookpage.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
