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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import puj.model.Stranica;

/**
 *
 * @author David
 */
public class OsobaService implements model <Osoba>{
    
    /**
     *
     */
    public static final OsobaService osobaService = new OsobaService();
    
    @Override
    public ObservableList<Osoba> dajStranice(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Osoba spasi(Osoba osoba) {
        try {
          
            PreparedStatement upit = DB.prepare ("INSERT INTO osoba VALUES(null, ?, ?, ?, ?, ?)");
            upit.setString(1, osoba.getIme());
            upit.setString(2, osoba.getPrezime());
            upit.setString(3, osoba.getEmail());
            upit.setString(4, osoba.getLozinka());
            upit.setString(5, osoba.getIndeks());
            
            upit.executeUpdate();
            /* Dohvati id korisnika iz baze podataka */
            ResultSet rs = upit.getGeneratedKeys();
            if (rs.next()){
                /* Postavi id korisnika iz baze podataka objektu osoba */
                osoba.setId(rs.getInt(1));
            }
            return osoba;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        } 
    
    }

    @Override
    public Osoba uredi(Osoba osoba) {
        try {
            
            
            PreparedStatement upit = DB.prepare ("UPDATE osoba SET ime=?, prezime=?, email=?, lozinka=?, indeks=? WHERE id=?");
            upit.setString(1, osoba.getIme());
            upit.setString(2, osoba.getPrezime());
            upit.setString(3, osoba.getEmail());
            upit.setString(4, osoba.getLozinka());
            upit.setString(5, osoba.getIndeks());
            
            upit.setInt(6, osoba.getId());
            upit.executeUpdate();
            return osoba;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean brisi(Osoba osoba) {
        try {
            PreparedStatement upit = DB.prepare ("DELETE FROM osoba WHERE id=?");
            upit.setInt(1, osoba.getId());
            upit.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return false;
        }
    
    }

    @Override
    public ObservableList<Osoba> sveIzBaze() {
        try {
            ObservableList <Osoba> osobe = FXCollections.observableArrayList();
            ResultSet rs = DB.select("SELECT * FROM osoba");
            
            while (rs.next()){
                
                
                
                
                osobe.add(new Osoba(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                        
                ));
            }
            return osobe;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        } 
    }

    @Override
    public Osoba izBazePremaId(int id) {
        try {
            PreparedStatement upit = DB.prepare ("SELECT * FROM osoba WHERE id=?");
            upit.setInt(1, id);
            ResultSet rs = upit.executeQuery();
            if (rs.next()){
                
                
                
                return new Osoba(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                        
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
