package com.example.gestionmediathequev2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class hompageadmin {
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;

    @FXML
    private BorderPane backhpage;




    @FXML
    void gotoinfo(MouseEvent event) {

    }

    @FXML
    void gotolivre1(MouseEvent event) {

    }
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
    void gotoadr(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("adherentpageadmin.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    void gotosanc(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Gestionsanctions.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    @FXML
    void gotoaudioadmin(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("audioepageadmin.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void gotoffadmin(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("filmepageadmin.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



    @FXML
    void gotolivreadmin(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("bookpageadmin.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }}