/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.controller;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import puj.Utils;
import puj.model.Lekcija;
import puj.model.Osoba;
import service.LekcijaService;
import service.OsobaService;

/**
 * FXML Controller class
 *
 * @author David
 */
public class LekcijeController implements Initializable {
    private Lekcija odabranaLekcija;
    /**
     * Initializes the controller class.
     */
    
    @FXML
    JFXTextField pomnaslovLekcije;
    
    @FXML
    JFXTextField pomtrajanjeLekcije;
    
    @FXML
   JFXRadioButton pomlagano;
   
    @FXML
    JFXRadioButton pomsrednje;
   
    @FXML
    JFXRadioButton pomnapredno;
    
    
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
    
    public String noviNaslov;
    public String noviTrajanje;
    public String noviTezina;
    public String noviAutor = "Admin";
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
    public void kreiranjeLekcije(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        Utils.prikazi(stage, "AdministracijaLekcija");
    }
          
     @FXML
    public void brisiLekciju(ActionEvent evt) {
        LekcijaService.lekcijaService.brisi(this.odabranaLekcija);
        
        this.popuniLekcije();
        pomnaslovLekcije.setText("");
        pomtrajanjeLekcije.setText("");
        pomlagano.setSelected(false);
        pomsrednje.setSelected(false);
        pomnapredno.setSelected(false);
    }
    
    @FXML
    public void odaberiLekciju (MouseEvent evt) {
        this.odabranaLekcija = (Lekcija) this.tablica.getSelectionModel().getSelectedItem();
        this.pomnaslovLekcije.setText(this.odabranaLekcija.getNaslov());
        this.pomtrajanjeLekcije.setText(this.odabranaLekcija.getTrajanje());
        
        noviTezina = odabranaLekcija.getTezina();
       // System.out.println(noviTezina);
        if("Lagano".equals(noviTezina)){
            pomlagano.setSelected(true);
        }
        if("Srednje".equals(noviTezina)){
            pomsrednje.setSelected(true);
        }
        if("Napredno".equals(noviTezina)){
            pomnapredno.setSelected(true);
            
        }
    }
    
    @FXML
    public void urediLekciju(ActionEvent event){

        if(this.odabranaLekcija != null){
            this.odabranaLekcija.setNaslov(pomnaslovLekcije.getText());
            this.odabranaLekcija.setTrajanje(pomtrajanjeLekcije.getText());
             if(this.pomlagano.isSelected()){
               noviTezina = "Lagano";
               this.odabranaLekcija.setTezina(noviTezina);
            }
            if(this.pomsrednje.isSelected()){
                noviTezina = "Srednje";
                this.odabranaLekcija.setTezina(noviTezina);
            }
            if(this.pomnapredno.isSelected()){
                noviTezina = "Napredno";
                this.odabranaLekcija.setTezina(noviTezina);
            }
            //this.odabranaLekcija.setAutor("Admin");
            //Lekcija k = new Lekcija(0, pomnaslovLekcije.getText(), pomtrajanjeLekcije.getText(), noviTezina, noviAutor);
            LekcijaService.lekcijaService.uredi(this.odabranaLekcija);
           
            this.popuniLekcije();
            
    }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         this.popuniLekcije();
    }    
    
}
