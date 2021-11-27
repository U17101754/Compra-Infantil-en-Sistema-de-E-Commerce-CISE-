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
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card cardespa">     
                                <div class="card-header">
                                    <h5><i class="fab fa-product-hunt"></i>&nbsp;&nbsp;Agregar Productos</h5>
                                </div>
                                <form class="card-body bg-white" action="<%=request.getContextPath()%>/comproducto.do" method="post" enctype="multipart/form-data" autocomplete="off">
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="txtProducto" placeholder="Nombre Producto">
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="txtCantidad" placeholder="cantidad de productos">
                                            </div>
                                            <div class="form-group">
                                                <select class="form-control" name="txtMoneda">
                                                    <option>Moneda de compra</option>
                                                    <option value="1">Dolares</option>
                                                    <option value="2">Soles</option>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="txtPrecioCompra" placeholder="Precio Compra">
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="txtTipoCambio" placeholder="Tipo de Cambio">
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="txtPrecioVenta" placeholder="Precio Venta del Producto">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="txtIGV" placeholder="IGV">                                         
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="txtProveedor" placeholder="Nombre Proveedor">                                         
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="txtTalla1" placeholder="Talla1">
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="txtTalla2" placeholder="Talla2">
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="txtTalla3" placeholder="Talla3">
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="txtTalla4" placeholder="Talla4">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <select class="form-control" name="txtCategoria">
                                                    <%
                                                        metProduc metCategoria = new metProduc();
                                                        List<productoDTO> lis2 = metCategoria.listarCateg();
                                                        Iterator<productoDTO> iter2 = lis2.iterator();
                                                        productoDTO productodto = new productoDTO();
                                                        int con2 = 0;
                                                        while (iter2.hasNext()) {
                                                            productodto = iter2.next();
                                                            con2++;

                                                    %>
                                                    <option value="<%=con2%>"><%=productodto.getCategoria()%></option>
                                                    <% }%>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control" type="text" name="txtModelo" placeholder="Modelo">
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleFormControlTextarea1" >Descripcion</label>
                                                <textarea class="form-control" name="txtDescripcion" ></textarea>
                                            </div>
                                            <div class="form-group">
                                                <input type="file" class="form-control-file" name="txtImgProducto">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <a class="btn btn-success btn-block" href="sistema.jsp"><i class="fas fa-arrow-left"></i> Cancelar</a>
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <input type="submit" name="txtAccion" id="chkAceptar" value="agregar" class="btn btn-info btn-block">
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div>                            
                        <!--Listado de productos guardados-->    
                        <div class="card cardespa">
                            <div class="card-header">
                                <h5>Ultimos Productos Agregados</h5>
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
                                            <th scope="col">Total Compra</th>
                                            <th scope="col">Opciones</th>
                                        </tr>
                                    </thead>
                                    <tbody class="">
                                        <%
                                            metProduc metPr = new metProduc();
                                            ArrayList<productoDTO> lis3 = metPr.listProduc12();
                                            Iterator<productoDTO> iter3 = lis3.iterator();
                                            int con3 = 0;
                                            while (iter3.hasNext()) {
                                                productodto = iter3.next();
                                                con3++;

                                        %>
                                        <tr>
                                            <th align="center" scope="row"><%=con3%></th>
                                            <td><%=productodto.getNombProducto()%></td>
                                            <td><%=productodto.getCategoria()%></td>
                                            <td><%=productodto.getCantidad()%></td>
                                            <td><%=productodto.getMarca()%></td>
                                            <td>S/.<%=productodto.getPrecioCompra()%></td>
                                            <td align="center">
                                                <a class="btn btn-warning btn-sm" href="<%=request.getContextPath()%>/comproducto.do?txtAccion=updateProducto&id=<%=productodto.getIdProducto()%>"><i class="far fa-edit"></i></a>
                                                <a class="btn btn-danger btn-sm" href="<%=request.getContextPath()%>/comproducto.do?txtAccion=delete1&id=<%=productodto.getIdProducto()%>"><i class="far fa-trash-alt"></i></a>
                                            </td>
                                        </tr>
                                        <% }%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <%@include file="../WEB-INF/jspfAdmin/cJavaScrip.jspf"%>
    </body>
</html>
