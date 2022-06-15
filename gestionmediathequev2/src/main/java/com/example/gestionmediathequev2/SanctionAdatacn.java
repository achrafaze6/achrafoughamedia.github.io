package com.example.gestionmediathequev2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SanctionAdatacn {
    private ResultSet resultliver,result,result3,result4,result5;
    private PreparedStatement st,st2,st1,st4,st3,st5,st6,st7,st8;

    @FXML
    private Label editeur1;

    @FXML
    private Label id;

    @FXML
    private Label nfilm;

    @FXML
    private Label npro;

    @FXML
    private Label nrea;
    private filmeitem filmitem1;
    private Adherent adherent;

    @FXML
    void deleacteur(MouseEvent event) throws SQLException {
        cnx = Connectionmysql.connectionDB();
        st1= cnx.prepareStatement("delete from sanction where idadr=?");
        st1.setString(1,id.getText());
        st1.executeUpdate();

    }
    Connection cnx;
    void setData(Adherent adherent) throws SQLException {
        double sccd=0;
        this.adherent=adherent;
        id.setText(adherent.getIdadr());
        nfilm.setText(adherent.getNomadr());
        npro.setText(adherent.getPrenomadr());
        cnx = Connectionmysql.connectionDB();
        st=cnx.prepareStatement("select montant from sanction where sanction.idadr =? ;");
        st.setString(1,adherent.getIdadr());
        result=st.executeQuery();
        if(result.next())
        {
            sccd=result.getDouble("montant");
        }
        nrea.setText(String.valueOf(sccd));





    }

    public void getacteur(KeyEvent keyEvent) {
    }

    public void deletfilm(KeyEvent keyEvent) {
    }
}
