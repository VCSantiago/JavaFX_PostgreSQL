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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author vinic
 */
public class TelaVisuMercaController   implements Initializable{

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
    public void initialize(URL url, ResourceBundle rb){
          try {
              carregarTableViewClientes();
              
        tabela.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewClientes(newValue));
          } catch (SQLException ex) {
              Logger.getLogger(TelaVisuMercaController.class.getName()).log(Level.SEVERE, null, ex);
          }
    } 
      public void carregarTableViewClientes() throws SQLException {
        Conexao con = new Conexao();
        listProduto.clear();
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        qtd.setCellValueFactory(new PropertyValueFactory<>("qtd"));
        valorVenda.setCellValueFactory(new PropertyValueFactory<>("valorVenda"));
        valorCompra.setCellValueFactory(new PropertyValueFactory<>("valorCompra"));
        codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
      
        Produto p1;
        String Sql ="select * from qtdpro inner join dadosproduto on qtdpro.produto = dadosproduto.id";
        ResultSet rs = con.busca(Sql);
        int a = 0;
         while(rs.next()){
            String no = rs.getString("nome");
            
            int  qtid = rs.getInt("qtd");
            System.out.println(qtid);
            float vc = rs.getFloat("valorcompra");
         
            float vv=rs.getFloat("valorvenda");
        
            int c;
            c = rs.getInt("id");
            p1 = new Produto(no, qtid, vc, vv, c);
            listProduto.add(p1);
             
         }
        observableListProduto = FXCollections.observableArrayList(listProduto);
        tabela.setItems(observableListProduto);
    }

    public void selecionarItemTableViewClientes(Produto cliente) {
        if (cliente != null) {
            System.out.println("Cliente selecionado no TableView: " + cliente.getNome());
        }
    }
}
