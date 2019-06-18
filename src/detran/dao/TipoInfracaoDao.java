/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detran.dao;

import com.mysql.jdbc.Statement;
import detran.conexao.Conexao;
import detran.domain.TipoInfracao;
import java.util.ArrayList;

/**
 *
 * @author celso
 */
public class TipoInfracaoDao extends AbstractDao {

    @Override
    public boolean remover(int id) throws Exception {

        String query = "delete from tipo_infracao where id = ?";
        var statement = Conexao.getInstance()
                .getConnection().prepareStatement(query);
        statement.setInt(1, id);

        // execute the preparedstatement
        return statement.execute();
    }

    @Override
    public boolean atualizar(int id, Object objeto) throws Exception {

        TipoInfracao tipoInfracao = (TipoInfracao) objeto;
        
        var query = "update tipo_infracao set grau = ?, pontuacao = ?, valor = ? where id = ?";
        var statement = Conexao.getInstance().getConnection().prepareStatement(query);
        statement.setString(1, tipoInfracao.getGrau());
        statement.setFloat(2, tipoInfracao.getValor());
        statement.setInt(3, tipoInfracao.getPontuacao());
        statement.setInt(4, id);

        // execute the java preparedstatement
        return statement.execute();

    }

    @Override
    public TipoInfracao recuperar(int id) throws Exception {

        var statement = Conexao.getInstance()
                .getConnection()
                .prepareStatement("SELECT * FROM tipo_infracao WHERE id = ?");

        statement.setInt(1, id);

        var result = statement.executeQuery();
        
        if(result.next() == false){
            return null;
        }

        result.absolute(1);
        return new TipoInfracao(
                result.getInt("id"),
                result.getString("grau"),
                result.getFloat("valor"),
                result.getInt("pontuacao"));
    }

    @Override
    public ArrayList<TipoInfracao> recuperar() throws Exception {
        var statement = Conexao.getInstance().getConnection().prepareStatement("SELECT * FROM tipo_infracao");
        var result = statement.executeQuery();

        var tiposInfracao = new ArrayList<TipoInfracao>();
        while (result.next()) {
            tiposInfracao.add(
                    new TipoInfracao(
                            result.getInt("id"),
                            result.getString("grau"),
                            result.getFloat("valor"),
                            result.getInt("pontuacao"))
            );
        }

        return tiposInfracao;
    }

    @Override
    public int criar(Object objeto) throws Exception {

        var tipoInfracao = (TipoInfracao) objeto;

        var query = " insert into tipo_infracao (grau, valor, pontuacao)"
                + " values (?, ?, ?)";

        var statement = Conexao.getInstance()
                .getConnection()
                .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, tipoInfracao.getGrau());
        statement.setDouble(2, Double.valueOf(tipoInfracao.getValor()));
        statement.setInt(3, tipoInfracao.getPontuacao());

        // execute the preparedstatement
        statement.executeUpdate();
        var rs = statement.getGeneratedKeys();
        var id = 0;
        if (rs.next()) {
            id = rs.getInt(1);
        }

        return id;

    }

}
