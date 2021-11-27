/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.cise.test;

import soft.cise.modeloDTO.productoDTO;
import soft.cise.modeloDao.metProduc;

/**
 *
 * @author SISTEMA
 */
public class prueba {
    
    public static void main(String[] args) {
        int id = 3;
        metProduc metp = new metProduc();
        productoDTO produc = metp.sql_selectById(id);
        
        System.out.println(""+ produc.getDescripcion()+produc.getNombProducto());
        
    }
    
}
