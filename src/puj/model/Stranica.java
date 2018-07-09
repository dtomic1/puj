/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.model;

import puj.controller.AdministracijaLekcijaController;

/**
 *
 * @author David
 */
public class Stranica {
        private int id;
        private String naslov;
        private String podNaslov;
        private String sadrzaj;
        private int broj;
        private int lekcija;
        
        private int prvi;
        private String drugi;
        private int treci;
        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getPodNaslov() {
        return podNaslov;
    }

    public void setPodNaslov(String podNaslov) {
        this.podNaslov = podNaslov;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public int getLekcija() {
        return AdministracijaLekcijaController.idLekcije;
    }

    public void setLekcija(int lekcija) {
        this.lekcija = lekcija;
    }

    public Stranica(int id, String naslov, String podNaslov, String sadrzaj, int broj, int lekcija) {
        this.id = id;
        this.naslov = naslov;
        this.podNaslov = podNaslov;
        this.sadrzaj = sadrzaj;
        this.broj = broj;
        this.lekcija = lekcija;
    }
    
    public Stranica(int prvi, String drugi, int treci){
        this.prvi = prvi;
        this.drugi = drugi;
        this.treci = treci; 
    }

    @Override
    public String toString() {
        return "Stranica{" + "id=" + id + ", naslov=" + naslov + ", podNaslov=" + podNaslov + ", sadrzaj=" + sadrzaj + ", broj=" + broj + ", lekcija=" + lekcija + ", prvi=" + prvi + ", drugi=" + drugi + ", treci=" + treci + '}';
    }
    
    
}
