package com.example.gestionmediathequev2;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;


public class Livreinfocontroller implements Initializable {
    protected ObservableList<Livreitem> liverinfo= FXCollections.observableArrayList();
    private HBox acteurcont;
    Connection cnx;
    private ResultSet result,result1;
    private PreparedStatement st,st1;

    @FXML
    private BorderPane backhpage;
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;

    @FXML
    private ImageView filmimager;

    @FXML
    private Label nomedi;

    @FXML
    private Label nomfilm;

    @FXML
    private Label nomprodu;

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


    void showliverinfo(){
        String str=Itemcontroller.getNomfl();
        String myrq="select * from livres";

        try {

            st=cnx.prepareStatement(myrq);
            result= st.executeQuery();
            //st.setString(1,Itemcontroller.getIdfim1());
            while (result.next()){
                liverinfo.add(new Livreitem(result.getString("numerolivre"),result.getString("titre"),result.getString("maisonedition"),result.getDouble("prix"),result.getInt("nombrepages"),result.getBlob("imageL")));
            }
            for(Livreitem livreitem : liverinfo) {
                if(livreitem.getTitel().equals(str)) {
                    String stri=String.valueOf(livreitem.getNbrpages());
                    nomfilm.setText(livreitem.getTitel());
                    nomprodu.setText(stri);
                    nomedi.setText(String.valueOf(livreitem.getPrice()));
                    nomreal.setText(livreitem.getMaisonidetion());
                    byte bytimage[];
                    Blob blob = livreitem.getImgsrc();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cnx= Connectionmysql.connectionDB();
        showliverinfo();

    }

    public void gotoaudio4(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("audiopage.fxml"));
        Node N = (Node) mouseEvent.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}

