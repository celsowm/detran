/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detran.dao;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author celso
 */
public abstract class AbstractDao {
    
    public abstract int criar(Object objeto) throws Exception;
    public abstract boolean remover(int id) throws Exception;
    public abstract boolean atualizar(int id, Object objeto) throws Exception;
    public abstract Object recuperar(int id) throws Exception;
    public abstract Collection recuperar() throws Exception;
    
}
