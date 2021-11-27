/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.cise.interfaces;

import soft.cise.modeloDTO.usuarioDTO;

/**
 *
 * @author Alumno
 */
public interface OperacionesUsu<T> {
    public abstract boolean addUsu(T t);
    public String recuperarUsu(T t);
    public usuarioDTO login(T t);
    
}
