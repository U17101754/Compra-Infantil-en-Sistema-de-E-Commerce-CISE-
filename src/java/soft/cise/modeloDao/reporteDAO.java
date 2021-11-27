/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.cise.modeloDao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import soft.cise.conexionDB.ConexionBD;
import soft.cise.interfaces.reportesDBO;
import soft.cise.modeloDTO.reporteDTO;

/**
 *
 * @author SISTEMA
 */
public class reporteDAO implements reportesDBO<reporteDTO> {

    private final String SQL_reporteProducto = "{call reporteProducto (?)}";
    private static CallableStatement cts;
    private static ResultSet rs;
    private ConexionBD cn = ConexionBD.conectar();

    public void cerrarConexion() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (cts != null) {
                cts.close();
            }
            if (cn != null) {
                cn.cerrarConexion();
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar Conexiones" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<reporteDTO> reporteProducto(int mes) {
        ArrayList<reporteDTO> reporteProductoList = new ArrayList<>();
        try {
            cts=cn.getCon().prepareCall(SQL_reporteProducto);
            cts.setInt(1, mes);
            rs = cts.executeQuery();
            while(rs.next()){
                reporteDTO reportedto = new reporteDTO(rs.getInt("idProducto"), 
                        rs.getString("nombrePro"), 
                        rs.getString("nombre"), 
                        rs.getDouble("precioCompra"), 
                        rs.getInt("Stock"), 
                        rs.getDouble("totalCompra"));
                reporteProductoList.add(reportedto);
            }
               
        } catch (Exception e) {
            System.out.println("Error al realizar el reporte de los productos" + e.getMessage());
            e.printStackTrace();
        }finally{
            cerrarConexion();
        }
        return  reporteProductoList;
    }

}
