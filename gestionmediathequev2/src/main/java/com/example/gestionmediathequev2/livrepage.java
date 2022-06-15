package com.example.gestionmediathequev2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class livrepage implements Initializable {

    @FXML
    private VBox livreBook;
    private BorderPane backhpage;
    Connection cnx;
    private ResultSet resultliver;
    private PreparedStatement st;
    @FXML
    private GridPane grid;

    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;

    protected ObservableList<Livreitem> liver= FXCollections.observableArrayList();

    @FXML
    private TextField serchb1;

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
    void gotofilmeage4(MouseEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("filmepage.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


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

    //protected ObservableList<Livreitem> data= FXCollections.observableArrayList();



    void showlivres() {
        String myrq = "select * from livres";
        try {
            st = cnx.prepareStatement(myrq);
            resultliver = st.executeQuery();

//Livreitem(String numero,String titel ,String maisonidetion ,Double price, int nbrpages,Blob imgsrc )

            while (resultliver.next()) {
                liver.add(new Livreitem(resultliver.getString("numerolivre"),resultliver.getString("titre"),resultliver.getString("maisonedition"),resultliver.getDouble("prix"),resultliver.getInt("nombrepages"),resultliver.getBlob("imageL")));
            }
            int columen = 0;
            int row = 0;
            try {
                for (Livreitem livreitem : liver) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("liveritem.fxml"));
                    VBox livreBook = fxmlLoader.load();
                    Itemcontroller itemcontroller = fxmlLoader.getController();
                    itemcontroller.setData(livreitem);

                    if (columen == 4) {
                        columen = 0;
                        row++;
                    }
                    grid.add(livreBook, columen++, row);
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

    public void initialize(URL url, ResourceBundle resourceBundle) {
        cnx= Connectionmysql.connectionDB();
            showlivres();


}



}
