package com.example.gestionmediathequev2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class signup implements Initializable {
    @FXML
    private Pane back2;

    @FXML
    private Button btnR;

    @FXML
    private TextField emailR;

    @FXML
    private PasswordField mpassR;

    @FXML
    private TextField nomR;


    @FXML
    private TextField prenomR;
    @FXML
    private TextField Adresse1;


    private Parent root;
    Connection cnx;
    private ResultSet result,result1;
    private PreparedStatement st,st1;
    private Scene scene;
    private Stage stage;
    public void goTologing(ActionEvent A)  throws IOException {
        root =  FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Node N=(Node) A.getSource();
        stage =(Stage) N.getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


    public void newcompte() throws SQLException {

        String nom,prenom,motdepass,email,adresse;
        nom=nomR.getText();
        prenom=prenomR.getText();
        motdepass=mpassR.getText();
        email=emailR.getText();
        adresse=Adresse1.getText();
        String myrq="INSERT INTO `adherent` (`idadr`,`nom`,`prenom`,`username`,`password`,`Adress`,`email`) VALUES (NULL, ?, ?, ?, ?, ?, ?);";
        if(nom!=""&&prenom!=""&&motdepass!=""&&email!=""&&adresse!=""){
        try {
            st= cnx.prepareStatement(myrq);
            st.setString(1,nom);
            st.setString(2,prenom);
            st.setString(3,email);
            st.setString(4,motdepass);
            st.setString(5,adresse);
            st.setString(6,email);
            st.executeUpdate();

            Alert alert= new Alert(Alert.AlertType.CONFIRMATION,"Votre inscription est fait avec succée", ButtonType.OK);
            alert.show();
            nomR.clear();
            prenomR.clear();
            mpassR.clear();
            Adresse1.clear();
            emailR.clear();

        }catch (SQLException e){
            e.printStackTrace();
            Alert alert= new Alert(Alert.AlertType.ERROR,"Ooops", ButtonType.OK);
            alert.show();
        }


    }
        else {
            Alert alert= new Alert(Alert.AlertType.ERROR,"touts les champs doit ont etre remplits", ButtonType.OK);
            alert.show();

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cnx= Connectionmysql.connectionDB();

    }
}
