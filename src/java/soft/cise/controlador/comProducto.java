package soft.cise.controlador;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import soft.cise.modeloDTO.compraDTO;
import soft.cise.modeloDTO.productoDTO;
import soft.cise.modeloDao.metProduc;
import soft.cise.modeloDao.ventaProductosDAO;

/**
 *
 * @author Lunarejo Aponte Luis
 */
@MultipartConfig
public class comProducto extends HttpServlet {

    String sistema = "sistema.jsp";
    String addProduc = "msistema/addproducto.jsp";
    String index = "index.jsp";
    String updateProducto = "msistema/updateProducto.jsp";
    String login = "login.jsp";
    String listaProducto = "msistema/listProducto.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String accion = request.getParameter("txtAccion");
            String acceso = "";
            int id;

            switch (accion) {
                case "addProducto":
                    acceso = addProduc;
                    request.getRequestDispatcher(acceso).forward(request, response);
                    break;
                case "updateProducto":
                    request.setAttribute("id", request.getParameter("id"));
                    acceso = updateProducto;
                    request.getRequestDispatcher(acceso).forward(request, response);
                    break;
                case "agregar":
                    productoDTO producto = new productoDTO();
                    producto.setNombProducto(request.getParameter("txtProducto"));
                    producto.setCantidad(Integer.parseInt(request.getParameter("txtCantidad")));
                    producto.setMoneda(request.getParameter("txtMoneda"));
                    producto.setPrecioCompra(Double.parseDouble(request.getParameter("txtPrecioCompra")));
                    producto.setTipoCambio(Double.parseDouble(request.getParameter("txtTipoCambio")));
                    producto.setPrecioVenta(Double.parseDouble(request.getParameter("txtPrecioVenta")));
                    producto.setIGV(Double.parseDouble(request.getParameter("txtIGV")));
                    producto.setProveedor(request.getParameter("txtProveedor"));
                    producto.setTalla1(request.getParameter("txtTalla1"));
                    producto.setTalla2(request.getParameter("txtTalla2"));
                    producto.setTalla3(request.getParameter("txtTalla3"));
                    producto.setTalla4(request.getParameter("txtTalla4"));
                    producto.setIdCategoria(Integer.parseInt(request.getParameter("txtCategoria")));
                    producto.setMarca(request.getParameter("txtModelo"));
                    producto.setDescripcion(request.getParameter("txtDescripcion"));
                    Part part = request.getPart("txtImgProducto");
                    InputStream inputStream = part.getInputStream();
                    producto.setImg(inputStream);
                    metProduc metAdd = new metProduc();
                    if (metAdd.sql_insert(producto) != true) {
                        acceso = addProduc;
                        request.getRequestDispatcher(acceso).forward(request, response);
                    } else {
                        acceso = sistema;
                        request.getRequestDispatcher(acceso).forward(request, response);
                    }

                    break;
                case "actualizar":
                    productoDTO productodto = new productoDTO();
                    productodto.setIdProducto(Integer.parseInt(request.getParameter("id")));
                    productodto.setNombProducto(request.getParameter("txtProducto"));
                    productodto.setCantidad(Integer.parseInt(request.getParameter("txtCantidad")));
                    productodto.setMoneda(request.getParameter("txtMoneda"));
                    productodto.setPrecioCompra(Double.parseDouble(request.getParameter("txtPrecioCompra")));
                    productodto.setTipoCambio(Double.parseDouble(request.getParameter("txtTipoCambio")));
                    productodto.setPrecioVenta(Double.parseDouble(request.getParameter("txtPrecioVenta")));
                    productodto.setIGV(Double.parseDouble(request.getParameter("txtIGV")));
                    productodto.setProveedor(request.getParameter("txtProveedor"));
                    productodto.setTalla1(request.getParameter("txtTalla1"));
                    productodto.setTalla2(request.getParameter("txtTalla2"));
                    productodto.setTalla3(request.getParameter("txtTalla3"));
                    productodto.setTalla4(request.getParameter("txtTalla4"));
                    productodto.setIdCategoria(Integer.parseInt(request.getParameter("txtCategoria")));
                    productodto.setMarca(request.getParameter("txtModelo"));
                    productodto.setDescripcion(request.getParameter("txtDescripcion"));
                    Part partImg = request.getPart("txtImgProducto");
                    InputStream inputStreamimg = partImg.getInputStream();
                    productodto.setImg(inputStreamimg);
                    metProduc metProductoUpdate = new metProduc();
                    metProductoUpdate.sql_update(productodto);
                    acceso = listaProducto;
                    request.getRequestDispatcher(acceso).forward(request, response);
                    break;
                case "delete1":
                    id = Integer.parseInt(request.getParameter("id"));
                    metProduc metDelete1 = new metProduc();
                    if (metDelete1.sql_delete(id) != true) {
                        acceso = addProduc;
                        request.getRequestDispatcher(acceso).forward(request, response);
                    }
                    break;
                case "delete2":
                    id = Integer.parseInt(request.getParameter("id"));
                    metProduc metDelete2 = new metProduc();
                    if (metDelete2.sql_delete(id) != true) {
                        acceso = listaProducto;
                        request.getRequestDispatcher(acceso).forward(request, response);
                    }
                    break;
                case "listProducto":
                    request.getRequestDispatcher(listaProducto).forward(request, response);
                    break;
                case "listId":
                    productoDTO nombreP = new productoDTO();
                    nombreP.setNombProducto(request.getParameter("txtNombre"));
                    metProduc metListId = new metProduc();
                    metListId.sql_selectByName(nombreP);
                    request.getRequestDispatcher(listaProducto).forward(request, response);
                    break;
                case "listName":
                    break;
                case "venta":
                    request.getRequestDispatcher("msistema/ventas.jsp").forward(request, response);
                    break;
                case "productosPendiente":
                    ventaProductosDAO ventaproductoPendiente = new ventaProductosDAO();
                    ArrayList<compraDTO> compradto = ventaproductoPendiente.sql_listaVentaPendiente();
                    request.getSession().setAttribute("productoPendiente", compradto);
                    request.getRequestDispatcher("msistema/venta/productosPendiente.jsp").forward(request, response);
                    break;
                case "productosEnviados":
                    ventaProductosDAO ventaProductoEnviado = new ventaProductosDAO();
                    ArrayList<compraDTO> compraenviado = ventaProductoEnviado.sql_listaVentaEnviado();
                    request.getSession().setAttribute("productoEnviado", compraenviado);
                    request.getRequestDispatcher("msistema/venta/productosEnviados.jsp").forward(request, response);
                    break;
                case "productosEntregados":
                    ventaProductosDAO ventaProductoEntregado = new ventaProductosDAO();
                    ArrayList<compraDTO> compraEntregado = ventaProductoEntregado.sql_listaVentaEntregado();
                    request.getSession().setAttribute("productoEntregado", compraEntregado);
                    request.getRequestDispatcher("msistema/venta/productosEntregados.jsp").forward(request, response);
                    break;
                case "detalleVentaProducto":
                    request.setAttribute("idVenta", request.getParameter("txtIdVenta"));
                    ventaProductosDAO ventaProducto = new ventaProductosDAO();
                    ArrayList<productoDTO> lisProducto = ventaProducto.sql_detalleVentaProducto2(Integer.parseInt(request.getParameter("txtIdVenta")));
                    request.getSession().setAttribute("listaProducto", lisProducto);
                    request.getRequestDispatcher("msistema/venta/detalleVenta.jsp").forward(request, response);
                    break;
                case "Guardar":
                    compraDTO compradtoEstadoEnviado = new compraDTO();
                    compradtoEstadoEnviado.setIdVenta(Integer.parseInt(request.getParameter("txtIdVenta")));
                    compradtoEstadoEnviado.setEstado(request.getParameter("txtEstado"));
                    ventaProductosDAO ventaProductoEstadoEnviado = new ventaProductosDAO();
                    if(ventaProductoEstadoEnviado.sql_update(compradtoEstadoEnviado) != true){
                        request.getRequestDispatcher("comproducto.do?txtAccion=venta").forward(request, response);
                    }else {
                        request.getRequestDispatcher("comproducto.do?txtAccion=detalleVentaProducto").forward(request, response);
                    }
                    break;
                case "Cancelar":
                    request.getRequestDispatcher("comproducto.do?txtAccion=venta").forward(request, response);
                    break;

            }

        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
