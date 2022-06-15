package com.example.gestionmediathequev2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FilmedataemCont {

    @FXML
    private Label id1;

    @FXML
    private Label nfilm1;
    private filmeitem filmeitem1;

    @FXML
    void getacteur(MouseEvent event) {

    }
    private PreparedStatement st1,st2;

    @FXML
    void render(MouseEvent event) throws SQLException {
        Connection cnx = Connectionmysql.connectionDB();
        st1=cnx.prepareStatement("delete from empruntdvd where iddvd=? and idadr=?");
        st1.setString(1,id1.getText());
        st1.setString(2,AdherenadminController.getcuid());
        st1.executeUpdate();

    }
    void setData( filmeitem filmeitem1){
        this.filmeitem1 =filmeitem1;
        id1.setText(filmeitem1.getIdfilm());
        nfilm1.setText(filmeitem1.getNomfilme());


    }

}
