/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import banco.Conexao;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author vinic
 */
public class TelaRemoverUserController implements Initializable {
   
    
     
    @FXML
    private TableView<Usuario> tabela;
    @FXML
    private TableColumn<Usuario, String> nome;
    @FXML
    private TableColumn<Usuario, Integer> codigo;
    @FXML
    private TableColumn<Usuario, String> cpf;
    @FXML
    private TableColumn<Usuario, String> tipo;
    private final List<Usuario> listUsero = new ArrayList();
    private ObservableList<Usuario> observableListUser;
    @FXML
    private Button remove;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            carregarTableViewUser();
        } catch (SQLException ex) {
            Logger.getLogger(TelaRemoverUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
     public void carregarTableViewUser() throws SQLException {
        Conexao con2 = new Conexao();
        listUsero.clear();
        nome.setCellValueFactory(new PropertyValueFactory<>("nome")); 
        cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        codigo.setCellValueFactory(new PropertyValueFactory<>("id"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
      
        Usuario p1;
        String Sql ="select * from usuarios";
        ResultSet rs = con2.busca(Sql);
        
         while(rs.next()){
            String no = rs.getString("nome");
            String vv=rs.getString("cpf");
            int c = rs.getInt("id");
            String ti=rs.getString("tipo");
         
            p1 = new Usuario(no, vv, c, ti);
           
            listUsero.add(p1);
         }  
    
         
        observableListUser = FXCollections.observableArrayList(listUsero);
                
        tabela.setItems(observableListUser);
    }

    @FXML
    private void remover(MouseEvent event) throws SQLException {
        int a = 0;
        a = tabela.getSelectionModel().getSelectedItem().getId();
        Conexao con = new Conexao();
        String Sql ="delete from usuarios where id ="+a;
        con.deleta(Sql);
        carregarTableViewUser();
        String erro;
        JOptionPane.showMessageDialog(null, "", "Removido", JOptionPane.ERROR_MESSAGE);
    }
    
}
