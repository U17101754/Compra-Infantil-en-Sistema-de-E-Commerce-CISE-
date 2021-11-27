/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.cise.test;
import java.util.ArrayList;
import soft.cise.modeloDTO.reporteDTO;
import soft.cise.modeloDao.reporteDAO;
import soft.cise.modeloDTO.usuarioDTO;
import soft.cise.modeloDao.usuarioDAO;
/**
 *
 * @author SISTEMA
 */
public class prueba4 {

    public static void main(String[] args) {
       String email = "cesar.durand@gmail.com";
        String password1 = "123";          

        if (password1.equalsIgnoreCase("123")) {
            System.out.println("Login correcto");
            usuarioDTO usu = new usuarioDTO(email, password1);
            usuarioDAO metAdd = new usuarioDAO();
            metAdd.login(usu);
        }else{
            System.out.println("Usuario o contraseña incorrectas");
        }
    }

}
