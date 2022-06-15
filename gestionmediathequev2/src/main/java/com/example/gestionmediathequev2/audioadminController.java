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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class audioadminController implements Initializable {
    private static Blob currentimg;
    Connection cnx,cnx1;
    private ResultSet resultliver,result,result3,result4,result5;
    private PreparedStatement st,st2,st1,st4,st3;

    @FXML
    private Button ajouterbtn;
    private ObservableList<Audioitem> mydata= FXCollections.observableArrayList();
    private ObservableList<Audioitem> data2= FXCollections.observableArrayList();

    @FXML
    private BorderPane backhpage;

    @FXML
    private TextField editeur52;

    @FXML
    private ImageView filmimage;

    @FXML
    private TextField find1;

    @FXML
    private TextField inputnf;

    @FXML
    private TextField inputnp;

    @FXML
    private TextField inputnr;

    @FXML
    private ImageView success;

    @FXML
    private VBox tablefcn;
    private String imgurl;

    @FXML
    void Find(MouseEvent event) throws SQLException {
        String str =find1.getText();
        cnx1= Connectionmysql.connectionDB();
        st3=cnx1.prepareStatement("select * from cd where nomaudio = ?");
        st3.setString(1,str);
        resultliver=st3.executeQuery();
        //public Audioitem(String idaudio,String nomaudio ,String nomalbom,String nomeediteur,String nominterpreteur ,Blob audioim){

        while (resultliver.next())
        {
            mydata.add( new Audioitem(resultliver.getString("idaudio"),resultliver.getString("nomaudio"),resultliver.getString("nomalbum"),resultliver.getString("nomediteurad"),resultliver.getString("nominterpreteur"),resultliver.getBlob("imagecd")));
        }

        for (Audioitem audioitem: mydata)
        {
            if (audioitem.getNomaudio()!=null)
            {

                //Curidsersch=livreitem.getNumero(); // sera utilisée pour modifier la resultat cherchée
                inputnp.setText(String.valueOf(audioitem.getNominterpreteur()) );
                inputnr.setText(String.valueOf(audioitem.getNomeediteur()));
                inputnf.setText(audioitem.getNomaudio());
                editeur52.setText(audioitem.getNomalbom());
                byte bytimage[];
                Blob blob = audioitem.getAudioim();
                currentimg=blob;
                bytimage = blob.getBytes(1, (int) blob.length());
                Image image = new Image(new ByteArrayInputStream(bytimage));
                filmimage.setImage(image);

            }
        }




    }

    @FXML
    void ajouterf(MouseEvent event) {

    }

    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;
    @FXML
    void gotosanc(MouseEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Gestionsanctions.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void backtohm(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hompageadmin.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void gotoadr(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("adherentpageadmin.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }



    @FXML
    void gotoffadmin(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("filmepageadmin.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void gotolivre1(MouseEvent event) {


    }

    @FXML
    void gotolivreadmin(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("bookpageadmin.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void importimage(MouseEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg"));
        File f=fc.showOpenDialog(null);
        if(f!=null){
            this.imgurl=f.getAbsolutePath();
            Image image=new Image(f.toURI().toString(),200,308,true,true);
            this.filmimage.setImage(image);

        }}

    @FXML
    void modifier(MouseEvent event) {

    }
    void showcdtable(){
        String str =Itemcontroller.getIdfim1();
        String myrq2="SELECT * FROM cd order by nomaudio asc ; ";
        try {
            st1=cnx.prepareStatement(myrq2);
            resultliver= st1.executeQuery();
            while (resultliver.next()){
                data2.add( new Audioitem(resultliver.getString("idaudio"),resultliver.getString("nomaudio"),resultliver.getString("nomalbum"),resultliver.getString("nomediteurad"),resultliver.getString("nominterpreteur"),resultliver.getBlob("imagecd")));

            }


            for(Audioitem audioitem: data2) {
                FXMLLoader fxmlLoader = new FXMLLoader();

                fxmlLoader.setLocation(getClass().getResource("audiodata.fxml"));
                Pane livreBook = fxmlLoader.load();
                audiorowController audiorowController1 =fxmlLoader.getController();
                audiorowController1.setdatatorow3(audioitem);
                tablefcn.getChildren().add(livreBook);



            }

        }catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cnx= Connectionmysql.connectionDB();
        showcdtable();
    }


    public void gotoaudioadmin(MouseEvent mouseEvent) {
    }
}
