<%-- 
    Document   : carrito
    Created on : 23/09/2021, 04:38:25 PM
    Author     : Alumno
--%>
<%@page import="java.util.Iterator"%>
<%@page import="soft.cise.modeloDTO.productoDTO"%>
<%@page import="soft.cise.modeloDao.metProduc"%>
<%@page import="soft.cise.controlador.comProducto"%>
<%@page import="soft.cise.modeloDTO.articuloDTO"%>
<%@page import="java.util.ArrayList"%>
<%
    HttpSession sesion = request.getSession();
    ArrayList<articuloDTO> articulos = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");

%>
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
                    <div class="card cardoff">
                        <div class="card-header">
                            Productos seleccionados
                        </div>
                        <div class="card-body">
                            <table class="table table-bordered table-hover">
                                <thead class="table-primary" align="center">
                                    <tr>
                                        <th>Imagen</th>
                                        <th>Nombre</th>
                                        <th>Cantidad</th>
                                        <th>Precio</th>
                                        <th>Total</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%  metProduc metp = new metProduc();
                                        double total = 0;
                                        double costoEnvio = 0;
                                        double IGV = 0;
                                        if (articulos != null) {
                                            for (articuloDTO a : articulos) {
                                                productoDTO producto = metp.sql_selectById(a.getIdProducto());
                                                total += a.getCantidad() * producto.getPrecioVenta();
                                                costoEnvio += total / 70;
                                                IGV += producto.getIGV();

                                    %>
                                    <tr>
                                        <td><img src="comcatalogo.do?txtAccion=imagen&id=<%=a.getIdProducto()%>" class="card-img-top" style="width: 100px;"/></td>
                                        <td><%=producto.getNombProducto()%></td>
                                        <td><%=a.getCantidad()%></td>
                                        <td><%=producto.getPrecioVenta()%></td>
                                        <td><%=Math.round(producto.getPrecioVenta() * a.getCantidad() * 100.0) / 100.0%></td>
                                        <td align="center" >
                                            <span id="idArticulo" style="display: none;"><%=a.getIdProducto()%></span>
                                            <span id="nombreArticulo" style="display: none;"><%=producto.getNombProducto()%></span>
                                            <a class="btn btn-warning btn-sm" type="submit" href="" id="deleteItem"><i class="fa fa-times"></i></a>
                                        </td>
                                    </tr>
                                    <%}
                                        }%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="espacio"></div>

                    <a class="btn btn-warning" href="javascript:window.history.go(-2)">Seguir Comprando</a>
                    <div class="espacio"></div>
                    <form action="<%=request.getContextPath()%>/comcatalogo.do?txtAccion=Comprar" method="POST">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="card">
                                    <div class="card-header">
                                        Datos del Cliente
                                    </div>
                                    <div class="card-body">
                                        <% metProduc metp1 = new metProduc();
                                            int productoCon = 0;
                                            if (articulos != null) {
                                                for (articuloDTO a : articulos) {
                                                    productoCon += 1;
                                        %>
                                        <input type="text" name="txtId<%=productoCon%>" value="<%=a.getIdProducto()%>">
                                        <input type="hidden" name="txtCantidad<%=productoCon%>" value="<%=a.getCantidad()%>">

                                        <% }
                                            }%>
                                            <input type="text" name="idUsuario" value="<%=session.getAttribute("idUsuario") %>">
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-4">
                                                    <label>Nombre Completo</label>
                                                </div>
                                                <div class="col-md-8">
                                                    <input class="form-control" type="text" name="txtNombreCliente">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-4">
                                                    <label>DNI</label>
                                                </div>
                                                <div class="col-md-8">
                                                    <input class="form-control" type="text" name="txtDni">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-4">
                                                    <label>Telefono 1</label>
                                                </div>
                                                <div class="col-md-8">
                                                    <input class="form-control" type="text" name="txtTelefono1">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-4">
                                                    <label>Telefono 2</label>
                                                </div>
                                                <div class="col-md-8">
                                                    <input class="form-control" type="text" name="txtTelefono2">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-4">
                                                    <label>Departamento</label>
                                                </div>
                                                <div class="col-md-8">
                                                    <input class="form-control" type="text" name="txtDepartamento">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-4">
                                                    <label>Provincia</label>
                                                </div>
                                                <div class="col-md-8">
                                                    <input class="form-control" type="text" name="txtProvincia">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-4">
                                                    <label>Distrito</label>
                                                </div>
                                                <div class="col-md-8">
                                                    <input class="form-control" type="text" name="txtDistrito">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-4">
                                                    <label>Direccion</label>
                                                </div>
                                                <div class="col-md-8">
                                                    <input class="form-control" type="text" name="txtDireccion">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>    
                            <div class="col-md-6">
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-4">
                                            <br>
                                            <spam style="border-bottom: 1px solid #000;">Datos de la compra</spam>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-4">
                                            <spam>Total producto</spam>
                                        </div>
                                        <div class="col-md-8">
                                            <input class="form-control" id="txtSubtotal" name="txtTotalProducto" value="<%=Math.round(total * 100.0) / 100.0%>" type="text">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-4">
                                            <spam>Costo de Envio</spam>
                                        </div>
                                        <div class="col-md-8">
                                            <input class="form-control" id="txtSubtotal2" name="txtCostoEnvio" type="text" value="<%=Math.round(costoEnvio * 100.0) / 100.0%>" >
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-4">
                                            <spam>IGV</spam>
                                        </div>
                                        <div class="col-md-8">
                                            <input class="form-control" name="txtIGV" type="text" value="<%=Math.round(IGV * 100.0) / 100.0%>" >
                                        </div>
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-4">
                                            <spam>Total a pagar</spam>
                                        </div>
                                        <div class="col-md-8">
                                            <input class="form-control" name="txtTotalPago" type="text" value="<%=Math.round((total + IGV + costoEnvio) * 100.0) / 100.0%>" >
                                        </div>
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-4">
                                            <br>
                                            <spam style="border-bottom: 1px solid #000;">Pago</spam>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-md-4">
                                            <spam>Paga con</spam>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="menuPago">
                                                <ul>
                                                    <li><input type="radio" name="txtMedioPago" value="mastercard"><i class="fab fa-cc-mastercard"></i></li>
                                                    <li><input type="radio" name="txtMedioPago" value="paypal"><i class="fab fa-cc-paypal"></i></li>
                                                    <li><input type="radio" name="txtMedioPago" value="visa"><i class="fab fa-cc-visa"></i></li>
                                                </ul>
                                            </div>      
                                        </div>
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-4">
                                            <spam>Cuenta</spam>
                                        </div>
                                        <div class="col-md-8">
                                            <input class="form-control" name="txtCuenta" type="text">
                                        </div>
                                    </div> 
                                </div>
                                <input type="submit" class="btn btn-primary btn-block" value="Comprar">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>

        <%@include file="../WEB-INF/jspfTienda/cfooter.jspf" %>


        <!--JavasScrip-Jquery-Bootstrap-->
        <%@include file="../WEB-INF/jspfTienda/cJavaScrip.jspf" %>
    </body>
</html>



