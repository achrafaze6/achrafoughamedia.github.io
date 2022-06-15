package com.example.gestionmediathequev2;

import java.sql.Blob;

public class Audioitem {
    private String idaudio;
    private String nomaudio;
    private String nomalbom;
    private String nominterpreteur;
    private String nomeediteur;
    private Blob audioim;

    public Audioitem(String idaudio,String nomaudio ,String nomalbom,String nomeediteur,String nominterpreteur ,Blob audioim){
        this.audioim=audioim;
        this.idaudio=idaudio;
        this.nomalbom=nomalbom;
        this.nomeediteur=nomeediteur;
        this.nominterpreteur=nominterpreteur;
        this.nomaudio=nomaudio;
    }
    public Blob getAudioim() {
        return audioim;
    }
    public String getIdaudio() {
        return idaudio;
    }

    public String getNomalbom() {
        return nomalbom;
    }

    public String getNomaudio() {
        return nomaudio;
    }

    public String getNomeediteur() {
        return nomeediteur;
    }

    public String getNominterpreteur() {
        return nominterpreteur;
    }

    public void setAudioim(Blob audioim) {
        this.audioim = audioim;
    }

    public void setIdaudio(String idaudio) {
        this.idaudio = idaudio;
    }

    public void setNomalbom(String nomalbom) {
        this.nomalbom = nomalbom;
    }

    public void setNomaudio(String nomaudio) {
        this.nomaudio = nomaudio;
    }

    public void setNomeediteur(String nomeediteur) {
        this.nomeediteur = nomeediteur;
    }

    public void setNominterpreteur(String nominterpreteur) {
        this.nominterpreteur = nominterpreteur;
    }
}
