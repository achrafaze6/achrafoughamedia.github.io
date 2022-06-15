package com.example.gestionmediathequev2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Alert.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class logingpag implements Initializable {
    Connection cnx;
    public ResultSet result;
    public PreparedStatement st;

    private Parent root;
    @FXML
    private Pane back1;

    @FXML
    private Button btnconnect;

    @FXML
    private TextField input1;

    @FXML
    private PasswordField input2;

    @FXML
    private Text txtmpass;

    private Scene scene;
    private Stage stage;



    private static String currentemail;
    public void setCurrentemail(String currentemail)
    {
        this.currentemail=currentemail;
    }

    public static String getCurrentemail() {
        return currentemail;
    }

    public void goTolsignup(ActionEvent A) throws IOException {
        root =  FXMLLoader.load(getClass().getResource("hompage.fxml"));
        Node N=(Node) A.getSource();
        stage =(Stage) N.getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void goTohome(ActionEvent A) throws IOException {
        String nomt=input1.getText();
        String pass= input2.getText();
        setCurrentemail(nomt);
        String myrq="select usernameresp, passwordresp from respo where usernameresp = ? and passwordresp =?";
        try {
            st= cnx.prepareStatement(myrq);
            st.setString(1,nomt);
            st.setString(2,pass);
            result =st.executeQuery();

            if(result.next()){
                if(nomt.equals(result.getString("usernameresp").toString())&&pass.equals(result.getString("passwordresp").toString()) ){

                    try {
                        root = FXMLLoader.load(getClass().getResource("hompageadmin.fxml"));
                        Node N = (Node) A.getSource();
                        stage = (Stage) N.getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        scene.setFill(Color.BLACK);
                        stage.show();

                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }

                }
                else {
                    Alert alert= new Alert(AlertType.ERROR,"Nom utilisateur ou mot de pass incorect",javafx.scene.control.ButtonType.OK);
                    alert.show();
                }

            }
            else {
                Alert alert= new Alert(AlertType.ERROR,"Nom utilisateur ou mot de pass incorect",javafx.scene.control.ButtonType.OK);
                alert.show();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cnx= Connectionmysql.connectionDB();

    }
}
