/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import banco.AcaoNoBanco;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author vinic
 */
public class TelaCadasUserController implements Initializable {
    @FXML
    private TextField nome;
    @FXML
    private TextField cpf;
    @FXML
    private CheckBox funcionario;
    @FXML
    private CheckBox client;
    private Stage st;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
    @FXML
    private void salvar(MouseEvent event) throws SQLException, Throwable {
        String no = nome.getText();
        String cp = cpf.getText();
        String tipo = null;
        if(funcionario.isSelected()){
            tipo = "funcionario";
        }
        if(client.isSelected()){
             tipo = "cliente";
        }
        JOptionPane.showMessageDialog(null, "", "salvo", JOptionPane.INFORMATION_MESSAGE);
        AcaoNoBanco.inserirUser(no, cp, tipo);
     
        
       
    }
    
}
