package com.example.gestionmediathequev2;

import javafx.beans.InvalidationListener;
import javafx.collections.ArrayChangeListener;
import javafx.collections.ObservableArray;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class filmeitem implements ObservableArray<filmeitem> {
    private String idfilm;
    private String nomfilme;
    private String Nomrealisateur;
    private String Nomproducteur;
    private String Nomediteur;
    private Blob filmimg;

    public filmeitem(String nomfilme,String Nomrealisateur,String Nomproducteur ,String Nomediteur,Blob filmimg,String idfilm ){
        this.filmimg =filmimg;
        this.idfilm=idfilm;
        this.Nomediteur=Nomediteur;
        this.nomfilme=nomfilme;
        this.Nomproducteur=Nomproducteur;
        this.Nomrealisateur=Nomrealisateur;
    }


    public void setFilmimg(Blob filmimg) {
        this.filmimg = filmimg;
    }

    public void setNomediteur(String nomediteur) {
        this.Nomediteur = nomediteur;
    }

    public void setNomproducteur(String nomproducteur) {
        this.Nomproducteur = nomproducteur;
    }

    public void setNomfilme(String nomfilme) {
        this.nomfilme = nomfilme;
    }

    public void setNomrealisateur(String nomrealisateur) {
        Nomrealisateur = nomrealisateur;
    }

    public  String getNomediteur() {
        return Nomediteur;
    }

    public String getNomproducteur() {
        return Nomproducteur;
    }

    public Blob getFilmimg() {
        return filmimg;
    }

    public String getNomfilme() {
        return nomfilme;
    }

    public String getNomrealisateur() {
        return Nomrealisateur;
    }

    public void setIdfilm(String idfilm) {
        this.idfilm = idfilm;
    }

    public String getIdfilm() {
        return idfilm;
    }

    @Override
    public void addListener(ArrayChangeListener<filmeitem> arrayChangeListener) {

    }

    @Override
    public void removeListener(ArrayChangeListener<filmeitem> arrayChangeListener) {

    }

    @Override
    public void resize(int i) {

    }

    @Override
    public void ensureCapacity(int i) {

    }

    @Override
    public void trimToSize() {

    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void addListener(InvalidationListener invalidationListener) {

    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {

    }
}
