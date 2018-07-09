/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import puj.Utils;
import puj.model.Osoba;
import service.LoginService;
import service.OsobaService;

/**
 * FXML Controller class
 *
 * @author David
 */
public class RegistracijaController implements Initializable {

    /**
     * Initializes the controller class.
     */

   
    
    @FXML
    JFXTextField ime;
    
    @FXML
    JFXTextField prezime;
    
    @FXML
    JFXTextField email;
    
    @FXML
    JFXPasswordField lozinka;
    
    @FXML
    JFXTextField indeks;
    
    @FXML
    JFXButton nazad;
    
    
    @FXML
    public void dodajOsobu (ActionEvent evt) {
        String sIme = this.ime.getText();
        String sPrezime = this.prezime.getText();
        String sEmail = this.email.getText();
        String sLozinka = this.lozinka.getText();
        String sIndeks = this.indeks.getText();
        
        Osoba k = new Osoba (0, sIme, sPrezime, sEmail, sLozinka, sIndeks);
        OsobaService.osobaService.spasi(k);
    }
    
  
    @FXML
    private void idiNazad(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        Utils.prikazi(stage, "LoginView");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Osoba prijavljeni = LoginService.logiranaOsoba();
        
    }    
    
}
