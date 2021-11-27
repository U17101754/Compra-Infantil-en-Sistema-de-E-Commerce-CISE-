/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.cise.controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import soft.cise.modeloDTO.articuloDTO;
import soft.cise.modeloDTO.compraDTO;
import soft.cise.modeloDTO.productoDTO;
import soft.cise.modeloDao.metProduc;
import soft.cise.modeloDao.ventaProductosDAO;

/**
 *
 * @author SISTEMA
 */
public class comCatalogo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession sessionOK = request.getSession();
            String accion = request.getParameter("txtAccion");
            switch (accion) {
                case "imagen":
                    int idProducto = Integer.parseInt(request.getParameter("id"));
                    metProduc metPro = new metProduc();
                    metPro.listarImg(idProducto, response);
                    break;
                case "productoDescrip":
                    request.setAttribute("id", request.getParameter("id"));
                    request.getRequestDispatcher("mtienda/productoDescripcion.jsp").forward(request, response);
                    break;
                case "Agregar CArrito":
                    int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                    int id = Integer.parseInt(request.getParameter("id"));

                    HttpSession sesion = request.getSession();
                    ArrayList<articuloDTO> articulos = sesion.getAttribute("carrito") == null ? new ArrayList<>() : (ArrayList) sesion.getAttribute("carrito");

                    boolean falg = false;
                    if (articulos.size() > 0) {
                        for (articuloDTO a : articulos) {
                            if (id == a.getIdProducto()) {
                                a.setCantidad(a.getCantidad() + cantidad);
                                falg = true;
                                break;
                            }
                        }
                    }
                    if (!falg) {
                        articulos.add(new articuloDTO(id, cantidad));
                    }

                    sesion.setAttribute("carrito", articulos);
                    request.getRequestDispatcher("mtienda/carrito.jsp").forward(request, response);
                    break;
                case "carrito":
                    request.getRequestDispatcher("mtienda/carrito.jsp").forward(request, response);
                    break;

                case "deleteArticulo":
                    int idArticulo = Integer.parseInt(request.getParameter("idproducto"));

                    HttpSession sesion1 = request.getSession();
                    ArrayList<articuloDTO> articulo = sesion1.getAttribute("carrito") == null ? null : (ArrayList) sesion1.getAttribute("carrito");
                    if (articulo != null) {
                        for (articuloDTO b : articulo) {
                            if (b.getIdProducto() == idArticulo) {
                                articulo.remove(b);
                                break;
                            }

                        }
                    }
                    metProduc metp = new metProduc();
                    double total = 0;
                    for (articuloDTO a : articulo) {
                        productoDTO producto = metp.sql_selectById(a.getIdProducto());
                        total += a.getCantidad() * producto.getPrecioVenta();
                    }
                    response.getWriter().print(Math.round(total * 100.0) / 100.0);
                    break;
                case "Comprar":
                    compraDTO compradto = new compraDTO();
                    if (sessionOK.getAttribute("nombre") == null) {
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    } else if (sessionOK.getAttribute("nombre") != null) {
                        String id1 = request.getParameter("txtId1");
                        if (id1 != null) {
                            compradto.setId1(Integer.parseInt(id1));
                        }
                        String id2 = request.getParameter("txtId2");
                        if (id2 != null) {
                            compradto.setId2(Integer.parseInt(id2));
                        }
                        String id3 = request.getParameter("txtId3");
                        if (id3 != null) {
                            compradto.setId3(Integer.parseInt(id3));
                        }
                        String id4 = request.getParameter("txtId4");
                        if (id4 != null) {
                            compradto.setId4(Integer.parseInt(id4));
                        }
                        String id5 = request.getParameter("txtId5");
                        if (id5 != null) {
                            compradto.setId5(Integer.parseInt(id5));
                        }
                        compradto.setCantidad1(Integer.parseInt(request.getParameter("txtCantidad1")));
                        String cantidad2 = request.getParameter("txtCantidad2");
                        if (cantidad2 != null) {
                            compradto.setCantidad2(Integer.parseInt(cantidad2));
                        }
                        String cantidad3 = request.getParameter("txtCantidad3");
                        if (cantidad3 != null) {
                            compradto.setCantidad3(Integer.parseInt(cantidad3));
                        }
                        String cantidad4 = request.getParameter("txtCantidad4");
                        if (cantidad4 != null) {
                            compradto.setCantidad4(Integer.parseInt(cantidad4));
                        }
                        String cantidad5 = request.getParameter("txtCantidad5");
                        if (cantidad5 != null) {
                            compradto.setCantidad5(Integer.parseInt(cantidad5));
                        }
                        compradto.setNombreCompleto(request.getParameter("txtNombreCliente"));
                        compradto.setDni(request.getParameter("txtDni"));
                        compradto.setTelefono1(request.getParameter("txtTelefono1"));
                        compradto.setTelefono2(request.getParameter("txtTelefono2"));
                        compradto.setDepartamento(request.getParameter("txtDepartamento"));
                        compradto.setProvincia(request.getParameter("txtProvincia"));
                        compradto.setDistrito(request.getParameter("txtDistrito"));
                        compradto.setDireccion(request.getParameter("txtDireccion"));
                        compradto.setTotalProducto(Double.parseDouble(request.getParameter("txtTotalProducto")));
                        compradto.setCostoEnvio(Double.parseDouble(request.getParameter("txtCostoEnvio")));
                        compradto.setIGV(Double.parseDouble(request.getParameter("txtIGV")));
                        compradto.setTotalPagar(Double.parseDouble(request.getParameter("txtTotalPago")));
                        compradto.setModoPago(request.getParameter("txtMedioPago"));
                        compradto.setCuenta(request.getParameter("txtCuenta"));
                        compradto.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));

                        ventaProductosDAO ventaProducto = new ventaProductosDAO();
                        ventaProducto.sql_insert(compradto);
                        sessionOK.removeAttribute("carrito");

                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                    break;

            }
        } catch (Exception e) {
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
