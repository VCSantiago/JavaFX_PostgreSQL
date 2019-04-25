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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author vinic
 */
public class TelaRemoProController implements Initializable {
     
    @FXML
    private TableView<Produto> tabela;
    @FXML
    private TableColumn<Produto, String> nome;
    @FXML
    private TableColumn<Produto, Integer> qtd;
    @FXML
    private TableColumn<Produto, Float> valorVenda;
    @FXML
    private TableColumn<Produto, Float> valorCompra;
    @FXML
    private TableColumn<Produto, Integer> codigo;
    private List<Produto> listProduto = new ArrayList();

    private ObservableList<Produto> observableListProduto;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
              carregarTableViewClientes();
          
          } catch (SQLException ex) {
              Logger.getLogger(TelaVisuMercaController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }    

    @FXML
    private void clickR(ActionEvent event) throws SQLException {
        int a = 0;
        a = tabela.getSelectionModel().getSelectedItem().getCodigo();
      
        Conexao con = new Conexao();
        String Sql1 ="delete from qtdpro where produto ="+a;
        con.deleta(Sql1);
        Conexao con1 = new Conexao();
        String Sql ="delete from dadosproduto where id ="+a;
        con1.deleta(Sql);
        carregarTableViewClientes();
        JOptionPane.showMessageDialog(null, "", "Removido", JOptionPane.INFORMATION_MESSAGE);
       
    }
     public void carregarTableViewClientes() throws SQLException {
       Conexao con = new Conexao();
       listProduto.clear();
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
      
        Produto p1;
        String Sql ="select * from dadosproduto";
        ResultSet rs = con.busca(Sql);
  
         while(rs.next()){
            String no = rs.getString("nome");
          
            int c;
            c = rs.getInt("id");
            p1 = new Produto(no, 0, 0, 0, c);
            listProduto.add(p1);
             
         }
        observableListProduto = FXCollections.observableArrayList(listProduto);
        tabela.setItems(observableListProduto);
    }

  
    
}
