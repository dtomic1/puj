/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import puj.model.Baza;
import puj.model.Osoba;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author David
 */
public class LoginService {
    private static OsobaService osobaService = new OsobaService();
    public static Osoba prijavljeni = null;
    
    public static boolean login (String email, String lozinka) {
        try {
            PreparedStatement upit = Baza.DB.prepare(
                    "SELECT * FROM osoba WHERE email=? AND lozinka=?");
            upit.setString(1, email);
            upit.setString(2, lozinka);
            ResultSet rs = upit.executeQuery();
            if (rs.next()) {
                LoginService.prijavljeni = osobaService.izBazePremaId(rs.getInt(1));
                return true;
                
            } else {
                return false;
            }
        } catch (SQLException ex) {
           System.out.println("Greska prilikom prijave: " + ex.getMessage());
           return false;
        }
    }
    
    
    public static Osoba logiranaOsoba () {
        return LoginService.prijavljeni;
    }
    
    
}
