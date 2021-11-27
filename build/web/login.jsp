<%-- 
    Document   : login
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

        <title>Login</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspfTienda/nav.jspf" %>
        <section id="loginSeccion">
            <div class="contenido">
                <div class="fondoSeccion">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-md-6">
                                <div class="colorLogin">
                                    <div class="contCard">
                                        <div class="card">
                                            <div class="card-header">
                                                <h5 align="center">Inicio Sesión</h5>
                                            </div>
                                            <form class="card-body" action="<%=request.getContextPath()%>/conusuario.do" method="post">
                                                <div class="col-md-12 mb-3">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                            <span class="input-group-text">
                                                                <i class="fas fa-user-alt"></i>
                                                            </span>
                                                        </div>
                                                        <input type="text" class="form-control" name="txtCorreo" placeholder="Username">
                                                    </div>
                                                </div>
                                                <div class="col-md-12 mb-3">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                            <span class="input-group-text">
                                                                <i class="fas fa-unlock-alt"></i>
                                                            </span>
                                                        </div>
                                                        <input type="password" class="form-control" name="txtClave" placeholder="password">
                                                    </div>
                                                </div>
                                                <div class="col-md-12 mb-3">
                                                    <input type="submit" name="txtAccion" value="Ingresar" class="btn btn-primary btn-block">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                    <div align="center">
                                        <small>Aun no tienes Cuenta?</small><br>
                                        <a href="#" style="color: #000;">Registrate aquí</a>
                                    </div>
                                </div>
                            </div>
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
