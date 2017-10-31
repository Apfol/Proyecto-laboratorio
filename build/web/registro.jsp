<%-- 
    Document   : registro
    Created on : Oct 30, 2017, 6:33:47 PM
    Author     : Andres Ramos
--%>

<%@page import="Usuario.Usuario"%>
<%@page import="Ciudad.ModeloCiudad"%>
<%@page import="Ciudad.Ciudad"%>
<%@page import="Genero.ModeloGenero"%>
<%@page import="Genero.Genero"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% int usuario = Integer.parseInt(request.getParameter("usuario"));%>
<% List<Genero> generos = new ModeloGenero().getGeneros(); %>
<% List<Ciudad> ciudades = new ModeloCiudad().getCiudades(); %>
<%
    String controlador = "";
    switch (usuario) {
        case Usuario.MEDICO:
            controlador = "ControladorMedico";
            break;
        case Usuario.BACTERIOLOGO:
            controlador = "ControladorBacteriologo";
            break;
        case Usuario.PACIENTE:
            controlador = "ControladorPaciente";
            break;
    }
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <% if (usuario == Usuario.MEDICO) { %>
        <title>Registro médico</title>
        <% } else if (usuario == Usuario.BACTERIOLOGO) {%>
        <title>Registro bacterióloga</title>
        <% } else if (usuario == Usuario.PACIENTE) {%>
        <title>Registro paciente</title>
        <% } %>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-grid.css" type="text/css"/>

    </head>

    <body class="bg-light">
        <nav class="navbar navbar-dark bg-primary">
            <a class="navbar-brand" href="index.jsp">Navbar</a>
        </nav>
        <br><br>
        <div class="container">
            <div class="row justify-content-center align-items-center">
                <div class="col align-self-center">
                    <% if (usuario == Usuario.MEDICO) { %>
                    <h1>Registro médico</h1>
                    <% } else if (usuario == Usuario.BACTERIOLOGO) {%>
                    <h1>Registro bacterióloga</h1>
                    <% } else if (usuario == Usuario.PACIENTE) {%>
                    <h1>Registro paciente</h1>
                    <% }%>
                    <br>
                    <form action="<%= controlador%>" method="post">
                        <input type="hidden" name="instruccion" value="insertar"/>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="nombres">Nombres</label>
                                <input type="text" name="nombres" class="form-control" id="nombres" placeholder="Nombres">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="apellidos">Apellidos</label>
                                <input type="text" name="apellidos" class="form-control" id="apellidos" placeholder="Apellidos">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="usuario">Usuario</label>
                                <input type="text" name="usuario" class="form-control" id="correo" placeholder="Usuario">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="contraseña">Contraseña</label>
                                <input type="password" name="password" class="form-control" id="contraseña" placeholder="Contraseña">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="ciudad">Ciudad</label>
                                <select id="ciudad" name="ciudad" class="form-control">
                                    <option selected>Choose...</option>
                                    <<% for (Ciudad c : ciudades) {%>
                                    <option value="<%= c.getId()%>"><%= c.getCiudad()%></option>
                                    <% }%>
                                </select>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="identificacion">Identificación</label>
                                <input type="number" name="identificacion" class="form-control" id="identificacion" placeholder="Identificación">
                            </div>
                            <% if (usuario == Usuario.MEDICO) { %>
                            <div class="form-group col-md-2">
                                <label for="telefono">Teléfono</label>
                                <input type="number" name="telefono" class="form-control" id="telefono" placeholder="Teléfono">
                            </div>
                            <div class="form-group col-md-2">
                                <label for="registros">N° registros</label>
                                <input type="number" name="registros" class="form-control" id="registros" placeholder="N° registros">
                            </div>
                            <% } else if (usuario == Usuario.PACIENTE) { %>
                            <div class="form-group col-md-2">
                                <label for="telefono">Teléfono</label>
                                <input type="number" name="telefono" class="form-control" id="telefono" placeholder="Teléfono">
                            </div>
                            <div class="form-group col-md-2">
                                <label for="direccion">Dirección casa</label>
                                <input type="text" name="direccion" class="form-control" id="direccion" placeholder="Dirección casa">
                            </div>
                            <% } else if (usuario == Usuario.BACTERIOLOGO) { %>
                            <div class="form-group col-md-4">
                                <label for="telefono">Teléfono</label>
                                <input type="number" name="telefono" class="form-control" id="telefono" placeholder="Teléfono">
                            </div>
                            <% } %>
                            <div class="form-group col-md-2">
                                <label for="genero">Genéro</label>
                                <select id="genero" name="genero" class="form-control">
                                    <option selected>Choose...</option>
                                    <% for (Genero g : generos) {%>
                                    <option value="<%= g.getId()%>"><%= g.getGenero()%></option>
                                    <% }%>
                                </select>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Registrar</button>
                    </form>
                </div>
            </div>
        </div>


        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>

</html>

