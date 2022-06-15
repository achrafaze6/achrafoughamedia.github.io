package com.example.gestionmediathequev2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Sanctioncontroller implements Initializable {

    @FXML
    private BorderPane backhpage;
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;

    @FXML
    private VBox tablefcn;

    @FXML
    void backtohom(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hompageadmin.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private VBox tablefcn1;
    private ObservableList<Adherent> mydata = FXCollections.observableArrayList();
    private ObservableList<Adherent> mydata2 = FXCollections.observableArrayList();
    private ObservableList<Adherent> mydata3 = FXCollections.observableArrayList();

    @FXML
    private VBox tablefcn11;
    Connection cnx;
    private ResultSet resultliver, result, result3, result4, result5;
    private PreparedStatement st, st2, st1, st4, st3, st5, st6, st7, st8;


    void showdataf() {
        String myrq2 = "SELECT * FROM adherent,sanctiondvd where adherent.idadr=sanctiondvd.idadr ; ";
        try {
            st1 = cnx.prepareStatement(myrq2);
            resultliver = st1.executeQuery();
            while (resultliver.next()) {
                mydata.add(new Adherent(resultliver.getString("idadr"), resultliver.getString("nom"), resultliver.getString("prenom"), resultliver.getString("Adress"), resultliver.getString("email"), resultliver.getString("password")));

            }
            for (Adherent adherent : mydata) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("sanctionFdata.fxml"));
                Pane livreBook = fxmlLoader.load();
                SanctionfdataCn adherenadminController = fxmlLoader.getController();
                adherenadminController.setData(adherent);
                tablefcn.getChildren().add(livreBook);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    void showdatacd() {
        String myrq2 = "SELECT * FROM adherent,sanction where adherent.idadr=sanction.idadr ; ";
        try {
            st2 = cnx.prepareStatement(myrq2);
            result4 = st2.executeQuery();
            while (result4.next()) {
                mydata2.add(new Adherent(result4.getString("idadr"), result4.getString("nom"), result4.getString("prenom"), result4.getString("Adress"), result4.getString("email"), result4.getString("password")));

            }
            for (Adherent adherent : mydata2) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("sanctionAdata.fxml"));
                Pane livreBook = fxmlLoader.load();
                SanctionAdatacn adherenadminController = fxmlLoader.getController();
                adherenadminController.setData(adherent);
                tablefcn1.getChildren().add(livreBook);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void showdatacl() {
        String myrq2 = "SELECT * FROM adherent,sanctionl where adherent.idadr=sanctionl.idadr ; ";
        try {
            st3 = cnx.prepareStatement(myrq2);
            result = st3.executeQuery();
            while (result.next()) {
                mydata3.add(new Adherent(result.getString("idadr"), result.getString("nom"), result.getString("prenom"), result.getString("Adress"), result.getString("email"), result.getString("password")));

            }
            for (Adherent adherent : mydata3) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("sanctioLdata.fxml"));
                Pane livreBook = fxmlLoader.load();
                SanctionLvCon adherenadminController = fxmlLoader.getController();
                adherenadminController.setData(adherent);
                tablefcn11.getChildren().add(livreBook);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cnx = Connectionmysql.connectionDB();
        showdatacd();
        showdataf();
        showdatacl();
    }
}