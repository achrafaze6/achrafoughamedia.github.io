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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class audiopage implements Initializable {
    protected ObservableList<Audioitem> audio= FXCollections.observableArrayList();
    Connection cnx;
    private ResultSet resultaudio;
    private PreparedStatement st;
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;
    @FXML
    private GridPane audiocontainer;


    @FXML
    private BorderPane backhpage;

    @FXML
    private TextField serchb1;

    @FXML
    void goTohome3(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hompage.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void gotofilmeage3(MouseEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("filmepage.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void gotolivre3(MouseEvent event)throws IOException {
        root = FXMLLoader.load(getClass().getResource("bookpage.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    void showlivres() {
        String myrq = "select * from cd";
        try {
            st = cnx.prepareStatement(myrq);
            resultaudio = st.executeQuery();
/*
nomaudio

nomalbum

nominterpreteur



Valeurs distinctes


 //resultaudio.getString()
  4
nomediteurad


idaudio Primaire

imagecd

*/
            //(String idaudio,String nomaudio ,String nomalbom,String nomeediteur,String nominterpreteur ,Blob audioim)
            while (resultaudio.next()) {
                audio.add(new Audioitem(resultaudio.getString("idaudio"),resultaudio.getString("nomaudio"),resultaudio.getString("nomalbum"),resultaudio.getString("nomediteurad"),resultaudio.getString("nominterpreteur"),resultaudio.getBlob("imagecd")));
            }
            int columen = 0;
            int row = 0;
            try {
                for (Audioitem audioitem : audio) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("liveritem.fxml"));
                    VBox livreBook = fxmlLoader.load();
                    Itemcontroller itemcontroller = fxmlLoader.getController();
                    itemcontroller.setDataaudio(audioitem);

                    if (columen == 4) {
                        columen = 0;
                        row++;
                    }
                    audiocontainer.add(livreBook, columen++, row);
                    GridPane.setMargin(livreBook, new Insets(10, 10.5, 0, 0));

                }


            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cnx= Connectionmysql.connectionDB();
        showlivres();
    }
}