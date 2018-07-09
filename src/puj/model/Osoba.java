/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.model;

import javafx.scene.image.Image;

/**
 *
 * @author David
 */
public class Osoba {
    private int id;
    private String ime;
    private String prezime;
    private String email;
    private String lozinka;
    private String indeks;
    

    public Osoba(int id, String ime, String prezime, String email, String lozinka, String indeks) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.lozinka = lozinka;
        this.indeks = indeks;
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
    
    public String getIndeks(){
        return indeks;
    }
    
    public void setIndeks(String indeks){
        this.indeks = indeks;
    }
    
}
