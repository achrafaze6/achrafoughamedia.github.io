package com.example.gestionmediathequev2 ;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class filmacteur implements ObservableList<filmacteur> {
    private String idact;
    private String  idfilm;

    public filmacteur(String idact, String idfilm){
        this.idact=idact;
        this.idfilm=idfilm;
    }

    public String getIdact() {
        return idact;
    }

    public String getIdfilm() {
        return idfilm;
    }

    public void setIdact(String idact) {
        this.idact = idact;
    }

    public void setIdfilm(String idfilm) {
        this.idfilm = idfilm;
    }

    @Override
    public void addListener(ListChangeListener<? super filmacteur> listChangeListener) {

    }

    @Override
    public void removeListener(ListChangeListener<? super filmacteur> listChangeListener) {

    }

    @Override
    public boolean addAll(filmacteur... filmacteurs) {
        return false;
    }

    @Override
    public boolean setAll(filmacteur... filmacteurs) {
        return false;
    }

    @Override
    public boolean setAll(Collection<? extends filmacteur> collection) {
        return false;
    }

    @Override
    public boolean removeAll(filmacteur... filmacteurs) {
        return false;
    }

    @Override
    public boolean retainAll(filmacteur... filmacteurs) {
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
    public Iterator<filmacteur> iterator() {
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
    public boolean add(filmacteur filmacteur) {
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
    public boolean addAll(Collection<? extends filmacteur> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends filmacteur> c) {
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
    public filmacteur get(int index) {
        return null;
    }

    @Override
    public filmacteur set(int index, filmacteur element) {
        return null;
    }

    @Override
    public void add(int index, filmacteur element) {

    }

    @Override
    public filmacteur remove(int index) {
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
    public ListIterator<filmacteur> listIterator() {
        return null;
    }

    @Override
    public ListIterator<filmacteur> listIterator(int index) {
        return null;
    }

    @Override
    public List<filmacteur> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public void addListener(InvalidationListener invalidationListener) {

    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {

    }
}
