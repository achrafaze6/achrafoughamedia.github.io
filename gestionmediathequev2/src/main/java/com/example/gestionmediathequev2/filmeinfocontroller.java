package com.example.gestionmediathequev2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class filmeinfocontroller implements Initializable {

    @FXML
    private HBox acteurcont;
    Connection cnx;
    private ResultSet result,result1;
    private PreparedStatement st,st1;
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;

    @FXML
    private BorderPane backhpage;

    @FXML
    private ImageView filmimager;

    @FXML
    private Label nomedi;

    @FXML
    private Label nomfilm;
    protected ObservableList<filmeitem> data1= FXCollections.observableArrayList();
    protected ObservableList<Acteurs> data2= FXCollections.observableArrayList();
    protected ObservableList<filmacteur> data3= FXCollections.observableArrayList();


    @FXML
    private Label nomprodu;
    @FXML
    private VBox livernox;

    @FXML
    private Label nomreal;


    @FXML
    private ImageView rtrbtn;
    @FXML
    void goTohome4(MouseEvent event) throws IOException {
        root =  FXMLLoader.load(getClass().getResource("hompage.fxml"));
        Node N=(Node) event.getSource();
        stage =(Stage) N.getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void gotolivre2(MouseEvent event)throws IOException {
        root = FXMLLoader.load(getClass().getResource("bookpage.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void gotofilmeage4(MouseEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("filmepage.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    void showacteurs(){


        // str=parseInt(Itemcontroller.getIdfim1());
        String str =Itemcontroller.getIdfim1();
        String myrq2="SELECT * FROM `filmacteur` ,`acteur`,`dvd` WHERE filmacteur.idacteur=acteur.idacteur AND filmacteur.idfilm =dvd.iddvd AND dvd.iddvd=?; ";
        try {
            st1=cnx.prepareStatement(myrq2);
            st1.setString(1, Itemcontroller.getIdfim1());
            result1= st1.executeQuery();
            while (result1.next()){
                data2.add(new Acteurs(result1.getString("idacteur"),result1.getString("nomacteur"),result1.getString("prenomacteur"),result1.getBlob("imgacteur")));

            }


            for(Acteurs acteurs : data2) {
                FXMLLoader fxmlLoader = new FXMLLoader();

                fxmlLoader.setLocation(getClass().getResource("acteurscard.fxml"));
                VBox livreBook = fxmlLoader.load();
                ActeurscController acteurscController =fxmlLoader.getController();
                acteurscController.setDatatoacteur(acteurs);
                acteurcont.getChildren().add(livreBook);
                HBox.setMargin(livreBook, new Insets(10 ,10.5,0,0));

            }

        }catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    void showfilminfo(){
        String str=Itemcontroller.getNomfl();
        String myrq="select * from dvd";

        try {

            st=cnx.prepareStatement(myrq);
            result= st.executeQuery();
            while (result.next()){
                data1.add(new filmeitem(result.getString("nomfilm"),result.getString("nomrealisateur"), result.getString("nomproducteur"), result.getString("nomediteur"), result.getBlob("imagedvd") ,result.getString("iddvd")));
            }
            for(filmeitem filmeitem1 : data1) {
                if(filmeitem1.getNomfilme().equals(str)) {

                    nomfilm.setText(filmeitem1.getNomfilme());
                    nomprodu.setText(filmeitem1.getNomproducteur());
                    nomedi.setText(filmeitem1.getNomediteur());
                    nomreal.setText(filmeitem1.getNomrealisateur());
                    byte bytimage[];
                    Blob blob = filmeitem1.getFilmimg();
                    bytimage = blob.getBytes(1, (int) blob.length());
                    Image image = new Image(new ByteArrayInputStream(bytimage));
                    filmimager.setImage(image);
                }
                else {
                    System.out.println("notexist");
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void gotoaudio4(MouseEvent event)throws IOException {
        root = FXMLLoader.load(getClass().getResource("audiopage.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();



    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cnx= Connectionmysql.connectionDB();
        showfilminfo();
        showacteurs();




    }


}
