package com.example.gestionmediathequev2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class userinfocontroller implements Initializable {
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;

    @FXML
    private Label Currnom;
    Connection cnx;
    private ResultSet result,result1;
    private PreparedStatement st,st1;

    @FXML
    private TextField adressadr;
    protected ObservableList<Adherent> data3= FXCollections.observableArrayList();

    @FXML
    private BorderPane backhpage;
    private static Adherent adherent1;


    @FXML
    private TextField emailadr;

    @FXML
    private TextField mpassadr;

    @FXML
    private TextField nomadr;

    @FXML
    private TextField prenomadr;

    @FXML
    void Ennom(MouseEvent event) throws SQLException {
        String newname =nomadr.getText();
        String myrq="update adherent set nom= ? where idadr=?";
        st1= cnx.prepareStatement(myrq);
        st1.setString(1,newname);
        st1.setString(2,adherent1.getIdadr());
        st1.executeUpdate();
        nomadr.setEditable(false);
        nomadr.setDisable(true);

    }

    @FXML
    void allowemail(MouseEvent event) {
        emailadr.setEditable(true);
        emailadr.setDisable(false);

    }

    @FXML
    void allowmpass(MouseEvent event) {
        mpassadr.setEditable(true);
        mpassadr.setDisable(false);

    }

    @FXML
    void allownom(MouseEvent event) {
        nomadr.setEditable(true);
        nomadr.setDisable(false);

    }

    @FXML
    void allowprenom(MouseEvent event) {
        prenomadr.setEditable(true);
        prenomadr.setDisable(false);

    }
    @FXML
    void allowaddress(MouseEvent event) {
        adressadr.setEditable(true);
        adressadr.setDisable(false);


    }


    @FXML
    void enaddress(MouseEvent event) throws SQLException {
        String newadress =adressadr.getText();
        String myrq="update adherent set Adress= ? where idadr=?";
        st1= cnx.prepareStatement(myrq);
        st1.setString(1,newadress);
        st1.setString(2,adherent1.getIdadr());
        st1.executeUpdate();
        adressadr.setEditable(false);
        adressadr.setDisable(true);

    }

    @FXML
    void enemail(MouseEvent event) throws SQLException {
        String newemail =emailadr.getText();
        String myrq="update adherent set email= ? where idadr=?";
        st1= cnx.prepareStatement(myrq);
        st1.setString(1,newemail);
        st1.setString(2,adherent1.getIdadr());
        st1.executeUpdate();
        emailadr.setEditable(false);
        emailadr.setDisable(true);

    }

    @FXML
    void enmpass(MouseEvent event) throws SQLException {
        String newpass =mpassadr.getText();
        String myrq="update adherent set password= ? where idadr=?";
        st1= cnx.prepareStatement(myrq);
        st1.setString(1,newpass);
        st1.setString(2,adherent1.getIdadr());
        st1.executeUpdate();
        mpassadr.setEditable(false);
        mpassadr.setDisable(true);

    }

    @FXML
    void enprenom(MouseEvent event) throws SQLException {
        String newname =prenomadr.getText();
        String myrq="update adherent set nom= ? where idadr=?";
        st1= cnx.prepareStatement(myrq);
        st1.setString(1,newname);
        st1.setString(2,adherent1.getIdadr());
        st1.executeUpdate();
        prenomadr.setEditable(false);
        prenomadr.setDisable(true);

    }

    @FXML
    void goTohome4(MouseEvent event) throws IOException {
        root =  FXMLLoader.load(getClass().getResource("hompage.fxml"));
        Node N=(Node) event.getSource();
        stage =(Stage) N.getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public Adherent getAdherent1(){
        return adherent1;
    }
    public void showadrinfo() throws SQLException {
        String cureentemail=logingpag.getCurrentemail();
        String myrq="select * from adherent";
        st=cnx.prepareStatement(myrq);
        result=st.executeQuery();
        while (result.next()){
            data3.add(new Adherent(result.getString("idadr"),result.getString("nom"),result.getString("prenom"),result.getString("Adress"),result.getString("email"),result.getString("password")));
        }
        for (Adherent adherent :data3){
            if(adherent.getEmaiadr().equals(cureentemail)){
                this.adherent1=adherent;
                nomadr.setText(adherent.getNomadr());
                prenomadr.setText(adherent.getPrenomadr());
                mpassadr.setText(adherent.getPassword());
                emailadr.setText(adherent.getEmaiadr());
                adressadr.setText(adherent.getAdressadr());
                Currnom.setText(adherent.getNomadr());
            }
            else {
                System.out.println("not exist");
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cnx= Connectionmysql.connectionDB();
        try {
            showadrinfo();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

