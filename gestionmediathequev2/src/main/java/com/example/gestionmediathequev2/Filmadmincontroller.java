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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Filmadmincontroller implements Initializable {
    Connection cnx,cnx1;
    private ResultSet resultliver,result,result3,result4,result5;
    private PreparedStatement st,st3,st1,st4,st5;

    @FXML
    private TextField Chercher;
    @FXML
    private VBox tableacteurcn;
    @FXML
    private TextField findadr;

    @FXML
    private ImageView imageadr;
    @FXML
    private  Button ajouterbtn;

    @FXML
    private TextField find1;

    @FXML
    private BorderPane backhpage;
    @FXML
    private VBox tablefcn;

    @FXML
    private ImageView filmimage;


    @FXML
    private  ImageView impo;
    @FXML
    private TextField editeur52;
    void setSuccess(){
        Image image=new Image(new File("img/cheked.png").toURI().toString(),24,28,true,true);
        this.impo.setImage(image);
    }

    @FXML
    private  TextField inputnf;
    private  String imgurl;
    protected ObservableList<filmeitem> data2= FXCollections.observableArrayList();
    protected ObservableList<filmeitem> mydata= FXCollections.observableArrayList();




    @FXML
    private TextField inputnp;
    private static String Curidsersch;

    @FXML
    private TextField inputnr;

    /*public static void setData145(Image image,String id,String nf,String np,String nr) {
        filmimage.setImage(image);
        inputnf.setText(nf);
        inputnr.setText(nr);
        inputnp.setText(np);
        editeur52.setText(id);
        impo.setVisible(true);
        ajouterbtn.setDisable(true);

    }
*/
    @FXML
    void ajouterf(MouseEvent event) throws SQLException, FileNotFoundException {
        String nomfilm = inputnf.getText();
        String nomppr =inputnp.getText();
        String nomre =inputnr.getText();
        String nomiditeur=editeur52.getText();
        File image= new File(imgurl);
        String myrq="insert into dvd (nomfilm,nomrealisateur,nomproducteur,nomediteur,imagedvd) values (?,?,?,?,?) ";
        st = cnx.prepareStatement(myrq);
        st.setString(1,nomfilm);
        st.setString(2,nomre);
        st.setString(3,nomppr);
        st.setString(4,nomiditeur);
        FileInputStream fs= new FileInputStream(image);
        st.setBinaryStream(5,fs,image.length());
        st.executeUpdate();
        Alert   alert = new Alert(Alert.AlertType.CONFIRMATION,"le filme a est ajouté avec succé", ButtonType.OK);
        alert.show();

    }


    @FXML
    void Find(MouseEvent event) throws SQLException {
        String str =find1.getText();
        cnx1= Connectionmysql.connectionDB();
        st3=cnx1.prepareStatement("select * from dvd where nomfilm = ?");
        st3.setString(1,str);
        result3=st3.executeQuery();
        while (result3.next())
        {
            mydata.add(new filmeitem(result3.getString("nomfilm"),result3.getString("nomrealisateur"), result3.getString("nomproducteur"), result3.getString("nomediteur"), result3.getBlob("imagedvd") ,result3.getString("iddvd")));

        }

        for (filmeitem filmeitem1 : mydata)
        {
            if (filmeitem1.getNomfilme()!=null)
            {
                Curidsersch=filmeitem1.getIdfilm(); // sera utilisée pour modifier la resultat cherchée
                inputnp.setText(filmeitem1.getNomproducteur());
                inputnr.setText(filmeitem1.getNomrealisateur());
                inputnf.setText(filmeitem1.getNomfilme());
                editeur52.setText(filmeitem1.getNomediteur());
                byte bytimage[];
                Blob blob = filmeitem1.getFilmimg();
                bytimage = blob.getBytes(1, (int) blob.length());
                Image image = new Image(new ByteArrayInputStream(bytimage));
                filmimage.setImage(image);

            }
        }



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
    void gotolivreadmin(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("bookpageadmin.fxml"));
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

        void showfilmetable(){
            // str=parseInt(Itemcontroller.getIdfim1());
            String str =Itemcontroller.getIdfim1();
            String myrq2="SELECT * FROM dvd; ";
            try {
                st1=cnx.prepareStatement(myrq2);
                result= st1.executeQuery();
                while (result.next()){
                    data2.add(new filmeitem(result.getString("nomfilm"),result.getString("nomrealisateur"), result.getString("nomproducteur"), result.getString("nomediteur"), result.getBlob("imagedvd") ,result.getString("iddvd")));

                }


                for(filmeitem filmeitem2 : data2) {
                    FXMLLoader fxmlLoader = new FXMLLoader();

                    fxmlLoader.setLocation(getClass().getResource("filmdata.fxml"));
                    Pane livreBook = fxmlLoader.load();
                    Filmdatacontroller filmdatacontroller =fxmlLoader.getController();
                    filmdatacontroller.setdatatorow(filmeitem2);
                    tablefcn.getChildren().add(livreBook);



                }

            }catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    @FXML
    void ajouteradr(MouseEvent event) {

    }







    @FXML
    void modifieradr(MouseEvent event) {

    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cnx= Connectionmysql.connectionDB();

        showfilmetable();
    }

    public void modifier(MouseEvent mouseEvent) throws SQLException, FileNotFoundException {
        String nomfilm = inputnf.getText();
        String nomppr =inputnp.getText();
        String nomre =inputnr.getText();
        String nomiditeur=editeur52.getText();
        File image= new File(imgurl);
        st5=cnx.prepareStatement("update table dvd set (nomfilm,nomrealisateur,nomproducteur,nomediteur,imagedvd) values (?,?,?,?,?)");
        st5.setString(1,nomfilm);
        st5.setString(2,nomre);
        st5.setString(3,nomppr);
        st5.setString(4,nomiditeur);
        FileInputStream fs= new FileInputStream(image);
        st5.setBinaryStream(5,fs,image.length());
        st5.executeUpdate();
        Alert   alert = new Alert(Alert.AlertType.CONFIRMATION,"le filme est modifié avec succé", ButtonType.OK);
        alert.show();
    }

    public void Findadr(MouseEvent mouseEvent) {
    }

    public void importimageadr(MouseEvent mouseEvent) {
    }
}