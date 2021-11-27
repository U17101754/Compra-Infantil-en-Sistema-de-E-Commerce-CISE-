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
import soft.cise.interfaces.OperacionesDB;
import soft.cise.modeloDTO.compraDTO;
import soft.cise.modeloDTO.productoDTO;

/**
 *
 * @author SISTEMA
 */
public class ventaProductosDAO implements OperacionesDB<compraDTO> {

    private final String SQL_InsertCompra = "{call compraProducto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    private final String SQL_listaVentaPendiente = "{call listaVentaPendiente}";
    private final String SQL_listaVentaEnviado = "{call listaVentaEnviado}";
    private final String SQL_listaVentaEntregado = "{call listaVentaEntregado}";
    private final String SQL_detalleVentaProducto1 = "{call detalleVentaProducto1(?)}";
    private final String SQL_detalleVentaProducto2 = "{call detalleVentaProducto2 (?)}";
    private final String SQL_updateEstadoEnviado = "{call updateEstadoEnviado (?,?)}";
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
    public boolean sql_insert(compraDTO producto) {
        try {
            cts = cn.getCon().prepareCall(SQL_InsertCompra);
            cts.setInt(1, producto.getId1());
            cts.setInt(2, producto.getId2());
            cts.setInt(3, producto.getId3());
            cts.setInt(4, producto.getId4());
            cts.setInt(5, producto.getId5());
            cts.setInt(6, producto.getCantidad1());
            cts.setInt(7, producto.getCantidad2());
            cts.setInt(8, producto.getCantidad3());
            cts.setInt(9, producto.getCantidad4());
            cts.setInt(10, producto.getCantidad5());
            cts.setString(11, producto.getNombreCompleto());
            cts.setString(12, producto.getDni());
            cts.setString(13, producto.getTelefono1());
            cts.setString(14, producto.getTelefono2());
            cts.setString(15, producto.getDepartamento());
            cts.setString(16, producto.getProvincia());
            cts.setString(17, producto.getDistrito());
            cts.setString(18, producto.getDireccion());
            cts.setDouble(19, producto.getTotalProducto());
            cts.setDouble(20, producto.getCostoEnvio());
            cts.setDouble(21, producto.getIGV());
            cts.setDouble(22, producto.getTotalPagar());
            cts.setString(23, producto.getModoPago());
            cts.setString(24, producto.getCuenta());
            cts.setInt(25, producto.getIdUsuario());
            if (cts.executeUpdate() > 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al realizar el registro" + e.getMessage());
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean sql_update(compraDTO compradto) {
        boolean result = false;
         try {
            cts = cn.getCon().prepareCall(SQL_updateEstadoEnviado);
            cts.setInt(1, compradto.getIdVenta());
            cts.setString(2, compradto.getEstado());
            if(cts.executeUpdate() > 1){
                result = true;
            }
        } catch (Exception e) {
             System.out.println("Error al actualizar el estado del envio" + e.getMessage());
             e.printStackTrace();
        }finally{
             cerrarConexion();
         }
         return result;
    }

    @Override
    public boolean sql_delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public compraDTO sql_selectById(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<compraDTO> sql_selectAll() {
        ArrayList<compraDTO> compradtoList = new ArrayList<>();
        try {

        } catch (Exception e) {
        } finally {
            cerrarConexion();
        }
        return compradtoList;
    }

    @Override
    public ArrayList<compraDTO> sql_selectByName(compraDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //METODOS 
    public ArrayList<compraDTO> sql_listaVentaPendiente() {
        ArrayList<compraDTO> compradtoList = new ArrayList<>();
        try {
            cts = cn.getCon().prepareCall(SQL_listaVentaPendiente);
            rs = cts.executeQuery();
            while (rs.next()) {
                compraDTO compradto = new compraDTO(rs.getString("nombreCompleto"),
                        rs.getString("direccion"),
                        rs.getDouble("totalVenta"),
                        rs.getString("fecha"),
                        rs.getString("estado"),
                        rs.getString("destino"),
                        rs.getInt("idVenta"));
                compradtoList.add(compradto);

            }

        } catch (Exception e) {
        } finally {
            cerrarConexion();
        }
        return compradtoList;
    }

    public ArrayList<compraDTO> sql_listaVentaEnviado() {
        ArrayList<compraDTO> compradtoList = new ArrayList<>();
        try {
            cts = cn.getCon().prepareCall(SQL_listaVentaEnviado);
            rs = cts.executeQuery();
            while (rs.next()) {
                compraDTO compradto = new compraDTO(rs.getString("nombreCompleto"),
                        rs.getString("direccion"),
                        rs.getDouble("totalVenta"),
                        rs.getString("fecha"),
                        rs.getString("estado"),
                        rs.getString("destino"),
                        rs.getInt("idVenta"));
                compradtoList.add(compradto);

            }

        } catch (Exception e) {
        } finally {
            cerrarConexion();
        }
        return compradtoList;
    }

    public ArrayList<compraDTO> sql_listaVentaEntregado() {
        ArrayList<compraDTO> compradtoList = new ArrayList<>();
        try {
            cts = cn.getCon().prepareCall(SQL_listaVentaEntregado);
            rs = cts.executeQuery();
            while (rs.next()) {
                compraDTO compradto = new compraDTO(rs.getString("nombreCompleto"),
                        rs.getString("direccion"),
                        rs.getDouble("totalVenta"),
                        rs.getString("fecha"),
                        rs.getString("estado"),
                        rs.getString("destino"),
                        rs.getInt("idVenta"),
                rs.getString("fechaEntrega"));
                compradtoList.add(compradto);

            }

        } catch (Exception e) {
        } finally {
            cerrarConexion();
        }
        return compradtoList;
    }

    public compraDTO sql_detalleVentaProducto1(Object id) {
        compraDTO compradto = null;
        try {
            cts = cn.getCon().prepareCall(SQL_detalleVentaProducto1);
            cts.setInt(1, Integer.parseInt(id.toString()));
            rs = cts.executeQuery();
            while (rs.next()) {
                compradto = new compraDTO(rs.getString("nombreCompleto"),
                        rs.getString("direccion"),
                        rs.getDouble("costo"),
                        rs.getDouble("IGV"),
                        rs.getDouble("totalVenta"),
                        rs.getString("cuenta"),
                        rs.getString("fecha"),
                        rs.getString("estado"),
                        rs.getString("destino"),
                        rs.getInt("idVenta"),
                rs.getString("fechaEntrega"));
            }

        } catch (Exception e) {
            System.out.println("Error al ejecutar el procedimiento" + e.getMessage());
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return compradto;
    }

    public ArrayList<productoDTO> sql_detalleVentaProducto2(Object id) {
        ArrayList<productoDTO> compradtoList = new ArrayList<>();
        try {
            cts = cn.getCon().prepareCall(SQL_detalleVentaProducto2);
            cts.setInt(1, Integer.parseInt(id.toString()));
            rs = cts.executeQuery();
            while (rs.next()) {
                productoDTO productodto = new productoDTO(rs.getInt("idProducto"),
                        rs.getString("nombre"),
                        rs.getInt("cantidad"),
                        rs.getDouble("IGV"),
                        rs.getString("descripcion"),
                        rs.getInt("idVenta"),
                        rs.getDouble("totalProductos"));
                compradtoList.add(productodto);
            }

        } catch (Exception e) {
            System.out.println("Error al ejecutar el procedimiento" + e.getMessage());
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return compradtoList;
    }

}
