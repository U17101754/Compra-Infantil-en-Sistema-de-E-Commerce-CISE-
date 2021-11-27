/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.cise.test;

import soft.cise.modeloDTO.usuarioDTO;
import soft.cise.modeloDao.usuarioDAO;

/**
 *
 * @author SISTEMA
 */
public class prueba3 {

    public static void main(String[] args) {
        String nombre = "Usuario02";
        String email = "Usuario2@prueba.com";
        String password1 = "123";
        String paswword2 = "123";
        String perfil = "cliente";
        if (password1.equalsIgnoreCase(paswword2)) {
            System.out.println("Registrado correctamente");
            usuarioDTO usu = new usuarioDTO(nombre, email, password1, perfil);
            usuarioDAO metAdd = new usuarioDAO();
            metAdd.addUsu(usu);
        }else{
            System.out.println("Contraseña no coincide");
        }
    }
}
