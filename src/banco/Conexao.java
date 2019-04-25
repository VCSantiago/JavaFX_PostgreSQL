
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {
    private String url;
    private String user;
    private String senha;
    private Connection con;

    public Conexao() {
        url = "jdbc:postgresql://localhost:5432/localhost";
        user = "postgres";
        senha = "81418822";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, senha);
            System.out.printf("Conexao gerada com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public  int insere(String sql){
        try {
            Statement stm = con.createStatement();
            int res = stm.executeUpdate(sql);
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public ResultSet  busca(String sql){
        try{
         Statement stm = con.createStatement();
         ResultSet rs = stm.executeQuery(sql);
         con.close();
         return rs;
         
        }catch(Exception e){
            return null;
        }
    }
     public void  deleta(String sql){
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            stm.executeUpdate();
            con.close();
        }catch(Exception e){
           
        }
    }
    
}
