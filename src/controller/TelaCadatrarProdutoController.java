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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author vinic
 */
public class TelaCadatrarProdutoController  {
    @FXML
    private Button Salvar;
    @FXML
    private TextField nomePro;
    @FXML
    private TextField qtdPro;
    @FXML
    private TextField valorPro;
    @FXML
    private TextField vendaPro;

    @FXML
    private void noProdu(MouseEvent event) throws SQLException {
       String nome = nomePro.getText();
       String a = qtdPro.getText();
       String b = valorPro.getText();
       String c = vendaPro.getText();
       int qtd, vV, vC;
       qtd = Integer.parseInt(a);
       vV = Integer.parseInt(b);
       vC = Integer.parseInt(c);
       AcaoNoBanco.inserir(nome, qtd, vC, vV);
       JOptionPane.showMessageDialog(null, "", "salvo", JOptionPane.INFORMATION_MESSAGE);
     
    }
}
