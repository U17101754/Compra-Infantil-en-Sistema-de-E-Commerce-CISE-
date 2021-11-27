/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.cise.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import soft.cise.modeloDTO.usuarioDTO;
import soft.cise.modeloDao.usuarioDAO;

/**
 *
 * @author SISTEMA
 */
public class conUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String sistema = "sistema.jsp";
    String index = "index.jsp";
    String login = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String accion = request.getParameter("txtAccion");
            String acceso = "";

            HttpSession sessionOk = request.getSession();
            switch (accion) {
                case "Ingresar":
                    String correo = request.getParameter("txtCorreo");
                    String clave = request.getParameter("txtClave");

                    usuarioDTO usuariodto = new usuarioDTO(correo, clave);
                    usuarioDAO usuariodao = new usuarioDAO();
                    usuarioDTO usuario = usuariodao.login(usuariodto);

                    if (correo.equalsIgnoreCase(usuario.getCorreo()) && clave.equalsIgnoreCase(usuario.getClave())) {
                        sessionOk.setAttribute("perfil", usuario.getPerfil());
                        sessionOk.setAttribute("nombre", usuario.getNombre());
                        sessionOk.setAttribute("estado", usuario.getEstado());
                        sessionOk.setAttribute("idUsuario", usuario.getId());
                        if(usuario.getPerfil().equalsIgnoreCase("cliente")){
                            acceso = index;
                            request.getRequestDispatcher(acceso).forward(request, response);
                        }else{
                            acceso = sistema;
                            request.getRequestDispatcher(acceso).forward(request, response);
                        }
                    } else {
                        acceso = index;
                        request.getRequestDispatcher(acceso).forward(request, response);
                    }
                    break;
                case "cerrarSession":
                    sessionOk.removeAttribute("perfil");
                    sessionOk.removeAttribute("nombre");
                    sessionOk.removeAttribute("estado");
                    sessionOk.invalidate();
                    acceso = login;
                    request.getRequestDispatcher(acceso).forward(request, response);
                    break;
                case "Registrar":
                    String nombre = request.getParameter("txtNombre");
                    String email = request.getParameter("txtCorreo");
                    String password = request.getParameter("txtPass");
                    String perfil = request.getParameter("txtPerfil");
                    usuarioDTO usu = new usuarioDTO(nombre, email, password, perfil);
                    usuarioDAO metAdd = new usuarioDAO();
                    if (metAdd.addUsu(usu) != true) {
                        acceso = login;
                        request.getRequestDispatcher(acceso).forward(request, response);
                    } else {
                        acceso = index;
                        request.getRequestDispatcher(acceso).forward(request, response);
                    }

                    break;

                case "eliminar":
                    break;
            }

        } catch (Exception e) {
            System.out.println("error al realizar consultas" + e.getMessage());

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
