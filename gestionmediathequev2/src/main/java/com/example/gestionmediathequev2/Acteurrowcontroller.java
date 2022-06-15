package com.example.gestionmediathequev2;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Acteurrowcontroller  {
    Connection cnx;
    private ResultSet result,result2;
    private PreparedStatement st1,st2;

    @FXML
    private Label idacteur;

    @FXML
    private Label nomacteur;

    @FXML
    private Label prenoomacteur;
    private Acteurs acteurs;

    @FXML
    void deleacteur(MouseEvent event) throws SQLException {
        String idact = idacteur.getText();
        String myrq="delete from acteur where acteur.idacteur=?";
        st2=cnx.prepareStatement(myrq);
        st2.setString(1,idact);
        st2.executeUpdate();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"l'acteur a est supprimé avec succé", ButtonType.OK);
        alert.show();



    }

    void setdatatoacteuredt(Acteurs acteurs){
        this.acteurs =acteurs;
        idacteur.setText(acteurs.getIdacteur());
        nomacteur.setText(acteurs.getNomact());
        prenoomacteur.setText(acteurs.getPrenomact());
    }



    @FXML
    void getacteur(MouseEvent event) {

    }

    public void getact(MouseEvent mouseEvent) {
    }

    public void deletfilm(KeyEvent keyEvent) {
    }
}
