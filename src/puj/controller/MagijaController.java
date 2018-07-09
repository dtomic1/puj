/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import puj.Utils;
import puj.model.Stranica;
import service.StranicaService;

/**
 * FXML Controller class
 *
 * @author David
 */
public class MagijaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML 
    Label strNaslov;
    
    @FXML 
    Label strPodnaslov;
    
    @FXML 
    Label strSadrzaj;

    @FXML 
    Label strBroj;

    @FXML 
    JFXButton prethodna;
    
    @FXML 
    JFXButton sljedeca;
    
    private  int brojac = 0;
    
    
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
    
    public void prethodna(ActionEvent event){
         List<Stranica> stranice =   StranicaService.stranicaService.dajStranice(IzbornikController.id);
        for (Stranica stranice1 : stranice) {
            
            if(brojac <= stranice.size()){
                strNaslov.setText(stranice.get(brojac).getNaslov());
                strPodnaslov.setText(stranice.get(brojac).getPodNaslov());
                strSadrzaj.setText(stranice.get(brojac).getSadrzaj());
            
                //String pom = String.valueOf(stranice.get(brojac).getBroj());
                double x = (stranice.get(brojac).getBroj());
                double y = (double)stranice.size();
                double c= (x/y)*100;
                String pom = String.valueOf(c);
                
                strBroj.setText(pom+"%");
                
                
                }
            }
            brojac--;
            if(brojac <=-1){
                brojac++;
         }
            
            
    
    }
    
    public void sljedeca(ActionEvent event){
        List<Stranica> stranice =   StranicaService.stranicaService.dajStranice(IzbornikController.id);
        for (Stranica stranice1 : stranice) {
            
            if(brojac <= stranice.size()){
                strNaslov.setText(stranice.get(brojac).getNaslov());
                strPodnaslov.setText(stranice.get(brojac).getPodNaslov());
                strSadrzaj.setText(stranice.get(brojac).getSadrzaj());
            
                //String pom = String.valueOf(stranice.get(brojac).getBroj());
                double x = (stranice.get(brojac).getBroj());
                double y = (double)stranice.size();
                double c= (x/y)*100;
                String pom = String.valueOf(c);
                strBroj.setText(pom+"%");
                     
                if(c>=100){
                    sljedeca.setText("Kraj");
                    
                }
                 }
            }
        
        brojac++;
        if(brojac >= stranice.size()){
             brojac--;
         }
                
    }
    
       
    public void popuni(){
        List<Stranica> stranice =   StranicaService.stranicaService.dajStranice(IzbornikController.id);
        for (Stranica stranice1 : stranice) {
            
            strNaslov.setText(stranice.get(0).getNaslov());
            strPodnaslov.setText(stranice.get(0).getPodNaslov());
            strSadrzaj.setText(stranice.get(0).getSadrzaj());
            
            //String pom = String.valueOf(stranice.get(0).getBroj());
            //strBroj.setText(pom); 
            double x = (stranice.get(0).getBroj());
            double y = (double)stranice.size();
            double c= (x/y)*100;
            String pom = String.valueOf(c);
            strBroj.setText(pom+"%");
            
    }
        brojac++;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            popuni();
        }
    }    
    

