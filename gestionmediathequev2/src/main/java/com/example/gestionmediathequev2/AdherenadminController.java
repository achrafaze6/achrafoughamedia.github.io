package com.example.gestionmediathequev2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdherenadminController {

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
    private Adherent adherent;

    @FXML
    void deleacteur(MouseEvent event) {

    }
    Connection cnx,cnx1;
    private ResultSet resultliver,result,result3,result4,result5;
    private PreparedStatement st,st2,st1,st4,st3;


    @FXML
    void deletfilm(MouseEvent event) throws SQLException {
        cnx= Connectionmysql.connectionDB();
        String curid=id.getText();
        st = cnx.prepareStatement("delete from adherent where idadr=?");
        st.setString(1,curid);
        st.executeUpdate();


    }

    public Label getId() {
        return id;
    }

    private static String cuid;
    public static void setCuid(String cuid){
        cuid=cuid;
    }
    public static String getcuid(){
        return cuid;
    }
    private static String nf;
    public static String getNf(){
        return nf;
    }

    public String getNfilm() {
        return nf ;
    }

    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;

    @FXML
    void getacteur(MouseEvent event) throws IOException {
        this.cuid=id.getText();
        //AdherenadminController.setCuid(AdherenadminController.getId());
        // FXMLLoader newlaod = new  FXMLLoader(getClass().getResource("Adhereentemprunt.fxml"));
        root = FXMLLoader.load(getClass().getResource("Adhereentemprunt.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();


    }
    void setData(Adherent adherent){
        this.adherent= adherent;
        id.setText(adherent.getIdadr());
        nfilm.setText(adherent.getNomadr());
        npro.setText(adherent.getPrenomadr());
        nrea.setText(adherent.getAdressadr());
        editeur1.setText(adherent.getEmaiadr());
    }

}
