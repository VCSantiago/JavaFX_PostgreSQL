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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author vinic
 */
public class TelaVenderController implements Initializable{
    @FXML
    private TableView<Produto> tabelaProdutos;
    @FXML
    private TableColumn<Produto, String> viewNome;
    @FXML
    private TableColumn<Produto, Float> viewValor;
    @FXML
    private TableColumn<Produto, Float> viewCode;
    private final List<Produto> listProduto = new ArrayList();

    private ObservableList<Produto> observableListProduto;
    
    
    
    
    
    
    @FXML
    private TableView<Usuario> clientes;
    @FXML
    private TableColumn<Usuario, String> nomeC;
    @FXML
    private TableColumn<Usuario, Integer> codiC;
    @FXML
    private TableColumn<Usuario, String> cpfC;
     private final List<Usuario> listUsero = new ArrayList();

    private ObservableList<Usuario> observableListUser;
    @FXML
    private Button vender;
  
   @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
            carregarTableViewClientes();
             carregarTableViewUser();
        } catch (SQLException ex) {
            Logger.getLogger(TelaVenderController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    } 
    public void carregarTableViewClientes() throws SQLException {
        Conexao con = new Conexao();
        listProduto.clear();
        viewNome.setCellValueFactory(new PropertyValueFactory<>("nome")); 
        viewValor.setCellValueFactory(new PropertyValueFactory<>("valorVenda"));
        viewCode.setCellValueFactory(new PropertyValueFactory<>("codigo"));
      
        Produto p1;
        String Sql ="select * from qtdpro inner join dadosproduto on qtdpro.produto = dadosproduto.id";
        ResultSet rs = con.busca(Sql);
        int a = 0;
         while(rs.next()){
            String no = rs.getString("nome");
            
         
            float vv=rs.getFloat("valorvenda");
        
            int c;
            c = rs.getInt("id");
            p1 = new Produto(no, 0, 0, vv, c);
            listProduto.add(p1);
             
         }
        observableListProduto = FXCollections.observableArrayList(listProduto);
        tabelaProdutos.setItems(observableListProduto);
    }
     public void carregarTableViewUser() throws SQLException {
        Conexao con2 = new Conexao();
        listUsero.clear();
        nomeC.setCellValueFactory(new PropertyValueFactory<>("nome")); 
        cpfC.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        codiC.setCellValueFactory(new PropertyValueFactory<>("id"));
      
        Usuario p1;
        String Sql ="select * from usuarios";
        ResultSet rs = con2.busca(Sql);
        
         while(rs.next()){
            String no = rs.getString("nome");
            String vv=rs.getString("cpf");
        
            int c;
            c = rs.getInt("id");
            p1 = new Usuario(no, vv, c,"0");
            System.out.println(rs.getString("tipo"));
            if(!rs.getString("tipo").equals("funcionario")){
                listUsero.add(p1);
            }
                
            
             
         }
        observableListUser = FXCollections.observableArrayList(listUsero);
        clientes.setItems(observableListUser);
    }

    @FXML
    private void venderClik(MouseEvent event) throws SQLException {
        Conexao com = new Conexao();
        int codigo = tabelaProdutos.getSelectionModel().getSelectedItem().getCodigo();
        Float valor = tabelaProdutos.getSelectionModel().getSelectedItem().getValorVenda();
        int codigoU = clientes.getSelectionModel().getSelectedItem().getId();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        String Sql = "INSERT into vendas (cdproduto, cdcliente, valorvenda) VALUES(\'"+codigo+"\',\'"+codigoU+"\',\'"+valor+"\')";
        com.insere(Sql);
        Conexao cn = new Conexao();
        
        Sql =" SELECT * FROM qtdpro WHERE qtdpro.produto ="+codigo;
        ResultSet rs = cn.busca(Sql);
        int a = 0;
         while(rs.next()){
             a= rs.getInt("qtd");
         }
         a--;
        Sql ="UPDATE qtdpro SET qtd = \'"+a+"\' WHERE produto = \'"+codigo+"\'";
        Conexao co1 = new Conexao();
        co1.insere(Sql);
        JOptionPane.showMessageDialog(null, "", "Vendido", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
