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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author vinic
 */
public class TelaVerVendasController implements Initializable {
 
   
   
    @FXML
    private TableView<Vendas> tabela;
    @FXML
    private TableColumn<Vendas, Integer> produto;
    @FXML
    private TableColumn<Vendas, Integer> cliente;
    private List<Vendas> listProduto = new ArrayList();
    private ObservableList<Vendas> observableListProduto;
    @FXML
    private TableColumn<Vendas, Float> valo;
    @FXML
    private Button limpar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            carregarTableViewClientes();
        } catch (SQLException ex) {
            Logger.getLogger(TelaVerVendasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
     public void carregarTableViewClientes() throws SQLException {
        Conexao con = new Conexao();
        listProduto.clear();
        produto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        cliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
       
        cliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        valo.setCellValueFactory(new PropertyValueFactory<>("valor"));
      
        Vendas p1;
          
        String Sql ="select * from vendas";
        ResultSet rs = con.busca(Sql);
      
         while(rs.next()){
             
           int no = rs.getInt("cdproduto");
            
           int  qtid = rs.getInt("cdcliente");

           float vv=rs.getFloat("valorvenda");
            p1 = new Vendas(no, qtid, vv);
            listProduto.add(p1);
             
         }
        observableListProduto = FXCollections.observableArrayList(listProduto);
        tabela.setItems(observableListProduto);
    }

    @FXML
    private void limpar(MouseEvent event) throws SQLException {
        Conexao con = new Conexao();
        String Sql1 ="delete from vendas";
        con.deleta(Sql1);
        carregarTableViewClientes();
    }

}
