/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuis;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ChaVaZaSRL
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXRadioButton rdLaki;
    @FXML
    private ToggleGroup gender;
    @FXML
    private JFXRadioButton rdPerempuan;
    @FXML
    private JFXButton Proses;
    @FXML
    private JFXButton Reset;
    @FXML
    private JFXTextField Nama;
    @FXML
    private JFXTextField Tinggi;
    @FXML
    private JFXTextField Berat;
    @FXML
    private TextField Ideal;
    @FXML
    private TextArea hasil;
    @FXML
    private TextArea saran;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CProses(ActionEvent event) {
        if(!(rdLaki.isSelected() || rdPerempuan.isSelected())){
            JOptionPane.showMessageDialog(null, "Pilih Jenis Kelamin Dahulu");
        }
        
        int ideal = 0;
        String Saran = "";
        String analisa = "";
        String nama = Nama.getText();
        int tinggi = Integer.parseInt(Tinggi.getText());
        int berat = Integer.parseInt(Berat.getText());
        
        
        if(rdLaki.isSelected()){
            ideal = tinggi - 105;
            if(ideal == berat){
                analisa = "Ideal";
                Saran = "Saran : \n1. ok sipp"; 
            }else if(ideal > berat){
                analisa = "UnderWeight";
                Saran = "Saran : \n1. Makan yang banyak \n2. Minum Susu \n3. Habis makan terus tidur"; 
            }else if(ideal < berat){
                analisa = "OverWeight";
                Saran = "Saran : \n1. Makan yang sedikit \n2. jangan Minum Susu \n3. Diet";
            }
        }if(rdPerempuan.isSelected()){
            ideal = tinggi - 110;
            if(ideal == berat){
                analisa = "Ideal";
                Saran = "Saran : \n1. ok sipp";
            }else if(ideal > berat){
                analisa = "UnderWeight";
                Saran = "Saran : \n1. Makan yang banyak \n2. Minum Susu \n3. Habis makan terus tidur";
            }else if(ideal < berat){
                analisa = "OverWeight";
                Saran = "Saran : \n1. Makan yang sedikit \n2. jangan Minum Susu \n3. Diet";
            }
        }
        if((rdLaki.isSelected() || rdPerempuan.isSelected())){
            Ideal.setText(""+ideal);
            hasil.setText("Nama : "+nama+"\nBerat Badan : "+berat+"\nTinggi Badan : "+tinggi+"\nAnalisa : "+analisa);
            saran.setText(Saran);
        }
        
    }

    @FXML
    private void CReset(ActionEvent event) {
        Nama.setText("");
        Tinggi.setText("");
        Berat.setText("");
        rdLaki.setSelected(false);
        rdPerempuan.setSelected(false);
        Ideal.setText("");
        hasil.setText("");
        saran.setText("");
    }
    
}
