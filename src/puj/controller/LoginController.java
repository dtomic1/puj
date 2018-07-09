/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import service.LoginService;
import puj.Utils;
import javafx.stage.Stage;
import puj.model.Lekcija;
import service.LekcijaService;
/**
 *
 * @author David
 */
public class LoginController implements Initializable {
    private Lekcija odabranaLekcija;
    @FXML
    private JFXTextField korisnickoImeTxt;
    
    @FXML
    private JFXPasswordField lozinkaTxt;
    
    @FXML
    private Label greskaLbl;
    
    @FXML
    private ImageView slika;
    
    @FXML
    private void prijava (ActionEvent event) {
        if (korisnickoImeTxt.getText().equals("") || lozinkaTxt.getText().equals("")) {
            greskaLbl.setText("Niste unijeli sve podatke.");
        } else {
            greskaLbl.setText("");
            String email = korisnickoImeTxt.getText();
            String password = lozinkaTxt.getText();
            if (LoginService.login(email, password)) {
                Node source = (Node) event.getSource();
                Stage stage = (Stage)source.getScene().getWindow();
                Utils.prikazi(stage, "Izbornik");
            } else {
                greskaLbl.setText("Netočan email ili lozinka");
            }
        }
    }
    
    @FXML
    private void registracija(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        Utils.prikazi(stage, "Registracija");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
         
    }    
    
}
