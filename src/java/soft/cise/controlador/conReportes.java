/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.cise.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import soft.cise.modeloDTO.reporteDTO;
import soft.cise.modeloDao.reporteDAO;

/**
 *
 * @author SISTEMA
 */
public class conReportes extends HttpServlet {

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
            String accion = request.getParameter("txtAccion");

            switch (accion) {
                case "reportes":
                    request.getRequestDispatcher("msistema/reporte.jsp").forward(request, response);
                    break;
                case "reporteProducto":
                    int mes = Integer.parseInt(request.getParameter("txtMes"));
                    reporteDAO reportedao = new reporteDAO();
                    ArrayList<reporteDTO> reporteProducto = reportedao.reporteProducto(mes);
                    double total = 0;
                    for (reporteDTO reporte : reporteProducto) {
                        total += reporte.getCantidad() * reporte.getPrecioCompra();

                    }
                    request.setAttribute("totalMes", total);
                    request.getSession().setAttribute("reporteProducto", reporteProducto);
                    request.getRequestDispatcher("msistema/reportes/reporteProducto.jsp").forward(request, response);
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
