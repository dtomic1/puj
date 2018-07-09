/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.controller;



import com.jfoenix.controls.JFXListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import puj.Utils;
import puj.model.Lekcija;
import puj.model.Osoba;
import puj.model.Stranica;
import service.LekcijaService;
import service.OsobaService;
import service.StranicaService;

/**
 * FXML Controller class
 *
 * @author David
 */


public class IzbornikController implements Initializable {

    @FXML
    TableView tablica;
    
     @FXML
    TableColumn tablicaId;
    
    @FXML
    TableColumn tablicaNaslov;
    
    @FXML
    TableColumn tablicaTrajanje;
    
    @FXML
    TableColumn tablicaTezina;
    
    @FXML
    TableColumn tablicaAutor;
    
    
    
    
    
   
     private Lekcija odabranaLekcija;       
     private int id;       
  
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.popuniLekcije();
    }    
    
    @FXML
    private void odjava(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        Utils.prikazi(stage, "LoginView");
    }
    
     public void popuniLekcije () {
        ObservableList <Lekcija> lekcije = LekcijaService.lekcijaService.sveIzBaze();
        
        tablicaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tablicaNaslov.setCellValueFactory(new PropertyValueFactory<>("naslov"));
        tablicaTrajanje.setCellValueFactory(new PropertyValueFactory<>("trajanje"));
        tablicaTezina.setCellValueFactory(new PropertyValueFactory<>("tezina"));
        tablicaAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        
        tablica.setItems(lekcije);
        
        
    }

     @FXML
    public void odaberiLekcija (MouseEvent evt) {
        this.odabranaLekcija = (Lekcija) this.tablica.getSelectionModel().getSelectedItem();
        id = this.odabranaLekcija.getId();
         System.out.println(id);
    }
    
    @FXML
    public void test(ActionEvent event){
        // ? 
        List<Stranica> stranice =   StranicaService.stranicaService.dajStranice(id);
        for (Stranica stranice1 : stranice) {
            System.out.println(stranice1.toString());
        }
        
        
        
    }
}
