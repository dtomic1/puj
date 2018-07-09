/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.controller;

import com.jfoenix.controls.JFXButton;
import puj.model.Osoba;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import puj.Utils;
import service.LoginService;

/**
 * FXML Controller class
 *
 * @author David
 */
public class AdministracijaController implements Initializable {

    @FXML
    JFXButton btnLekcija;
    
    @FXML
    JFXButton btnStudent;
    
    
    public void idiStudent(ActionEvent event){
                Node source = (Node) event.getSource();
                Stage stage = (Stage)source.getScene().getWindow();
                Utils.prikazi(stage, "AdministracijaStudent");
    }
    
    public void idiLekcija(ActionEvent event){
                Node source = (Node) event.getSource();
                Stage stage = (Stage)source.getScene().getWindow();
                Utils.prikazi(stage, "Lekcije");
    }
    
    @FXML
    private void idiKuca(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        Utils.prikazi(stage, "Izbornik");
    }
    
    @FXML
    private void odjava(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        Utils.prikazi(stage, "LoginView");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Osoba prijavljeni = LoginService.logiranaOsoba();
 
    }   
    
    
    
    
    
}
