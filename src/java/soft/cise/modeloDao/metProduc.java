/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.cise.modeloDao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import soft.cise.conexionDB.ConexionBD;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import soft.cise.interfaces.OperacionesDB;
import soft.cise.modeloDTO.productoDTO;

/**
 *
 * @author Alumno
 */
public class metProduc implements OperacionesDB<productoDTO> {

    private final String SQl_lisCategoria = "{call listarCategoria}";
    private final String SQL_insertProducto = "{call registrarProducto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    private final String SQL_lis12productos = "{call lis12Productos}";
    private final String SQL_selectAllProducto = "{call selectAllProducto}";
    private final String SQL_selectById = "{call selectById (?)}";
    private final String SQL_updateProducto = "{call EditarProducto (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    private final String SQL_delete_produc = "{call SQL_delete_produc (?)}";
    private final String SQL_selectByName = "";
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

    public List listarCateg() {
        ArrayList<productoDTO> list = new ArrayList<>();
        try {
            cts = cn.getCon().prepareCall(SQl_lisCategoria);
            rs = cts.executeQuery();
            while (rs.next()) {
                productoDTO productodto = new productoDTO(rs.getString("categoria"));
                list.add(productodto);
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta" + e.getMessage());
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return list;
    }

    public ArrayList<productoDTO> listProduc12() {
        ArrayList<productoDTO> lis = new ArrayList<>();
        try {
            cts = cn.getCon().prepareCall(SQL_lis12productos);
            rs = cts.executeQuery();
            while (rs.next()) {
                productoDTO produc = new productoDTO(rs.getInt("idProducto"),
                        rs.getString("categoria"),
                        rs.getString("nombre"),
                        rs.getInt("cantidad"),
                        rs.getDouble("totalCompra"),
                        rs.getDouble("precioVenta"),
                        rs.getString("marca"),
                        rs.getString("descripcion"));
                lis.add(produc);
            }

        } catch (Exception e) {
            System.out.println("Error al realizar la consulta" + e.getMessage());
            e.printStackTrace();
        } finally {
           
        }
        return lis;
    }

    @Override
    public boolean sql_insert(productoDTO producto) {
        boolean result = false;
        try {
            cts = cn.getCon().prepareCall(SQL_insertProducto);
            cts.setString(1, producto.getNombProducto());
            cts.setInt(2, producto.getCantidad());
            cts.setString(3, producto.getMoneda());
            cts.setDouble(4, producto.getPrecioCompra());
            cts.setDouble(5, producto.getTipoCambio());
            cts.setDouble(6, producto.getPrecioVenta());
            cts.setDouble(7, producto.getIGV());
            cts.setString(8, producto.getProveedor());
            cts.setString(9, producto.getTalla1());
            cts.setString(10, producto.getTalla2());
            cts.setString(11, producto.getTalla3());
            cts.setString(12, producto.getTalla4());
            cts.setInt(13, producto.getIdCategoria());
            cts.setString(14, producto.getMarca());
            cts.setString(15, producto.getDescripcion());
            cts.setBlob(16, producto.getImg());
            if (cts.executeUpdate() > 1) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error al Insertar Productos" + e.getMessage());
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return result;
    }

    @Override
    public boolean sql_update(productoDTO producto) {
        try {
            cts = cn.getCon().prepareCall(SQL_updateProducto);
            cts.setInt(1, producto.getIdProducto());
            cts.setString(2, producto.getNombProducto());
            cts.setInt(3, producto.getCantidad());
            cts.setString(4, producto.getMoneda());
            cts.setDouble(5, producto.getPrecioCompra());
            cts.setDouble(6, producto.getTipoCambio());
            cts.setDouble(7, producto.getPrecioVenta());
            cts.setDouble(8, producto.getIGV());
            cts.setString(9, producto.getProveedor());
            cts.setString(10, producto.getTalla1());
            cts.setString(11, producto.getTalla2());
            cts.setString(12, producto.getTalla3());
            cts.setString(13, producto.getTalla4());
            cts.setInt(14, producto.getIdCategoria());
            cts.setString(15, producto.getMarca());
            cts.setString(16, producto.getDescripcion());
            cts.setBlob(17, producto.getImg());
            if (cts.executeUpdate() > 1) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al actualizar datos" + e.getMessage());
            e.printStackTrace();
        } finally {

        }
        return false;
    }

    @Override
    public boolean sql_delete(Object id) {
        boolean result = false;
        try {
            cts = cn.getCon().prepareCall(SQL_delete_produc);
            cts.setInt(1, Integer.parseInt(id.toString()));
            if (cts.executeUpdate() > 1) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar producto" + e.getMessage());
        } finally {
            cerrarConexion();
        }
        return result;
    }

    @Override
    public productoDTO sql_selectById(Object id) {
        productoDTO productoDto = null;
        try {
            cts = cn.getCon().prepareCall(SQL_selectById);
            cts.setInt(1, Integer.parseInt(id.toString()));
            rs = cts.executeQuery();
            while (rs.next()) {
                productoDto = new productoDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getDouble(7),
                        rs.getDouble(8),
                        rs.getDouble(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16));
            }
        } catch (Exception e) {
            System.out.println("Error al seleccionar por la id" + e.getMessage());
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return productoDto;
    }

    @Override
    public ArrayList<productoDTO> sql_selectAll() {
        ArrayList<productoDTO> lista = new ArrayList<>();
        InputStream inputStream = null;
        try {
            cts = cn.getCon().prepareCall(SQL_selectAllProducto);
            rs = cts.executeQuery();
            while (rs.next()) {
                productoDTO producto = new productoDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getDouble(7),
                        rs.getDouble(8),
                        rs.getDouble(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16));
                lista.add(producto);
            }

        } catch (Exception e) {
            System.out.println("Error al listar todos los productos" + e.getMessage());
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return lista;
    }

    public void listarImg(int id, HttpServletResponse res) {
        String sql_listarImg = "select * from producto where idProducto=" + id;
        InputStream inputStream = null;
        OutputStream outPutStream = null;
        BufferedInputStream bufferedInpuStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        res.setContentType("img/*");
        try {
            outPutStream = res.getOutputStream();
            cts = cn.getCon().prepareCall(sql_listarImg);
            rs = cts.executeQuery();
            if (rs.next()) {
                inputStream = rs.getBinaryStream("imgProducto");

            }
            bufferedInpuStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outPutStream);
            int i = 0;
            while ((i = bufferedInpuStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }
        } catch (Exception e) {
            System.out.println("Nose pudo listar" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<productoDTO> sql_selectByName(productoDTO t) {
        ArrayList<productoDTO> listName = new ArrayList<>();
        try {
            cts = cn.getCon().prepareCall(SQL_selectByName);
            cts.setString(1, t.getNombProducto());
            rs = cts.executeQuery();
            while (rs.next()) {
                productoDTO produc = new productoDTO();
                produc.setIdProducto(rs.getInt("idProducto"));
                produc.setNombProducto(rs.getString("nombre"));
                produc.setCantidad(rs.getInt("cantidad"));
                produc.setMoneda(rs.getString("moneda"));
                produc.setPrecioCompra(rs.getDouble("precioCompra"));
                produc.setTipoCambio(rs.getDouble("tipoCambio"));
                produc.setPrecioVenta(rs.getDouble("precioVenta"));
                produc.setProveedor(rs.getString("proveedor"));
                produc.setCategoria(rs.getString("categoria"));
                produc.setMarca(rs.getString("marca"));
                produc.setTalla1(rs.getString("talla"));
                produc.setDescripcion(rs.getString("descripcion"));
                listName.add(produc);
            }
        } catch (Exception e) {
            System.out.println("Error al listar por nombre: " + e.getMessage());
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return listName;
    }

}
