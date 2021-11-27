/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.cise.test;

import soft.cise.modeloDTO.compraDTO;
import soft.cise.modeloDao.ventaProductosDAO;

/**
 *
 * @author SISTEMA
 */
public class prrueba2 {
    
    public static void main(String[] args) {
         compraDTO compraDTO = new compraDTO();
                    compraDTO.setId1(1);
                    compraDTO.setCantidad1(2);
                    compraDTO.setNombreCompleto("rivera3");
                    compraDTO.setDni("73328485");
                    compraDTO.setTelefono1("990802205");
                    compraDTO.setTelefono2("11111");
                    compraDTO.setDepartamento("lima");
                    compraDTO.setProvincia("lima");
                    compraDTO.setDistrito("puente piedra");
                    compraDTO.setDireccion("mz b lt 12");
                    compraDTO.setTotalProducto(250);
                    compraDTO.setCostoEnvio(3.0);
                    compraDTO.setIGV(0.5);
                    compraDTO.setTotalPagar(253);
                    compraDTO.setModoPago("visa");
                    compraDTO.setCuenta("12354");
                    compraDTO.setIdUsuario(3);
                    ventaProductosDAO ventaProducto = new ventaProductosDAO();
                    ventaProducto.sql_insert(compraDTO);
    }
    
}
