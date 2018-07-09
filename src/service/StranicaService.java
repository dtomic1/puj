/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import puj.controller.AdministracijaLekcijaController;
import puj.model.Baza;
import static puj.model.Baza.DB;
import puj.model.Lekcija;
import puj.model.Osoba;
import puj.model.Stranica;

/**
 *
 * @author David
 */
public class StranicaService implements model <Stranica> {
     public static final StranicaService stranicaService = new StranicaService();
     public int prvi;
     public String drugi;
     public int treci;
     @Override
     public Stranica spasi(Stranica stranica) {
        try {
          
            PreparedStatement upit = DB.prepare ("INSERT INTO stranica(id, naslov, podnaslov, sadrzaj, broj, fk_lekcija) VALUES(null, ?, ?, ?, ?, ?)");
            upit.setString(1, stranica.getNaslov());
            upit.setString(2, stranica.getPodNaslov());
            upit.setString(3, stranica.getSadrzaj());
            upit.setInt(4, stranica.getBroj());
            upit.setInt(5, stranica.getLekcija());
            
            upit.executeUpdate();
            /* Dohvati id korisnika iz baze podataka */
            ResultSet rs = upit.getGeneratedKeys();
            if (rs.next()){
                /* Postavi id korisnika iz baze podataka objektu osoba */
                stranica.setId(rs.getInt(1));
            }
            return stranica;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        } 
    }

    @Override
    public Stranica uredi(Stranica object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean brisi(Stranica object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public ObservableList<Stranica> sveIzBaze() {
        try {
            ObservableList <Stranica> stranice = FXCollections.observableArrayList();
            ResultSet rs = DB.select("SELECT * FROM stranica");
            
            while (rs.next()){
                                          
                stranice.add(new Stranica(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6)
                                           
                ));
            }
            return stranice;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        } 
    }
    
    @Override
    public Stranica izBazePremaId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    @Override
    public ArrayList<Stranica> dajStranice(int id) {
       try {
           ArrayList <Stranica> stranice = new ArrayList<>();
            PreparedStatement upit = DB.prepare("SELECT lekcija.id, stranica.id, stranica.naslov, stranica.podnaslov, stranica.sadrzaj, stranica.broj, stranica.fk_lekcija FROM lekcija, stranica WHERE stranica.fk_lekcija=lekcija.id AND stranica.fk_lekcija = ?");
            upit.setInt(1, id);
            
            upit.executeQuery();
            /* Dohvati id korisnika iz baze podataka */
            ResultSet rs = upit.executeQuery();
            while(rs.next()){
                
                
                
                stranice.add( new Stranica(
                        
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7)
                        
                ));
                
                
            } return stranice;
            
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        } 
    }
    
    
}
