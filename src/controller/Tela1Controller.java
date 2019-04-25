/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import banco.Conexao;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class Tela1Controller{
    @FXML
    private TextField user;
    @FXML
    private PasswordField senha;
    
    
    /**
     *
     */
    public Tela1Controller(){
       
    }

    @FXML
    private Button botaACER;
    
   
    
  
    protected void chamaTela(ActionEvent e){
       
    }
 
    
    @FXML
    private void mouseE(MouseEvent event) {
        botaACER.setStyle("-fx-background-radius: 0 0 10 10; -fx-background-color: #c90d0d; -fx-text-fill:  #f5ec3d");
    }

    @FXML
    private void mouseS(MouseEvent event) {
        botaACER.setStyle("-fx-background-radius: 0 0 10 10; -fx-background-color: #f5ec3d;");
    }

    @FXML
    private void clik(MouseEvent event) throws IOException, SQLException {
       Conexao con = new Conexao();
       System.out.print("FExz conexão");
       boolean a = false;
       String Sql ="select * from usuarios";
       ResultSet rs = con.busca(Sql);
        String text = user.getText();
        String text1 = senha.getText();
        while(rs.next()){
            if(user.getText().equals(rs.getString("nome")) && senha.getText().equals(rs.getString("cpf"))){
                if(rs.getString("tipo")!= "cliente"){
                    a=true;
                    Main.trocaTela(2);
                    break;
                }
            } 
        }
        if(!a){
        JOptionPane.showMessageDialog(null, "Senha incorreta!", "", JOptionPane.INFORMATION_MESSAGE);
        }
    
    }

    @FXML
    private void primeiroacesso(MouseEvent event) throws IOException {
        Stage stage1 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaCadasUser.fxml"));
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.show();
    }
    
}
