package com.example.gestionmediathequev2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.*;

public class Filmdatacontroller {
    Connection cnx;
    private ResultSet result,result2;
    private PreparedStatement st1,st2;

    @FXML
    private Label editeur1;

    @FXML
    private Label id;

    @FXML
    private Label nfilm;

    @FXML
    private Label npro;
    private static String cureentactid;

    @FXML
    private Label nrea;
    private filmeitem filmitem1;
    private Acteurs acteurs;

    @FXML
    void deletfilm(MouseEvent event) throws SQLException {
        String str =id.getText();
        cnx= Connectionmysql.connectionDB();
        st1 = cnx.prepareStatement("DELETE FROM `dvd` WHERE `dvd`.`iddvd` = ?");
        st1.setString(1,str);
        st1.executeUpdate();
        Alert   alert = new Alert(Alert.AlertType.CONFIRMATION,"le filme a est supprimé avec succé", ButtonType.OK);
        alert.show();
    }

    @FXML
    void getact(MouseEvent event) {

    }
    public static String getCureentactid(){
        return cureentactid;
    }
    @FXML
    void modifier(MouseEvent event) {

    }


    @FXML
    void getacteur(MouseEvent event) throws IOException {
        this.cureentactid=id.getText();
        FXMLLoader newlaod = new  FXMLLoader(getClass().getResource("acteurspageadd.fxml"));
        Parent root = newlaod.load();
        //Node N = (Node) event.getSource();
        //stage = (Stage) N.getScene().getWindow();
        Stage stage13 = new Stage();

        stage13.setScene(new Scene(root));
        stage13.show();

    }

    public filmeitem getFilmitem10() {
        return filmitem1;
    }
    void setdatatorow(filmeitem filmeitem1){
        this.filmitem1=filmeitem1;
        id.setText(filmeitem1.getIdfilm());
        nfilm.setText(filmeitem1.getNomfilme());
        npro.setText(filmeitem1.getNomproducteur());
        nrea.setText(filmeitem1.getNomrealisateur());
        editeur1.setText(filmeitem1.getNomediteur());
    }



    @FXML
    private Label idacteur;

    @FXML
    private Label nomacteur;

    @FXML
    private Label prenoomacteur;


    public void deleacteur(MouseEvent mouseEvent) {
    }
}