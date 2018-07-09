/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.model;

/**
 *
 * @author David
 */
public class Lekcija {
    private int id;
    private String naslov;
    private String trajanje;
    private String tezina;
    private String ocjena;
    private String autor;

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

    public String getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(String trajanje) {
        this.trajanje = trajanje;
    }

    public String getTezina() {
        return tezina;
    }

    public void setTezina(String tezina) {
        this.tezina = tezina;
    }

    public String getOcjena() {
        return ocjena;
    }

    public void setOcjena(String ocjena) {
        this.ocjena = ocjena;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Lekcija(int id, String naslov, String trajanje, String tezina, String ocjena, String autor) {
        this.id = id;
        this.naslov = naslov;
        this.trajanje = trajanje;
        this.tezina = tezina;
        this.ocjena = ocjena;
        this.autor = autor;
    }
    
    public Lekcija(int id, String naslov, String trajanje, String tezina,  String autor) {
        this.id = id;
        this.naslov = naslov;
        this.trajanje = trajanje;
        this.tezina = tezina;
        this.autor = autor;
    }
    
     public Lekcija(int id, String naslov, String trajanje, String tezina) {
        this.id = id;
        this.naslov = naslov;
        this.trajanje = trajanje;
        this.tezina = tezina;
        
    }
     
      
    
}
