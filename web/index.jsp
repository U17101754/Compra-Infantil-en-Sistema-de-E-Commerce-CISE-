<%-- 
    Document   : index
    Created on : 23/09/2021, 04:38:25 PM
    Author     : Alumno
--%>

<%@page import="soft.cise.modeloDao.metProduc"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="soft.cise.modeloDTO.productoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/jspfTienda/cStylos.jspf" %>
        <title>Bebelú</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspfTienda/nav.jspf" %>
        <%@include file="WEB-INF/jspfTienda/header-tienda.jspf" %>
        <section id="barraNavegacion">
            <div class="container">
                <div class="menuopciones">
                    <ul>
                        <%
                            if (sesion.getAttribute("nombre") !=null && sesion.getAttribute("perfil").equals("admin")) {
                        %>
                        <li><a class="btn btn-warning" href="sistema.jsp">Regresar al Sistema</a></li>
                            <%}%>
                        
                        <%
                            if (sesion.getAttribute("nombre") !=null && sesion.getAttribute("perfil").equals("trabajador")) {
                        %>
                        <li><a class="btn btn-warning" href="sistema.jsp">Regresar al Sistema</a></li>
                            <%}%> 
          
                        <li><a href="index.jsp">Inicio</a></li>
                        <li><a href="#">Mas Productos</a></li>
                        <li><a href="#">Carrito</a></li>
                        <li style="float: right"><input class="form-control" id="myInput" type="text" placeholder="Search.."></li>
                    </ul>
                </div>
            </div>
        </section>
        <section>
            <div class="contenido">
                <div class="container">
                    <div class="seccionIzquierda">
                        <div class="">
                            <ul>
                                <li><a href="#">Todos</a></li>
                                <li><a href="#">Niñas</a></li>
                                <li><a href="#">Niños</a></li>
                                <li><a href="#">Bebes</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="seccionDerecha">
                        <div id="SearchPrenda">
                            <div class="row">
                                <%
                                    metProduc metPr = new metProduc();
                                    ArrayList<productoDTO> lis3 = metPr.listProduc12();
                                    Iterator<productoDTO> iter3 = lis3.iterator();
                                    soft.cise.modeloDTO.productoDTO produc = new soft.cise.modeloDTO.productoDTO();
                                    int con3 = 0;
                                    while (iter3.hasNext()) {
                                        produc = iter3.next();
                                        con3++;
                                %>
                                <div class="col-md-4">
                                    <div class="card">
                                        <div class="imgEstilo">
                                            <img class="card-img-top" src="<%=request.getContextPath()%>/comcatalogo.do?txtAccion=imagen&id=<%=produc.getIdProducto()%>">
                                            <figcaption>
                                                <h2><%=produc.getNombProducto()%></h2>
                                                <p><%=produc.getDescripcion()%></p>
                                                <h2>Precio: S/<%=produc.getPrecioVenta()%></h2>
                                                <a href="#"></a>
                                            </figcaption>			
                                        </div>
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-6">
                                                    <a href="<%=request.getContextPath()%>/comcatalogo.do?txtAccion=productoDescrip&id=<%=produc.getIdProducto()%>" class="btn btn-warning btn-block"><i class="fas fa-plus-circle"></i></a>
                                                </div>
                                                <div class="col-6">
                                                    <a class="btn btn-primary btn-block" ><i class="fas fa-cart-plus"></i></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <% }%>
                            </div>
                        </div>
                        <a href="#" class="btn btn-warning">Ver Mas Productos</a>
                    </div>
                </div>
            </div>
        </section>
        <%@include file="WEB-INF/jspfTienda/cfooter.jspf" %>
        <!--JavasScrip-Jquery-Bootstrap-->
        <%@include file="WEB-INF/jspfTienda/cJavaScrip.jspf" %>
    </body>
</html>
