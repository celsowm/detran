/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detran.dao;

import com.mysql.jdbc.Statement;
import detran.conexao.Conexao;
import detran.domain.Infracao;
import detran.domain.Pessoa;
import detran.domain.TipoInfracao;
import java.util.ArrayList;

/**
 *
 * @author celso
 */
public class InfracaoDao extends AbstractDao {

    @Override
    public int criar(Object objeto) throws Exception {
        
        var infracao = (Infracao) objeto;
        
        var query = "INSERT INTO infracao (descricao, tipo_infracao_id) VALUES (?, ?)";
        
        var statement = Conexao
                .getInstance()
                .getConnection()
                .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        
        statement.setString(1, infracao.getDescricao());
        statement.setInt(2, infracao.getTipo().getId());
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
        
        var query = "SELECT * "
                + "FROM infracao " 
                + "LEFT JOIN tipo_infracao "
                + "ON infracao.tipo_infracao_id = tipo_infracao.id";
        
        
        var statement = Conexao.getInstance()
                .getConnection()
                .prepareStatement(query + " WHERE infracao.id = ?");

        statement.setInt(1, id);

        var result = statement.executeQuery();

        result.absolute(1);
        return new Infracao(result.getString("descricao"),
                            new TipoInfracao(
                                    result.getString("grau"),
                                    result.getFloat("valor"),
                                    result.getInt("pontuacao")
                            )
                    );
    }

    @Override
    public ArrayList<Infracao> recuperar() throws Exception {

        var query = "SELECT * "
                + "FROM infracao " 
                + "LEFT JOIN tipo_infracao "
                + "ON infracao.tipo_infracao_id = tipo_infracao.id";
        var statement = Conexao.getInstance().getConnection().prepareStatement(query);
        var result = statement.executeQuery();

        var infracoes = new ArrayList<Infracao>();
        while (result.next()) {

            infracoes.add(
                    new Infracao(result.getString("descricao"),
                            new TipoInfracao(
                                    result.getString("grau"),
                                    result.getFloat("valor"),
                                    result.getInt("pontuacao")
                            )
                    ));
        }

        return infracoes;
    }

}
