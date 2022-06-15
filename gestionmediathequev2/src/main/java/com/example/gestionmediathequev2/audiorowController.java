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

import static java.lang.String.valueOf;

public class audiorowController {
    Connection cnx,cnx1;
    private ResultSet resultliver,result,result3,result4,result5;
    private PreparedStatement st,st2,st1,st4,st5;


    @FXML
    private Label editeur11;

    @FXML
    private Label id1;

    @FXML
    private Label nfilm1;

    @FXML
    private Label npro1;

    @FXML
    private Label nrea1;
    private Audioitem audioitem;

    @FXML
    void deletfilm(MouseEvent event) throws SQLException {
        cnx= Connectionmysql.connectionDB();
        String idact = id1.getText();
        String myrq="delete from cd where livres.numerolivre=?";
        st2=cnx.prepareStatement(myrq);
        st2.setString(1,idact);
        st2.executeUpdate();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"le cd est supprimé avec succé", ButtonType.OK);
        alert.show();

    }

    @FXML
    void getacteur(MouseEvent event) {

    }
    void setdatatorow3(Audioitem audioitem){
        this.audioitem =audioitem;
        id1.setText(audioitem.getIdaudio());
        nfilm1.setText(audioitem.getNomaudio());
        npro1.setText(audioitem.getNomalbom());
        String np= valueOf(audioitem.getNomeediteur());
        String price =valueOf(audioitem.getNominterpreteur());
        nrea1.setText(np);
        editeur11.setText(price);
    }

}
