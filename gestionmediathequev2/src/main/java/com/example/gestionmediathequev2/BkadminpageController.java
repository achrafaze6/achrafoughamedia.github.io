package com.example.gestionmediathequev2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class BkadminpageController implements Initializable {
    private static Image currentimg;
    Connection cnx,cnx1;
    private ResultSet resultliver,result,result3,result4,result5;
    private PreparedStatement st,st3,st1,st4,st5;

    @FXML
    private Button ajouterbtn;
    private static String  Curidsersch;

    @FXML
    private BorderPane backhpage;
    private ObservableList<Livreitem> data2= FXCollections.observableArrayList();
    private ObservableList<Livreitem> mydata= FXCollections.observableArrayList();

    @FXML
    private TextField editeur52;

    @FXML
    private ImageView filmimage  ;


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
    private void Find(MouseEvent event) throws SQLException {

        String str =find1.getText();
        cnx1= Connectionmysql.connectionDB();
        st3=cnx1.prepareStatement("select * from livres where titre = ?");
        st3.setString(1,str);
        resultliver=st3.executeQuery();
        while (resultliver.next())
        {
            mydata.add(new Livreitem(resultliver.getString("numerolivre"),resultliver.getString("titre"),resultliver.getString("maisonedition"),resultliver.getDouble("prix"),resultliver.getInt("nombrepages"),resultliver.getBlob("imageL")));

        }

        for (Livreitem livreitem : mydata)
        {
            if (livreitem.getTitel()!=null)
            {

                Curidsersch=livreitem.getNumero(); // sera utilisée pour modifier la resultat cherchée
                inputnp.setText(String.valueOf(livreitem.getNbrpages()) );
                inputnr.setText(String.valueOf(livreitem.getPrice()));
                inputnf.setText(livreitem.getTitel());
                editeur52.setText(livreitem.getMaisonidetion());
                byte bytimage[];
                Blob blob = livreitem.getImgsrc();
                bytimage = blob.getBytes(1, (int) blob.length());
                Image image = new Image(new ByteArrayInputStream(bytimage));
                currentimg=image;
                filmimage.setImage(image);

            }
        }



    }

    @FXML
    void ajouterf(MouseEvent event) throws SQLException, FileNotFoundException {
        String nomfilm = inputnf.getText();
        int nomppr = parseInt(inputnp.getText());
        String nomre =inputnr.getText();
        String nomiditeur=editeur52.getText();
        File image= new File(imgurl);
        String myrq="insert into livres (titre,maisonedition,nombrepages,prix,imageL) values (?,?,?,?,?) ";
        st = cnx.prepareStatement(myrq);
        st.setString(1,nomfilm);
        st.setString(2,nomiditeur);
        st.setString(3, String.valueOf(nomppr));
        st.setString(4,nomre);
        FileInputStream fs= new FileInputStream(image);
        st.setBinaryStream(5,fs,image.length());
        st.executeUpdate();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"le livre a est ajouté avec succé", ButtonType.OK);
        alert.show();

    }
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;



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
    void backtohm(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hompageadmin.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void gotoaudioadmin(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("audioepageadmin.fxml"));
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
    void gotosanc(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Gestionsanctions.fxml"));
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

        }


    }
    void showlivertable(){
        // str=parseInt(Itemcontroller.getIdfim1());
        String str =Itemcontroller.getIdfim1();
        String myrq2="SELECT * FROM livres order by titre asc ; ";
        try {
            st1=cnx.prepareStatement(myrq2);
            resultliver= st1.executeQuery();
            while (resultliver.next()){
                data2.add(new Livreitem(resultliver.getString("numerolivre"),resultliver.getString("titre"),resultliver.getString("maisonedition"),resultliver.getDouble("prix"),resultliver.getInt("nombrepages"),resultliver.getBlob("imageL")));

            }

            for(Livreitem livreitem : data2) {
                FXMLLoader fxmlLoader = new FXMLLoader();

                fxmlLoader.setLocation(getClass().getResource("bookdata.fxml"));
                Pane livreBook = fxmlLoader.load();
                bkrowcontroller bkrowcontroller1 =fxmlLoader.getController();
                bkrowcontroller1.setdatatorow2(livreitem);
                tablefcn.getChildren().add(livreBook);



            }

        }catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void modifier(MouseEvent event) throws SQLException, FileNotFoundException {
        String nomfilm = inputnf.getText();
        String nomppr =inputnp.getText();
        String nomre =inputnr.getText();
        String nomiditeur=editeur52.getText();
        File image= new File(imgurl);
        st5=cnx.prepareStatement("update table livres set (titre,maisonedition,nombrepages,prix,imageL) values (?,?,?,?,?) where idaudio =?");
        st5.setString(1,String.valueOf(nomfilm) );
        st5.setString(2,String.valueOf(nomre));
        st5.setString(3,nomppr);
        st5.setString(4,nomiditeur);
        st5.setString(6,Curidsersch);
        FileInputStream fs= new FileInputStream(image);
        st5.setBinaryStream(5,fs,image.length());
        st5.executeUpdate();
        Alert   alert = new Alert(Alert.AlertType.CONFIRMATION,"le filme est modifié avec succé", ButtonType.OK);
        alert.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cnx= Connectionmysql.connectionDB();
        showlivertable();

    }

    public void gotolivreadmin(MouseEvent mouseEvent) {
    }

    public void gotolivre1(MouseEvent mouseEvent) {
    }
}