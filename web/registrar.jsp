<%-- 
    Document   : registrar
    Created on : 23/09/2021, 04:38:25 PM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/jspfTienda/cStylos.jspf" %>

        <link href="resource/css/login.css" rel="stylesheet" type="text/css"/>
        <!--Google fonts-->

        <title>Registro</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspfTienda/nav.jspf" %>
        <section>
            <div style="padding-top: 150px; padding-bottom: 150px;">
                <div class="row justify-content-center">
                    <div class="col-md-5">
                        <div class="card">
                            <div class="card-header">
                                <h5 align="center">Registrar Usuarios</h5>
                            </div>
                            <form class="card-body" action="<%=request.getContextPath()%>/conusuario.do" method="post">
                                <div class="form-group">
                                    <input class="form-control" type="text" name="txtNombre" placeholder="nombre completo">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="email" name="txtCorreo" placeholder="correo">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="password" name="txtPass" placeholder="Contraseña">
                                </div>
                                <input type="hidden" name="txtPerfil" value="cliente">
                                <input type="submit" class="btn btn-primary btn-block" name="txtAccion" value="Registrar">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <%@include file="WEB-INF/jspfTienda/cfooter.jspf" %>
        <!--Scrip-->
        <%@include file="WEB-INF/jspfTienda/cJavaScrip.jspf" %>
    </body>
</html>

