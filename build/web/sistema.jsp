<%-- 
    Document   : sistema
     Created on : 23/09/2021, 04:38:25 PM
    Author     : Alumno
--%>
<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!--Bootstrap-->
        <%@include file="WEB-INF/jspfAdmin/cStylos.jspf" %>
        <!--CSS-->
        <title>Administrador</title>
    </head>
    <body>
        <%
           /* HttpSession sessionOk = request.getSession();
            String usuario = "";

            if (sessionOk.getAttribute("nombre") != null && sessionOk.getAttribute("perfil").equals("admin") || sessionOk.getAttribute("perfil").equals("trabajador")) {
                usuario = sessionOk.getAttribute("nombre").toString();
            } else if (sessionOk.getAttribute("nombre") != null && sessionOk.getAttribute("perfil").equals("cliente")) {
                out.print("<script>location.replace('index.jsp');</script>");
            } else {
                out.print("<script>location.replace('login.jsp');</script>");
            }*/
        %>
        <%@include file="WEB-INF/jspfAdmin/menu-lateral.jspf" %>
        <section id="navcont" class="activa">
            <!--Barra de navegacion-->
            <%@include file="WEB-INF/jspfAdmin/nav-admin.jspf" %>
            <!--Contenido-->
            <div class="container-fluid" style="padding: 30px 10px;">
                <div class="sistema">
                    <div class="row">
                        <div class="col-lg-2 col-md-4 col-sm-6">
                            <div class="card cardespa">
                                <div class="card-body">
                                    <a class="iconoCar" href="#"><i class="fas fa-users-cog"></i></a>
                                    <h5 class="text1">admin</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-2 col-md-4 col-sm-6">

                            <div class="card cardespa">
                                <div class="card-body">
                                    <a class="iconoCar" href="<%=request.getContextPath()%>/comproducto.do?txtAccion=addProducto"><i class="fas fa-plus-square"></i></a>
                                    <h5 class="text1">Agregar Producto</h5>
                                </div>
                            </div>

                        </div>  
                        <div class="col-lg-2 col-md-4 col-sm-6">

                            <div class="card cardespa">
                                <div class="card-body">
                                    <a class="iconoCar" href="<%=request.getContextPath()%>/comproducto.do?txtAccion=listProducto"><i class="far fa-edit"></i></a>
                                    <h5 class="text1">Editar Productos</h5>
                                </div>
                            </div>

                        </div>
                        <div class="col-lg-2 col-md-4 col-sm-6">

                            <div class="card cardespa">
                                <div class="card-body">
                                    <a class="iconoCar" href="<%=request.getContextPath()%>/comproducto.do?txtAccion=venta"><i class="fas fa-file-export"></i></a>
                                    <h5 class="text1">Ventas</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-2 col-md-4 col-sm-6">

                            <div class="card cardespa">
                                <div class="card-body">
                                    <a class="iconoCar" href="<%=request.getContextPath()%>/conreportes.do?txtAccion=reportes"><i class="far fa-file-alt"></i></a>
                                    <h5 class="text1">Reportes</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <%@include file="WEB-INF/jspfAdmin/cJavaScrip.jspf"%>
    </body>
</html>
