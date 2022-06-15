package com.example.gestionmediathequev2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.SQLException;

public class ActeurscController {

    @FXML
    private ImageView imgact;
    @FXML
    private Label prenomnomact1;

    @FXML
    private Label nomact;
    private Acteurs acteurs;

    void setDataact(){

    }
    void setDatatoacteur(Acteurs acteurs) throws SQLException {

        this.acteurs=acteurs;
        byte bytimage[];
        Blob blob=acteurs.getImgact();
        nomact.setText(acteurs.getNomact());
       prenomnomact1.setText(acteurs.getPrenomact());
        bytimage=blob.getBytes(1,(int) blob.length());
        Image image=new Image(new ByteArrayInputStream(bytimage));
        imgact.setImage(image);
        ;

    }
}

