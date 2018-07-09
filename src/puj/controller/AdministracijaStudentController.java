/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import puj.model.Osoba;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import puj.Utils;
import static puj.model.Baza.DB;
import puj.model.Stranica;


import service.OsobaService;
import service.LoginService;
import service.StranicaService;

/**
 * FXML Controller class
 *
 * @author David
 */
public class AdministracijaStudentController implements Initializable {

    public Stage primaryStage;
    private Osoba odabranaOsoba;
    
    @FXML
    Label osobaLbl;
    
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
    TableView table;
    
    @FXML
    TableColumn tableId;
    
    @FXML
    TableColumn tableIme;
    
    @FXML
    TableColumn tablePrezime;
    
    @FXML
    TableColumn tableEmail;
    
    @FXML
    TableColumn tableLozinka;
    
    @FXML
    TableColumn tableIndeks;

    
    @FXML
    public void dodajOsobu (ActionEvent evt) {
        String sIme = this.ime.getText();
        String sPrezime = this.prezime.getText();
        String sEmail = this.email.getText();
        String sLozinka = this.lozinka.getText();
        String sIndeks = this.indeks.getText();
        
        if(this.odabranaOsoba != null){
            this.odabranaOsoba.setIme(sIme);
            this.odabranaOsoba.setPrezime(sPrezime);
            this.odabranaOsoba.setEmail(sEmail);
            this.odabranaOsoba.setLozinka(sLozinka);
            this.odabranaOsoba.setIndeks(sIndeks);
            
            OsobaService.osobaService.uredi(this.odabranaOsoba);
            
            this.odabranaOsoba = null;
        } else {
            Osoba k = new Osoba (0, sIme, sPrezime, sEmail, sLozinka, sIndeks);
            OsobaService.osobaService.spasi(k);
            
            System.out.println(k.getId());
            
        }
        this.ime.setText("");
        this.prezime.setText("");
        this.email.setText("");
        this.lozinka.setText("");
        this.indeks.setText("");
        
        this.popuniOsobe();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Osoba prijavljeni = LoginService.logiranaOsoba();
        
        this.popuniOsobe();
    }   
    public void idiIzbor(ActionEvent event){
                Node source = (Node) event.getSource();
                Stage stage = (Stage)source.getScene().getWindow();
                Utils.prikazi(stage, "Izbornik");
    }
    
    public void popuniOsobe () {
        ObservableList <Osoba> osobe = OsobaService.osobaService.sveIzBaze();
        
        tableId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableIme.setCellValueFactory(new PropertyValueFactory<>("ime"));
        tablePrezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        tableEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableLozinka.setCellValueFactory(new PropertyValueFactory<>("lozinka"));
        tableIndeks.setCellValueFactory(new PropertyValueFactory<>("indeks"));
        table.setItems(osobe);
        
        
    }
    
    @FXML
    public void odaberiOsobu (MouseEvent evt) {
        this.odabranaOsoba = (Osoba) this.table.getSelectionModel().getSelectedItem();
        this.email.setText(this.odabranaOsoba.getEmail());
        this.ime.setText(this.odabranaOsoba.getIme());
        this.prezime.setText(this.odabranaOsoba.getPrezime());
        this.lozinka.setText(this.odabranaOsoba.getLozinka());
        this.indeks.setText(this.odabranaOsoba.getIndeks());
        
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
    
    @FXML
    public void brisiOsobu(ActionEvent evt) {
        OsobaService.osobaService.brisi(this.odabranaOsoba);
        this.ime.setText("");
        this.prezime.setText("");
        this.email.setText("");
        this.lozinka.setText("");
        this.indeks.setText("");
        this.popuniOsobe();
    }
    
    
    
    
   
   
   

    
    
    
    
            
            
            
          
        }
    

