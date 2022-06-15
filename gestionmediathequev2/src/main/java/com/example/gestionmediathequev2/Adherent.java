package com.example.gestionmediathequev2;

public class Adherent {

    private String idadr;
    private String nomadr;
    private String prenomadr;
    private String adressadr;
    private String emaiadr;
    private String password;

    public Adherent(String idadr,String nomadr ,String prenomadr,String adressadr,String emaiadr,String password){
        this.adressadr=adressadr;
        this.emaiadr=emaiadr;
        this.idadr=idadr;
        this.nomadr=nomadr;
        this.prenomadr=prenomadr;
        this.password=password;
    }

    public String getAdressadr() {
        return adressadr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmaiadr() {
        return emaiadr;
    }

    public String getIdadr() {
        return idadr;
    }

    public String getNomadr() {
        return nomadr;
    }

    public String getPrenomadr() {
        return prenomadr;
    }

    public void setAdressadr(String adressadr) {
        this.adressadr = adressadr;
    }

    public void setEmaiadr(String emaiadr) {
        this.emaiadr = emaiadr;
    }

    public void setIdadr(String idadr) {
        this.idadr = idadr;
    }

    public void setNomadr(String nomadr) {
        this.nomadr = nomadr;
    }

    public void setPrenomadr(String prenomadr) {
        this.prenomadr = prenomadr;
    }
}
