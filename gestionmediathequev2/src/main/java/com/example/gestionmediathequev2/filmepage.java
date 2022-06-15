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
import java.util.ResourceBundle;

public class filmepage implements Initializable {
    @FXML
    private VBox livreBook;
    private BorderPane backhpage;
    @FXML
    private GridPane gridpn;
    Connection cnx;
    public ResultSet result;
    public PreparedStatement st;
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;


    protected ObservableList<filmeitem> data= FXCollections.observableArrayList();

    @FXML
    private TextField serchb1;

    @FXML
    void goTohome2(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hompage.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void gotoaudio2(MouseEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("audiopage.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
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
    void showfilmitem(){
        String myrq="select * from dvd";
        try {
            st=cnx.prepareStatement(myrq);
            result= st.executeQuery();
            while (result.next()){
                data.add(new filmeitem(result.getString("nomfilm"),result.getString("nomrealisateur"), result.getString("nomproducteur"), result.getString("nomediteur"), result.getBlob("imagedvd") ,result.getString("iddvd")));
              }
            int columen = 0;
            int row = 0;
            try {
                for( filmeitem filmeitem1 : data)
                {
                    FXMLLoader fxmlLoader = new FXMLLoader();

                    fxmlLoader.setLocation(getClass().getResource("item.fxml"));
                    VBox livreBook = fxmlLoader.load();
                    Itemcontroller itemcontroller =fxmlLoader.getController();
                    itemcontroller.setFilmData(filmeitem1);

                    if(columen==4)
                    {
                        columen=0;
                        row++;
                    }
                    gridpn.add(livreBook,columen++,row);
                    GridPane.setMargin(livreBook, new Insets(10 ,10.5,0,0));

                }



            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cnx= Connectionmysql.connectionDB();
        showfilmitem();

    }
}
