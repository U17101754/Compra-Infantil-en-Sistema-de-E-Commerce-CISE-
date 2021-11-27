<%-- 
    Document   : productoDescripcion
    Created on : 23/09/2021, 04:38:25 PM
    Author     : Alumno
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="soft.cise.modeloDTO.productoDTO"%>
<%@page import="soft.cise.modeloDao.metProduc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../WEB-INF/jspfTienda/cStylos.jspf" %>
        <link href="resource/css/allproduct.css" rel="stylesheet" type="text/css"/>
        <title>Bebelú</title>
    </head>
    <body>
        <%@include file="../WEB-INF/jspfTienda/nav.jspf" %>
        <%
            metProduc metp = new metProduc();
            int id = Integer.parseInt((String) request.getAttribute("id"));
            productoDTO produc = metp.sql_selectById(id);

        %>
        <div class="espacio"></div>
        <section id="barraNavegacion">
            <div class="container">
                <div class="menuopciones">
                    <ul>
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
                        <div class="row">
                            <div class="col-md-5">
                                <div class="card cardoff">
                                    <img src="comcatalogo.do?txtAccion=imagen&id=<%=id%>" class="card-img-top" alt=""/>
                                </div>
                            </div>
                            <div class="col-md-7">
                                <div class="card cardoff">
                                    <form action="comcatalogo.do" method="post">
                                    <div class="card-body">
                                        <h5>Nombre: <%=produc.getNombProducto()%></h5>
                                        <label>Codigo del Producto: <%=id%></label><br>
                                        <label>Precio: S/<%=produc.getPrecioVenta()%></label><br>
                                        <input type="hidden" name="id" value="<%=id %>">
                                        <label>Cantidad: </label><input style="height: 30px;width: 50px;" type="text" id="txtCantidad" name="txtCantidad" value="1" autocomplete="off">
                                        <input type="submit" class="btn btn-warning" name="txtAccion" value="Agregar CArrito">
                                        <label>Disponibilidad:Stock =<%=produc.getCantidad()%></label><br>
                                        <label>Condicion:nuevo</label><br>
                                        <label>Marca: <%=produc.getMarca()%></label>
                                    </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!--Mas productos-->
                        <div class="espacio"></div>
                        <div>
                            <h3>Mas Productos</h3>
                        </div>
                        <div id="SearchPrenda">
                            <div class="row">
                                <%
                                    soft.cise.modeloDao.metProduc metPr = new soft.cise.modeloDao.metProduc();
                                    ArrayList<productoDTO> lis3 = metPr.listProduc12();
                                    Iterator<productoDTO> iter3 = lis3.iterator();
                                    soft.cise.modeloDTO.productoDTO produc1 = new soft.cise.modeloDTO.productoDTO();
                                    int con3 = 0;
                                    while (iter3.hasNext()) {
                                        produc1 = iter3.next();

                                %>
                                <div class="col-md-4">
                                    <div class="card">
                                        <div class="imgEstilo">
                                            <img class="card-img-top" src="<%=request.getContextPath()%>/comcatalogo.do?txtAccion=imagen&id=<%=produc1.getIdProducto()%>">
                                            <figcaption>
                                                <h2><%=produc1.getNombProducto()%></h2>
                                                <p><%=produc1.getDescripcion()%></p>
                                                <h2>Precio: S/<%=produc1.getPrecioVenta()%></h2>
                                                <a href="#"></a>
                                            </figcaption>			
                                        </div>
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-6">
                                                    <a href="<%=request.getContextPath()%>/comcatalogo.do?txtAccion=productoDescrip&id=<%=produc1.getIdProducto()%>" class="btn btn-warning btn-block"><i class="fas fa-plus-circle"></i></a>
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
                        <div class="espacio"></div>
                    </div>
                </div>
            </div>
        </section>

        <%@include file="../WEB-INF/jspfTienda/cfooter.jspf" %>


        <!--JavasScrip-Jquery-Bootstrap-->
        <%@include file="../WEB-INF/jspfTienda/cJavaScrip.jspf" %>
    </body>
</html>
