package com.example.gestionmediathequev2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Acteurpageediteur implements Initializable {
    Connection cnx,cnx1;
    private ResultSet resultliver,result,result3,result4,result5;
    private PreparedStatement st,st3,st1,st4,st5;


    @FXML
    private Button ajouterbtn;
    protected ObservableList<Acteurs> acteurdata= FXCollections.observableArrayList();
    protected ObservableList<Acteurs> serschresult = FXCollections.observableArrayList();

    @FXML
    private BorderPane backhpage;

    @FXML
    private TextField editeur52;

    @FXML
    private Button ENBTN;



    @FXML
    private TextField findadr;

    @FXML
    private ImageView imageadr;

    @FXML
    private TextField inputnf;

    @FXML
    private ImageView success;

    @FXML
    private VBox tableacteurcn;
    private String imgurl;

    @FXML
    void Findadr(MouseEvent event) throws SQLException {
        ajouterbtn.setDisable(true);
        ENBTN.setDisable(false);
        String str =findadr.getText();
        cnx1= Connectionmysql.connectionDB();
        st3=cnx1.prepareStatement("select * from acteur where nomacteur = ?");
        st3.setString(1,str);
        result3=st3.executeQuery();
        while (result3.next())
        {
            serschresult.add(new Acteurs(result3.getString("idacteur"),result3.getString("nomacteur"),result3.getString("prenomacteur"),result3.getBlob("imgacteur")));
        }


        for (Acteurs acteurs : serschresult)
        {
            if (acteurs.getNomact()!=null)
            {
                inputnf.setText(acteurs.getNomact());
                editeur52.setText(acteurs.getPrenomact());
                byte bytimage[];
                Blob blob = acteurs.getImgact();
                bytimage = blob.getBytes(1, (int) blob.length());
                Image image = new Image(new ByteArrayInputStream(bytimage));
                imageadr.setImage(image);
            }

        }}

    void acteurfilm() throws SQLException {
        String str = null;

        String rqt = "insert into filmacteur (idacteur , idfilm) valus";
        Statement stat=cnx.createStatement();
        result= stat.executeQuery("select MAX(idacteur) AS maxid from acteur;");
        if(result.next()) {
            str = result.getString("maxid");
        }
        System.out.println(str);
        st =cnx.prepareStatement("insert into filmacteur (idacteur,idfilm) values (?,?)");
        st.setString(1,str);
        st.setString(2,Filmdatacontroller.getCureentactid());
        st.executeUpdate();
    }

    @FXML
    void ajouteradr(MouseEvent event) throws SQLException, FileNotFoundException {
        cnx= Connectionmysql.connectionDB();
        String nom=inputnf.getText();
        String preno= editeur52.getText();
        String myrq="insert into acteur (nomacteur,prenomacteur,imgacteur) values (?,?,?)";
        st5=cnx.prepareStatement(myrq);
        File image= new File(imgurl);
        st5.setString(1,nom);
        st5.setString(2,preno);
        FileInputStream fs= new FileInputStream(image);
        st5.setBinaryStream(3,fs,image.length());
        st5.executeUpdate();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"l'acteur est ajouté avec succé", ButtonType.OK);
        alert.show();
        acteurfilm();


    }



    @FXML
    void importimageadr(MouseEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg"));
        File f=fc.showOpenDialog(null);
        if(f!=null){
            this.imgurl=f.getAbsolutePath();
            Image image=new Image(f.toURI().toString(),167,190,true,true);
            this.imageadr.setImage(image);

        }}

    @FXML
    void modifieradr(MouseEvent event) {
        ajouterbtn.setDisable(false);
        String path1="img/user.png";
        inputnf.clear();
        editeur52.clear();
        Image image =new Image(getClass().getResourceAsStream(path1));
        imageadr.setImage(image);

    }
    void showacteurseditteur(){
        String str =Filmdatacontroller.getCureentactid();
        String myrq2="SELECT  * FROM acteur,filmacteur,dvd where acteur.idacteur=filmacteur.idacteur AND dvd.iddvd=filmacteur.idfilm AND filmacteur.idfilm in (?); ";
        try {
            st4=cnx.prepareStatement(myrq2);
            st4.setString(1,str);
            result4= st4.executeQuery();
            while (result4.next()){
                acteurdata.add(new Acteurs(result4.getString("idacteur"),result4.getString("nomacteur"),result4.getString("prenomacteur"),result4.getBlob("imgacteur")));
            }


            for(Acteurs acteurs : acteurdata) {
                FXMLLoader fxmlLoader = new FXMLLoader();

                fxmlLoader.setLocation(getClass().getResource("Adherentdata.fxml"));
                Pane livreBook = fxmlLoader.load();
                Acteurrowcontroller acteurrowcontroller =fxmlLoader.getController();
                acteurrowcontroller.setdatatoacteuredt(acteurs);
                tableacteurcn.getChildren().add(livreBook);



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
        showacteurseditteur();
    }

    public void importimage(MouseEvent mouseEvent) {
    }
}
