package com.example.gestionmediathequev2 ;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivreedataemCont {

    @FXML
    private Label id1;

    @FXML
    private Label nfilm1;
    private Livreitem livreitem;

    @FXML
    void getacteur(MouseEvent event) {

    }
    Connection cnx;
    private ResultSet result,result2;
    private PreparedStatement st1,st2;

    @FXML
    void rendre1(MouseEvent event) throws SQLException {
        cnx= Connectionmysql.connectionDB();
        st1=cnx.prepareStatement("delete from emprunl where emprunl.idlivre=? and emprunl.idadr=?");
        st1.setString(1,id1.getText());
        st1.setString(2,AdherenadminController.getcuid());
        st1.executeUpdate();

    }



    public void setData(Livreitem livreitem) {
        this.livreitem=livreitem;
        id1.setText(livreitem.getNumero());
        nfilm1.setText(livreitem.getTitel());
    }
}
