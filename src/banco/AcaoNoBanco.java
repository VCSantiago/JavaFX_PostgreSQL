/*
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vinic
 */
public class AcaoNoBanco {
    
  
    public static void inserir(String nome, int qtd, float valorvenda, float valorcompra) throws SQLException{
        Conexao con = new Conexao();
        Conexao cona = new Conexao();
         Conexao cone = new Conexao();
        String Sql = "INSERT into dadosproduto (id, nome, valorcompra, valorvenda)"
                + " VALUES (default, \'"+nome+"\',\'"+valorcompra+"\',\'"+valorvenda+"\')";
        cona.insere(Sql);
        
        Sql =" SELECT * FROM dadosproduto WHERE dadosproduto.id = (SELECT MAX(dadosproduto.id) FROM dadosproduto)";
        ResultSet rs = con.busca(Sql);
        int a = 0;
         while(rs.next()){
             a= rs.getInt("id");
         }
        Sql = "INSERT into qtdpro (qtd, produto)"
                + " VALUES (\'"+qtd+"\',\'"+a+"\')";
        
        cone.insere(Sql);
       
    }
    public static void inserirUser(String nome, String tipo, String cpf) throws SQLException{
        Conexao c = new Conexao();
        String Sql = "INSERT into usuarios (nome, cpf, id, tipo)"
                + " VALUES (\'"+nome+"\',\'"+tipo+"\', default, \'"+cpf+"\')";
        c.insere(Sql);
        
    }
        
        
     
}
