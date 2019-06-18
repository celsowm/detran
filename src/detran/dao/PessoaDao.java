/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detran.dao;

import com.mysql.jdbc.Statement;
import detran.conexao.Conexao;
import detran.domain.Habilitacao;
import detran.domain.Pessoa;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author celso
 */
public class PessoaDao extends AbstractDao {

    @Override
    public int criar(Object objeto) throws Exception {
        
        var pessoa = (Pessoa) objeto;
        
        var query = "INSERT INTO pessoa (nome) VALUES (?)";
        
        var statement = Conexao
                .getInstance()
                .getConnection()
                .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        
        statement.setString(1, pessoa.getNome());
        statement.executeUpdate();
        var rs = statement.getGeneratedKeys();
        var id = 0;
        if (rs.next()) {
            id = rs.getInt(1);
        }

        return id;
        
        
    }

    @Override
    public boolean remover(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean atualizar(int id, Object objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object recuperar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pessoa> recuperar() throws Exception {
        var query = "SELECT * FROM pessoa LEFT JOIN habilitacao ON pessoa.id = habilitacao.pessoa_id";
        var statement = Conexao.getInstance()
                .getConnection().prepareStatement(query);
        
        var result = statement.executeQuery();
        var pessoas = new ArrayList<Pessoa>(); 
        while(result.next()){
            var pessoa = new Pessoa(
                            result.getInt("id"),
                            result.getString("nome")
                                );   
            var habilitacao = new Habilitacao(
                    result.getString("numero"), 
                    result.getString("categoria"), 
                    pessoa);
            
            if(result.getString("pessoa_id") != null){
                pessoa.setHabilitacao(habilitacao);
            }
            
            pessoas.add(
                      pessoa       
                    );
        }
        
        return pessoas;
        
        
    }
    
}
