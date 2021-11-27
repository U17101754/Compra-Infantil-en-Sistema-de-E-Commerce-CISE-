<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : administrador
    Created on : 23/09/2021, 04:38:25 PM
    Author     : Alumno
--%>
<%@page import="soft.cise.modeloDTO.compraDTO"%>
<%@page import="soft.cise.modeloDao.ventaProductosDAO"%>
<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% int idVenta = Integer.parseInt((String) request.getAttribute("idVenta"));%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!--Bootstrap-->
        <%@include file="../../WEB-INF/jspfAdmin/cStylos.jspf" %>
        <!--CSS-->
        <title>Administrador</title>
    </head>
    <body>
        <%@include file="../../WEB-INF/jspfAdmin/menu-lateral.jspf" %>
        <section id="navcont" class="activa">
            <!--Barra de navegacion-->
            <%@include file="../../WEB-INF/jspfAdmin/nav-admin.jspf" %>
            <!--Contenido-->
            <div class="container-fluid" style="padding: 30px 10px;">
                <div class="sistema">
                    <div class="addProducto">                     
                        <!--Listado de productos guardados-->    
                        <div class="card cardespa">
                            <div class="card-header">
                                <div class="row">
                                    <div class="col-7">
                                        <h5>Detalle Venta</h5>
                                    </div>
                                </div>
                            </div>
                            <form class="card-body" action="<%=request.getContextPath()%>/comproducto.do" method="post">
                                <%
                                    ventaProductosDAO ventaproductodao = new ventaProductosDAO();
                                    compraDTO compradto = ventaproductodao.sql_detalleVentaProducto1(idVenta);
                                %>
                                <div class="row">
                                    <input type="hidden" name="txtIdVenta" value="<%=compradto.getIdVenta()%>"> 
                                    <div class="col-4">
                                        <div class="form-group">
                                            <label>Nombre Cliente</label>
                                            <input class="form-control" value="<%=compradto.getNombreCompleto()%>" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="col-4">
                                        <label>Destino Producto</label>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="<%=compradto.getDestino()%>" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="col-4">
                                        <label>Direccion</label>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="<%=compradto.getDireccion()%>" readonly="readonly">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <% if (compradto.getEstado().equals("entregado")) {%>
                                    <div class="col-3">
                                        <div class="form-group">
                                            <label>Fecha Compra</label>
                                            <input class="form-control" value="<%=compradto.getFechaVenta()%>" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="col-3">
                                        <label>Estado del envio</label>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="<%=compradto.getEstado()%>" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="col-3">
                                        <label>Cuenta de Pago</label>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="<%=compradto.getCuenta()%>" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="col-3">
                                        <label>Fecha Entrega</label>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="<%=compradto.getFechaEntrega()%>" readonly="readonly">
                                        </div>
                                    </div>
                                    <% } else {%>
                                    <div class="col-4">
                                        <div class="form-group">
                                            <label>Fecha Compra</label>
                                            <input class="form-control" value="<%=compradto.getFechaVenta()%>" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="col-4">
                                        <label>Estado del envio</label>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="<%=compradto.getEstado()%>" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="col-4">
                                        <label>Cuenta de Pago</label>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="<%=compradto.getCuenta()%>" readonly="readonly">
                                        </div>
                                    </div>



                                    <% } %>
                                </div>
                                <div class="row">
                                    <div class="col-3">
                                        <div class="form-group">
                                            <label>Cambiar estado del envio</label>
                                            <%
                                                if (compradto.getEstado().equals("pendiente")) {


                                            %>
                                            <select class="form-control" name="txtEstado">
                                                <option value="pendiente">pendiente</option>
                                                <option value="enviado">enviado</option>
                                            </select>
                                            <% } %>
                                            <%
                                                if (compradto.getEstado().equals("enviado")) {


                                            %>
                                            <select class="form-control" name="txtEstado">
                                                <option value="enviado">enviado</option>
                                                <option value="entregado">entregado</option>
                                            </select>
                                            <% } %>
                                            <%
                                                if (compradto.getEstado().equals("entregado")) {

                                            %>
                                            <input class="form-control" value="desabilitado" readonly="readonly">
                                            <% }%>
                                        </div>
                                    </div>
                                    <div class="col-3">
                                        <label>Total IGV</label>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="S/.<%=compradto.getIGV()%>" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="col-3">
                                        <label>Costo Envio</label>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="S/.<%=compradto.getCostoEnvio()%>" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="col-3">
                                        <label>Total pagado</label>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="S/.<%=compradto.getTotalPagar()%>" readonly="readonly">
                                        </div>
                                    </div>
                                </div>
                                <table class="table table-bordered table-hover">
                                    <thead class="table-primary" align="center">
                                        <tr>
                                            <th scope="col">Foto</th>
                                            <th scope="col">Nombre</th>
                                            <th scope="col">Descripcion</th>
                                            <th scope="col">Cantidad</th>
                                            <th scope="col">IGV Producto</th>
                                            <th scope="col">Precio</th>
                                        </tr>
                                    </thead>
                                    <tbody id="myTable" >
                                        <c:forEach var="listaProducto" items="${sessionScope.listaProducto}">
                                            <tr>
                                                <td><img class="card-img-top" style="width: 80px;" src="<%=request.getContextPath()%>/comcatalogo.do?txtAccion=imagen&id=${listaProducto.idProducto}"></td>
                                                <td>${listaProducto.nombProducto}</td>
                                                <td>${listaProducto.descripcion}</td>
                                                <td>${listaProducto.cantidad}</td>
                                                <td>S/.${listaProducto.IGV}</td>
                                                <td>S/.${listaProducto.totalProducto}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <div class="row">
                                    <%
                                        if (compradto.getEstado().equals("entregado")) {


                                    %>
                                    <div class="col-4">
                                        <a type="submit" class="btn btn-info btn-block" href="<%=request.getContextPath()%>/comproducto.do?txtAccion=Cancelar">Volver a ventas</a>
                                    </div>
                                    <% } else {%>
                                    <div class="col-4">
                                        <input type="submit" class="btn btn-success btn-block" name="txtAccion" value="Cancelar">
                                    </div>
                                    <div class="col-8">
                                        <input type="submit" class="btn btn-primary btn-block" name="txtAccion" value="Guardar">
                                    </div>

                                    <% }%>
                                </div>                               
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <%@include file="../../WEB-INF/jspfAdmin/cJavaScrip.jspf"%>
    </body>
</html>
