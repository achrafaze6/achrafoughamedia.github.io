package com.example.gestionmediathequev2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AudiodataemCn {

    Connection cnx;
    private ResultSet result,result2;
    private PreparedStatement st1,st2;
    @FXML
    private Label id1;

    @FXML
    private Label nfilm1;
    private Audioitem audioitem;

    @FXML
    void getacteur(MouseEvent event) {

    }

    @FXML
    void rendre2(MouseEvent event) throws SQLException {
        cnx= Connectionmysql.connectionDB();
        st1=cnx.prepareStatement("delete from emprunt where idcd=? and idadherent=?");
        st1.setString(1,id1.getText());
        st1.setString(2,AdherenadminController.getcuid());
        st1.executeUpdate();
    }
    void setData(Audioitem audioitem){
        this.audioitem =audioitem;
        id1.setText(audioitem.getIdaudio());
        nfilm1.setText(audioitem.getNomaudio());

    }

}
