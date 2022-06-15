package com.example.gestionmediathequev2;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.sql.Blob;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Acteurs implements ObservableList<filmeitem> {

    private String idacteur;
    private String nomact;
    private String prenomact;
    private Blob imgact;
    public Acteurs(String idacteur,String nomact,String prenomact,Blob imgact){
        this.nomact=nomact;
        this.prenomact=prenomact;
        this.imgact=imgact;
        this.idacteur=idacteur;
    }

    public String getIdacteur() {
        return idacteur;
    }

    public void setIdacteur(String idacteur) {
        this.idacteur = idacteur;
    }

    public void setImgact(Blob imgact) {
        this.imgact = imgact;
    }

    public void setNomact(String nomact) {
        this.nomact = nomact;
    }

    public void setPrenomact(String prenomact) {
        this.prenomact = prenomact;
    }

    public Blob getImgact() {
        return imgact;
    }

    public String getNomact() {
        return nomact;
    }

    public String getPrenomact() {
        return prenomact;
    }

    @Override
    public void addListener(ListChangeListener<? super filmeitem> listChangeListener) {

    }

    @Override
    public void removeListener(ListChangeListener<? super filmeitem> listChangeListener) {

    }

    @Override
    public boolean addAll(filmeitem... filmeitems) {
        return false;
    }

    @Override
    public boolean setAll(filmeitem... filmeitems) {
        return false;
    }

    @Override
    public boolean setAll(Collection<? extends filmeitem> collection) {
        return false;
    }

    @Override
    public boolean removeAll(filmeitem... filmeitems) {
        return false;
    }

    @Override
    public boolean retainAll(filmeitem... filmeitems) {
        return false;
    }

    @Override
    public void remove(int i, int i1) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<filmeitem> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(filmeitem filmeitem) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends filmeitem> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends filmeitem> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public filmeitem get(int index) {
        return null;
    }

    @Override
    public filmeitem set(int index, filmeitem element) {
        return null;
    }

    @Override
    public void add(int index, filmeitem element) {

    }

    @Override
    public filmeitem remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<filmeitem> listIterator() {
        return null;
    }

    @Override
    public ListIterator<filmeitem> listIterator(int index) {
        return null;
    }

    @Override
    public List<filmeitem> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public void addListener(InvalidationListener invalidationListener) {

    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {

    }
}
