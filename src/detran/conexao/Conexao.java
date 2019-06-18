/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detran.conexao;

import java.sql.*;

/**
 *
 * @author celso
 */
public class Conexao {

    private Connection jdbcConnection;
    private String banco = "multa";
    private String usuario = "root";
    private String senha = "";
    private String servidor = "localhost";
    private static Conexao singleton;
    
    private Conexao(){
        
        
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            this.jdbcConnection = DriverManager
                .getConnection("jdbc:mysql://"
                        + this.servidor 
                        + "/" + this.banco 
                        + "?user=" + this.usuario
                        + "&password=" + this.senha
                        + "&useSSL=false");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public Connection getConnection(){
        return this.jdbcConnection;
    }
    
    public static Conexao getInstance(){
        if(Conexao.singleton == null){
           Conexao.singleton = new Conexao();  
        }
        return Conexao.singleton;
    }

}
