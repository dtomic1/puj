/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import static puj.model.Baza.DB;
import puj.model.Osoba;
import interfaces.model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import puj.model.Lekcija;

/**
 *
 * @author Admin
 */
public class LekcijaService implements model <Lekcija>{
    
    /**
     *
     */
    public static final LekcijaService lekcijaService = new LekcijaService();

    @Override
    public Lekcija spasi(Lekcija lekcija) {
        try {
          
            PreparedStatement upit = DB.prepare ("INSERT INTO lekcija(id, naslov, trajanje, tezina, autor) VALUES(null, ?, ?, ?, ?)");
            upit.setString(1, lekcija.getNaslov());
            upit.setString(2, lekcija.getTrajanje());
            upit.setString(3, lekcija.getTezina());
            upit.setString(4, lekcija.getAutor());
            
            
            upit.executeUpdate();
            /* Dohvati id korisnika iz baze podataka */
            ResultSet rs = upit.getGeneratedKeys();
            if (rs.next()){
                /* Postavi id korisnika iz baze podataka objektu osoba */
                lekcija.setId(rs.getInt(1));
            }
            return lekcija;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        } 
    
    }

    @Override
    public Lekcija uredi(Lekcija lekcija) {
        try {
             
            PreparedStatement upit = DB.prepare ("UPDATE lekcija SET naslov=?, trajanje=?, tezina=?, autor=? WHERE id=?");
            upit.setString(1, lekcija.getNaslov());
            upit.setString(2, lekcija.getTrajanje());
            upit.setString(3, lekcija.getTezina());
            upit.setString(4, lekcija.getAutor());
            
            upit.setInt(5, lekcija.getId());
            upit.executeUpdate();
            return lekcija;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean brisi(Lekcija lekcija) {
        
        try {
            
            PreparedStatement izgasi = DB.prepare("SET FOREIGN_KEY_CHECKS=0");
            izgasi.executeQuery();
            
            try {
                PreparedStatement upit = DB.prepare ("DELETE FROM lekcija WHERE id=? ");
                upit.setInt(1, lekcija.getId());
                upit.executeUpdate();
                
                PreparedStatement test = DB.prepare("DELETE FROM stranica WHERE fk_lekcija = ? ");
                test.setInt(1, lekcija.getId());
                test.executeUpdate();
                
                PreparedStatement upali = DB.prepare("SET FOREIGN_KEY_CHEKS=1");
                upali.executeQuery();
                return true;
            } catch (SQLException ex) {
                //System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LekcijaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    
    }

    @Override
    public ObservableList<Lekcija> sveIzBaze() {
        try {
            ObservableList <Lekcija> lekcije = FXCollections.observableArrayList();
            ResultSet rs = DB.select("SELECT * FROM lekcija");
            
            while (rs.next()){
                                          
                lekcije.add(new Lekcija(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                                              
                ));
            }
            return lekcije;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        } 
    }
    @Override
    public ObservableList<Lekcija> dajStranice(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public Lekcija izBazePremaId(int id) {
        try {
            PreparedStatement upit = DB.prepare ("SELECT * FROM lekcija WHERE id=?");
            upit.setInt(1, id);
            ResultSet rs = upit.executeQuery();
            if (rs.next()){
          
                return new Lekcija(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)

                );
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        } 
        
        
    }
    
}
