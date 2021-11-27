<%-- 
    Document   : administrador
    Created on : 23/09/2021, 04:38:25 PM
    Author     : Alumno
--%>

<%@page import="soft.cise.modeloDao.metProduc"%>
<%@page import="soft.cise.modeloDTO.productoDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!--Bootstrap-->
        <%@include file="../WEB-INF/jspfAdmin/cStylos.jspf" %>

        <title>Administrador</title>
    </head>
    <body>
        <%@include file="../WEB-INF/jspfAdmin/menu-lateral.jspf" %>
        <section id="navcont" class="activa">
            <!--Barra de navegacion-->
            <%@include file="../WEB-INF/jspfAdmin/nav-admin.jspf" %>
            <!--Contenido-->
            <!--Contenido-->
            <div class="container-fluid" style="padding: 30px 10px;">
                <div class="addProducto">                     
                    <!--Listado de productos guardados-->    
                    <div class="card cardespa">
                        <div class="card-header">
                            <div class="row">
                                <div class="col-7">
                                    <h5>Lista de Productos</h5>
                                </div>
                                <div class="col-5">
                                    <input class="form-control" id="myInput" type="text" placeholder="Search..">
                                </div>
                            </div>
                        </div>
                        <div class="card-body">                
                            <table class="table table-bordered table-hover">
                                <thead class="table-primary" align="center">
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Categoria</th>
                                        <th scope="col">Marca</th>
                                        <th scope="col">Cantidad</th>
                                        <th scope="col">Precio Compra</th>
                                        <th scope="col">Precio Venta</th>
                                        <th scope="col">Opciones</th>
                                    </tr>
                                </thead>
                                <tbody id="myTable" >
                                    <%                                        metProduc metPr = new metProduc();
                                        ArrayList<productoDTO> lis3 = metPr.sql_selectAll();
                                        Iterator<productoDTO> iter3 = lis3.iterator();
                                        productoDTO productodto = new productoDTO();
                                        int con1 = 0;
                                        while (iter3.hasNext()) {
                                            productodto = iter3.next();
                                            con1++;
                                    %>
                                    <tr>
                                        <th align="center" scope="row"><%=con1%></th>
                                        <td><%=productodto.getNombProducto()%></td>
                                        <td><%=productodto.getCategoria()%></td>
                                        <td><%=productodto.getMarca()%></td>
                                        <td><%=productodto.getCantidad()%></td>
                                        <td>S/.<%=productodto.getPrecioCompra()%></td>
                                        <td>S/.<%=productodto.getPrecioVenta()%></td>
                                        <td align="center">
                                            <a class="btn btn-warning btn-sm" href="<%=request.getContextPath()%>/comproducto.do?txtAccion=updateProducto&id=<%=productodto.getIdProducto()%>"><i class="far fa-edit"></i></a>
                                            <a class="btn btn-danger btn-sm" href="<%=request.getContextPath()%>/comproducto.do?txtAccion=delete2&id=<%=productodto.getIdProducto()%>"><i class="far fa-trash-alt"></i></a>
                                        </td>
                                    </tr>
                                    <% }%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <%@include file="../WEB-INF/jspfAdmin/cJavaScrip.jspf"%>
    </body>
</html>
