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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Aderent1Controller implements Initializable {
    @FXML
    private Button ajouterbtn;

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

    private ObservableList<Adherent> data2= FXCollections.observableArrayList();
    Connection cnx,cnx1;
    private ResultSet resultliver,result,result3,result4,result5;
    private PreparedStatement st,st2,st1,st4,st3;

    @FXML
    private Label editeur1;
    private String Curidsersch;


    @FXML
    private Label id;

    @FXML
    private Label nfilm;

    @FXML
    private Label npro;

    @FXML
    private Label nrea;

    @FXML
    void deleacteur(MouseEvent event) {

    }

    @FXML
    void deletfilm(MouseEvent event) {

    }

    @FXML
    void getacteur(MouseEvent event) {

    }
    void showcdtable(){
        String str =Itemcontroller.getIdfim1();
        String myrq2="SELECT * FROM adherent order by nom asc ; ";
        try {
            st1=cnx.prepareStatement(myrq2);
            resultliver= st1.executeQuery();
            while (resultliver.next()){
                data2.add( new Adherent(resultliver.getString("idadr"),resultliver.getString("nom"),resultliver.getString("prenom"),resultliver.getString("Adress"),resultliver.getString("email"),resultliver.getString("password")) );

            }

            for(Adherent adherent: data2) {
                FXMLLoader fxmlLoader = new FXMLLoader();

                fxmlLoader.setLocation(getClass().getResource("adheent1data.fxml"));
                Pane livreBook = fxmlLoader.load();
                AdherenadminController adherenadminController=fxmlLoader.getController();
                adherenadminController.setData(adherent);
                tablefcn.getChildren().add(livreBook);

            }

        }catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    private ObservableList<Adherent> mydata= FXCollections.observableArrayList();
    @FXML
    private Button empruntbtn;

    @FXML
    private Button enbtn;
    private String curid;

    @FXML
    void Find(MouseEvent event) throws SQLException {
        System.out.println("je suis ici");
        String str =find1.getText();
        cnx1= Connectionmysql.connectionDB();
        st3=cnx1.prepareStatement("select * from adherent where nom = ?");
        st3.setString(1,str);
        resultliver=st3.executeQuery();
        while (resultliver.next())
        {
            mydata.add(new Adherent(resultliver.getString("idadr"),resultliver.getString("nom"),resultliver.getString("prenom"),resultliver.getString("Adress"),resultliver.getString("email"),resultliver.getString("password")) );

        }

        for (Adherent adherent : mydata)
        {
            if (adherent.getNomadr()!=null)
            {
                enbtn.setDisable(false);
                ajouterbtn.setDisable(true);

                Curidsersch=adherent.getIdadr(); // sera utilisée pour modifier la resultat cherchée
                inputnp.setText(adherent.getEmaiadr() ); // email
                inputnr.setText(adherent.getAdressadr()); //adress
                inputnf.setText(adherent.getNomadr()); //1 nom
                editeur52.setText(adherent.getPrenomadr());//2 prenom
                this.curid=adherent.getIdadr();

            }
        }



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cnx= Connectionmysql.connectionDB();
        showcdtable();
    }

    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;




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
    void gotolivreadmin(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("bookpageadmin.fxml"));
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
    void gotoffadmin(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("filmepageadmin.fxml"));
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

    public void gotolivre1(MouseEvent mouseEvent) {
    }

    public void gotoadr(MouseEvent mouseEvent) {
    }

    public void ajouterf(MouseEvent mouseEvent) throws SQLException {
        String nom= inputnf.getText();
        String prenomm= editeur52.getText();
        String Adress = inputnr.getText();
        String email=inputnp.getText();
        cnx= Connectionmysql.connectionDB();
        st=cnx.prepareStatement("insert into adherent (nom,prenom,Adress,email,username,password) values (?,?,?,?,?,?)");
        st.setString(1,nom);
        st.setString(2,prenomm);
        st.setString(3,Adress);
        st.setString(4,email);
        st.setString(5,email);
        st.setString(6,prenomm+"."+nom+"@ENSA");
        st.executeUpdate();
        inputnf.clear();
        inputnp.clear();
        inputnr.clear();
        editeur52.clear();

    }

    public void modifier(MouseEvent mouseEvent) throws SQLException {
        String nom= inputnf.getText();
        String prenomm= editeur52.getText();
        String Adress = inputnr.getText();
        String email=inputnp.getText();
        cnx= Connectionmysql.connectionDB();
        st=cnx.prepareStatement("update adherent set nom = ?,prenom = ?,Adress = ?,email =?  where adherent.idadr=?;");
        st.setString(1,nom);
        st.setString(2,prenomm);
        st.setString(3,Adress);
        st.setString(4,email);
        st.setString(5,curid);
        st.executeUpdate();
        /*inputnf.clear();
        inputnp.clear();
        inputnr.clear();
        editeur52.clear();*/
        ajouterbtn.setDisable(false);
        enbtn.setDisable(true);

    }
}
