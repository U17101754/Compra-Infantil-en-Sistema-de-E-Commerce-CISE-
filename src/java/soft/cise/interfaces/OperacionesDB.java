/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.cise.interfaces;

import java.util.ArrayList;

/**
 *
 * @author SISTEMA
 */
public interface OperacionesDB <T> {
    public abstract boolean sql_insert(T t);
    public abstract boolean sql_update(T t);
    public abstract boolean sql_delete(Object id);
    public abstract T sql_selectById(Object id);
    public abstract ArrayList<T> sql_selectAll();
    public abstract ArrayList<T> sql_selectByName(T t);
    
}
