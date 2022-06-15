package com.example.gestionmediathequev2;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.SQLException;

public class Itemcontroller {
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;
    private static String nomfl;
    @FXML
    private Label idfilm;
    private static String idfim1;
    @FXML
    private ImageView imgitem;

    @FXML
    private Label livertitel;
    private Livreitem livreitem;
    private filmeitem filmitem1;

    @FXML
    void printto(TouchEvent event) {
        System.out.println("id ets :");
        try {

            nomfl= livertitel.getText();
            root = FXMLLoader.load(getClass().getResource("filmeinfo.fxml"));
            Node N = (Node) event.getSource();
            stage = (Stage) N.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static String getNomfl() {
        return nomfl;
    }
    public static String getIdfim1(){
        return idfim1;
    }
    private Audioitem audioitem;

    @FXML
    void clickme2(MouseEvent event) {
        nomfl= livertitel.getText();
        idfim1=idfilm.getText();
        System.out.println("id ets :");
        try {
            root = FXMLLoader.load(getClass().getResource("livreinfo.fxml"));
            Node N = (Node) event.getSource();
            stage = (Stage) N.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @FXML
    void clickme(MouseEvent event) {
        System.out.println("id ets :");
        try {
            nomfl= livertitel.getText();
            idfim1=idfilm.getText();
            System.out.println("id est:"+idfim1+" "+"nom et:"+nomfl);
            root = FXMLLoader.load(getClass().getResource("filmeinfo.fxml"));
            Node N = (Node) event.getSource();
            stage = (Stage) N.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void setDataaudio(Audioitem audioitem) throws SQLException {
        this.audioitem=audioitem;
        byte bytimage[];
        livertitel.setText(audioitem.getNomaudio());
        System.out.println(audioitem.getNomaudio());
        System.out.println(audioitem.getNomeediteur());
        Blob blob=audioitem.getAudioim();
        idfilm.setText(audioitem.getIdaudio());
        bytimage=blob.getBytes(1,(int) blob.length());
        Image image=new Image(new ByteArrayInputStream(bytimage));
        imgitem.setImage(image);
        livertitel.setText(audioitem.getNomaudio());


    }
    public void setData(Livreitem livreitem) throws SQLException {
        this.livreitem=livreitem;
        byte bytimage[];
        Blob blob=livreitem.getImgsrc();

        idfilm.setText(livreitem.getNumero());
        bytimage=blob.getBytes(1,(int) blob.length());
        Image image=new Image(new ByteArrayInputStream(bytimage));
        imgitem.setImage(image);
        livertitel.setText(livreitem.getTitel());
    }
    public void setFilmData(filmeitem filmeitem1) throws SQLException {
        byte bytimage[];
        Blob blob=filmeitem1.getFilmimg();
        idfilm.setText(filmeitem1.getIdfilm());
        this.filmitem1=filmeitem1;
        bytimage=blob.getBytes(1,(int) blob.length());
        Image image=new Image(new ByteArrayInputStream(bytimage));
        imgitem.setImage(image);
        livertitel.setText(filmeitem1.getNomfilme());

    }

}
