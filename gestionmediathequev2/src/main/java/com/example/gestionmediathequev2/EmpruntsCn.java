package com.example.gestionmediathequev2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class EmpruntsCn implements Initializable {
    private ResultSet resultliver,result,result3,result4,result5;
    private PreparedStatement st,st2,st1,st4,st3,st5,st6,st7,st8;
    @FXML
    private RadioButton DVDR;

    @FXML
    private BorderPane backhpage;

    @FXML
    private RadioButton cdr;

    @FXML
    private RadioButton livre;

    @FXML
    private VBox emFCN;
    private static Connection cnx;

    @FXML
    private VBox emLCN;

    @FXML
    private VBox emcdC;

    @FXML
    private TextField nomcd;

    @FXML
    private TextField nomf;

    @FXML
    private TextField noml;

    @FXML
    private TextField sersch1;

    @FXML
    private TextField sersch2;

    @FXML
    private TextField sersch3;
    @FXML
    private Button rendrebtn1;

    @FXML
    private Button rendrebtn2;

    @FXML
    void sersch2(MouseEvent event) {

    }

    @FXML
    private Button rendrebtn3;






    private ObservableList<Livreitem> lvres= FXCollections.observableArrayList();
    private ObservableList<filmeitem> dvd= FXCollections.observableArrayList();
    private ObservableList<Audioitem> cd= FXCollections.observableArrayList();


       void showdvd() throws SQLException, IOException {
        st =cnx.prepareStatement("select * from dvd,empruntdvd where dvd.iddvd=empruntdvd.iddvd and empruntdvd.idadr=?");
        st.setString(1,AdherenadminController.getcuid());
        result =st.executeQuery();
        while (result.next())
        {
            dvd.add(new filmeitem(result.getString("nomfilm"),result.getString("nomrealisateur"), result.getString("nomproducteur"), result.getString("nomediteur"), result.getBlob("imagedvd") ,result.getString("iddvd")));

        }
        for(filmeitem filmeitem2 : dvd) {
            FXMLLoader fxmlLoader = new FXMLLoader();

            fxmlLoader.setLocation(getClass().getResource("filmdataem.fxml"));
            Pane livreBook = fxmlLoader.load();
            FilmedataemCont filmedataemCont =fxmlLoader.getController();
            filmedataemCont.setData(filmeitem2);
            emFCN.getChildren().add(livreBook);


    }}
    void showlivre() throws SQLException, IOException {
        System.out.println("je suis ici");
        System.out.println(AdherenadminController.getcuid());
        System.out.println(AdherenadminController.getcuid());

        st1 =cnx.prepareStatement("select * from livres,emprunl where livres.numerolivre=emprunl.idlivre and emprunl.idadr=?");
        st1.setString(1,AdherenadminController.getcuid());

        resultliver =st1.executeQuery();
        while (resultliver.next()){
            lvres.add(new Livreitem(resultliver.getString("numerolivre"),resultliver.getString("titre"),resultliver.getString("maisonedition"),resultliver.getDouble("prix"),resultliver.getInt("nombrepages"),resultliver.getBlob("imageL")));
            System.out.println(lvres.toArray().length);
        }
        for (Livreitem livreitem : lvres) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("livredataem.fxml"));
            Pane livreBook = fxmlLoader.load();
            LivreedataemCont livreedataemCont = fxmlLoader.getController();
            livreedataemCont.setData(livreitem);
            emLCN.getChildren().add(livreBook);
        }

    }
    void showcd() throws SQLException, IOException {
        st2 =cnx.prepareStatement("select * from cd,emprunt where cd.idaudio=emprunt.idcd and emprunt.idadherent=?");
        st2.setString(1,AdherenadminController.getcuid());
        result5 =st2.executeQuery();
        while (result5.next())
        {
            cd.add( new Audioitem(result5.getString("idaudio"),result5.getString("nomaudio"),result5.getString("nomalbum"),result5.getString("nomediteurad"),result5.getString("nominterpreteur"),result5.getBlob("imagecd")));
            System.out.println(cd.toArray().length);

        }
        for (Audioitem audioitem :cd ) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("audiodataem.fxml"));
            Pane livreBook = fxmlLoader.load();
            AudiodataemCn audiodataemCn = fxmlLoader.getController();
            audiodataemCn.setData(audioitem);
            emcdC.getChildren().add(livreBook);
        }

    }
    @FXML
    private RadioButton livreR;



    @FXML
    private TextField entrendid;

    @FXML
    void cdrr(MouseEvent event) {
        DVDR.setSelected(false);
        livreR.setSelected(false);


    }

    @FXML
    void dvdrr(MouseEvent event) {
        livreR.setSelected(false);
        cdr.setSelected(false);

    }

    @FXML
    void livreRR(MouseEvent event) {
        cdr.setSelected(false);
        DVDR.setSelected(false);

    }
    @FXML
    private DatePicker date1;

    @FXML
    void nvemprunt(MouseEvent event) throws SQLException {

        int nblivre = 0;
        int nbDVD = 0;
        int nbCD = 0;
        int nbttL=0;
        int nbitem;
        String cureent=null;
        int nbsc1=0;
        ResultSet rs8;
        /////////////////////////// verifier le nombre des livres deja empruntés ////////////////////////
        st4 =cnx.prepareStatement("select count(idlivre) as nbL from emprunl where idadr=?");
        st4.setString(1,AdherenadminController.getcuid());
        ResultSet rs =st4.executeQuery();
        if (rs.next()){
            nblivre =rs.getInt("nbL");
        }
        st3 =cnx.prepareStatement("select count(iddvd) as nbdvd from empruntdvd where idadr=?");
        st3.setString(1,AdherenadminController.getcuid());
        ResultSet rs1=st3.executeQuery();
        if (rs1.next()){
            nbDVD=rs1.getInt("nbdvd");
        }
        st5 = cnx.prepareStatement("select count(idcd) as nbcd from emprunt where idadherent=?;");
        st5.setString(1,AdherenadminController.getcuid());
        ResultSet rs2= st5.executeQuery();
        if (rs2.next()){
            nbCD=rs2.getInt("nbcd");
        }
        //////////////////////////////////////// verifier si l'elements existe  //////////////////////////////
        System.out.println(nbCD + " "+nbDVD+"  "+ nblivre);
        //////////////////////////////
        st7 =cnx.prepareStatement("SELECT COUNT(empruntdvd.iddvd) AS nbsc FROM sanctiondvd ,empruntdvd WHERE sanctiondvd.iddvd=empruntdvd.idempruntdvd and empruntdvd.idadr=?;");
        st7.setString(1,AdherenadminController.getcuid());
        rs8= st7.executeQuery();
        if (rs8.next())
        {
            nbsc1=rs8.getInt("nbsc");
        }
        if (nbsc1!=0){
            Alert alert =new Alert(Alert.AlertType.ERROR,"cet adherent est sanctioné", ButtonType.OK);
            alert.show();

        }
        if(DVDR.isSelected()==true){

            if (nbsc1!=0) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "cet adherent est sanctioné", ButtonType.OK);
                alert.show();
            }
            else {

                if ((nbCD + nbDVD) < 3) {

                    st = cnx.prepareStatement("select iddvd from empruntdvd  where iddvd=? ");
                    st.setString(1, entrendid.getText());
                    ResultSet rs15 = st.executeQuery();
                    while (rs15.next()) {
                        cureent = rs15.getString("iddvd");
                    }
                    System.out.println(cureent);
                    if (cureent == null) {
                        st6 = cnx.prepareStatement("insert into empruntdvd (iddvd,idadr,dateemd) values (?,?,?)");
                        st6.setString(1, entrendid.getText());
                        st6.setString(2, AdherenadminController.getcuid());
                        st6.setDate(3, Date.valueOf(date1.getValue()));
                        st6.executeUpdate();

                    } else if (cureent != null) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "cet élement est deja emprunté", ButtonType.OK);
                        alert.show();

                    }

                } else if((nbCD + nbDVD) >3 ||(nbCD + nbDVD)==3 ) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "plus de 3 cd ou dvd sont deja empruntés", ButtonType.OK);
                    alert.show();
                    System.out.println(nbCD);


                }

            }

        }
        //////////////

        else if(cdr.isSelected()==true){

            if (nbsc1!=0){
                Alert alert =new Alert(Alert.AlertType.ERROR,"cet adherent est sanctioné", ButtonType.OK);
                alert.show();

            }
            else {
                if ((nbCD + nbDVD) >= 3) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "plus de 3 cd ou dvd sont deja empruntés", ButtonType.OK);
                    alert.show();

                }
                else if ((nbCD + nbDVD) < 3) {

                    st= cnx.prepareStatement("select idcd from emprunt  where idcd=? ");
                    st.setString(1,entrendid.getText());
                    ResultSet rs15=st.executeQuery();
                    while (rs15.next()) {
                        cureent = rs15.getString("idcd");
                    }

                    if(cureent==null) {
                        st6=cnx.prepareStatement("insert into emprunt (idcd,idadherent,dateemprunt) values (?,?,?)");
                        st6.setString(1, entrendid.getText());
                        st6.setString(2, AdherenadminController.getcuid());
                        st6.setDate(3, Date.valueOf(date1.getValue()));
                        st6.executeUpdate();



                    }
                    else if(cureent!=null) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "cet élement est deja emprunté", ButtonType.OK);
                        alert.show();

                    }



            }


        }}
        else if(livreR.isSelected()==true){
            if (nbsc1!=0){
                Alert alert =new Alert(Alert.AlertType.ERROR,"cet adherent est sanctioné", ButtonType.OK);
                alert.show();

            }
            else {
                if ((nblivre) > 5) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "plus de 5 livres sont deja empruntés", ButtonType.OK);
                    alert.show();

                }
                else if(nblivre<=5) {
                    st =cnx.prepareStatement("select idlivre from emprunl where idlivre=?");
                    st.setString(1,entrendid.getText());
                    ResultSet rs10 =st.executeQuery();
                    if(rs10.next()){
                        cureent = rs10.getString("idlivre");
                    }
                    if(cureent==null) {
                        st6 = cnx.prepareStatement("insert into emprunl (idlivre,idadr,dateemL) values (?,?,?)");
                        st6.setString(1, entrendid.getText());
                        st6.setString(2, AdherenadminController.getcuid());
                        st6.setDate(3, Date.valueOf(date1.getValue()));
                        st6.executeUpdate();
                    }
                    else if (cureent==entrendid.getText()){
                        Alert alert = new Alert(Alert.AlertType.ERROR, "cet élement est deja emprunté", ButtonType.OK);
                        alert.show();

                    }

                }

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
    void gotoemp(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("adherentpageadmin.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void refresh(MouseEvent event) throws IOException {
        //AdherenadminController.setCuid(AdherenadminController.getId());
       // FXMLLoader newlaod = new  FXMLLoader(getClass().getResource("Adhereentemprunt.fxml"));
        root = FXMLLoader.load(getClass().getResource("Adhereentemprunt.fxml"));
        Node N = (Node) event.getSource();
        stage = (Stage) N.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }
    LocalDateTime now = LocalDateTime.now();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(now.getDayOfMonth());
        cnx = Connectionmysql.connectionDB();
        try {
            showlivre();
            showcd();
            showdvd();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
