package com.example.gestionmediathequev2;

import javafx.beans.InvalidationListener;
import javafx.collections.ArrayChangeListener;
import javafx.collections.ObservableArray;

import java.sql.Blob;

public class Livreitem implements ObservableArray<Livreitem> {
    private String numero ;
    private Blob imgsrc;
    private String titel;
    private String maisonidetion;
    private double price ;
    private int nbrpages;
    private boolean statue;

    public Livreitem(String numero,String titel ,String maisonidetion ,Double price, int nbrpages,Blob imgsrc ){
        this.titel=titel;
        this.maisonidetion=maisonidetion;
        this.price=price;
        this.nbrpages= nbrpages;
        this.imgsrc=imgsrc;
        this.numero=numero;
    }



    public Blob getImgsrc() {
        return this.imgsrc;
    }

    public int getNbrpages(){
        return this.nbrpages;
    }
    public String getNumero(){
        return this.numero;
    }

    public double getPrice() {
        return price;
    }

    public boolean isStatue() {
        return statue;
    }

    public String getMaisonidetion() {
        return maisonidetion;
    }

    public String getTitel() {
        return titel;
    }

    public void setMaisonidetion(String maisonidetion) {
        this.maisonidetion = maisonidetion;
    }

    public void setNbrpages(int nbrpages) {
        this.nbrpages = nbrpages;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatue(boolean statue) {
        this.statue = statue;
    }

    public void setImgsrc(Blob imgsrc) {
        this.imgsrc = imgsrc;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    @Override
    public void addListener(ArrayChangeListener<Livreitem> arrayChangeListener) {

    }

    @Override
    public void removeListener(ArrayChangeListener<Livreitem> arrayChangeListener) {

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
