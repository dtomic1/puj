/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.controller;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import puj.Utils;
import puj.model.Lekcija;
import puj.model.Osoba;
import puj.model.Stranica;

import service.LekcijaService;
import service.LoginService;
import service.OsobaService;
import service.StranicaService;


/**
 * FXML Controller class
 *
 * @author David
 */
public class AdministracijaLekcijaController implements Initializable {
    private Lekcija odabranaLekcija;
    
    
   @FXML
   JFXTextField naslovLekcije;
    
   @FXML
   JFXTextField trajanje;
    
   @FXML
   JFXRadioButton lagano;
   
   @FXML
   JFXRadioButton srednje;
   
   @FXML
   JFXRadioButton napredno;
    
   @FXML
   Label labela;
   
   @FXML
   JFXTextField naslov;
   
   @FXML
   JFXTextField podNaslov;
   
   @FXML
   TextArea sadrzaj;
   
   @FXML
   Label labelUspjeh;
   
   
    
    
    public static int idLekcije;
    public int brojLekcije = 1;
    
    @FXML
    public void dodajLekciju (ActionEvent event) throws IOException {
         String sNaslov = this.naslovLekcije.getText();
         String sTrajanje = this.trajanje.getText();
         String sTezina = "";
         String autor = "Admin";
         if(lagano.isSelected()){
             sTezina = "Lagano";
         }
         if(srednje.isSelected()){
             sTezina = "Srednje";
         }
         if(napredno.isSelected()){
             sTezina = "Napredno";
         }
         
         
            Lekcija k = new Lekcija (0, sNaslov, sTrajanje, sTezina,autor);
            LekcijaService.lekcijaService.spasi(k);
            idLekcije = k.getId();
            
            String a = Integer.toString(idLekcije);
            
            System.out.println(k.getId());
             
            Node source = (Node) event.getSource();
            Stage stage = (Stage)source.getScene().getWindow();
            Utils.prikazi(stage, "Stranica");
            
            
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
    public void dodajStranicu (ActionEvent event) throws IOException {
         String sNaslov = this.naslov.getText();
         String sPodnaslov = this.podNaslov.getText();
         String sSadrzaj = this.sadrzaj.getText();
         int sBroj = brojLekcije;
          
         
            Stranica k = new Stranica (0, sNaslov, sPodnaslov, sSadrzaj, sBroj, idLekcije);
            
            StranicaService.stranicaService.spasi(k);
            
            labelUspjeh.setText("Stranica broj " + sBroj + " uspješno dodana");
            
            brojLekcije++;
            
            naslov.setText("");
            podNaslov.setText("");
            sadrzaj.setText("");
         
    }
    
   
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }   
   
    
}  
    
    
    
    
    
    
    
    
    
    
   
