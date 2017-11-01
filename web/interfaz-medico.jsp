<%-- 
    Document   : interfaz-medico
    Created on : Oct 30, 2017, 11:01:54 PM
    Author     : Andres Ramos
--%>

<%@page import="Ciudad.ModeloCiudad"%>
<%@page import="Ciudad.Ciudad"%>
<%@page import="Paciente.ModeloPaciente"%>
<%@page import="Paciente.Paciente"%>
<%@page import="Examen.ModeloExamen"%>
<%@page import="Examen.Examen"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Examen> examenes = new ModeloExamen().obtenerExamenesDB(); %>
<% List<Paciente> pacientes = new ModeloPaciente().obtenerPacientesDB(); %>
<% List<Ciudad> ciudades = new ModeloCiudad().getCiudades(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro remisión</title>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-grid.css" type="text/css"/>
    </head>
    <body>
        <nav class="navbar fixed-top navbar-dark bg-primary">
            <a class="navbar-brand" href="index.jsp">Registro remisión</a>
        </nav>

        <br>
        <br>
        <br>
        <div class="container">
            <h2 class="text-center">LISTADO EXAMENES Y PACIENTES</h2>
            <br>
            <form action="ControladorRemision" method="post">
                <input type="hidden" name="instruccion" value="insertar"/>
                <div class="row">
                    <div class="col-sm-6">
                        <div class="card">
                            <h4 class="card-header">Exámenes</h4>
                        </div>
                        <br>
                        <div class="list-group">
                            <% for (Examen examen : examenes) {%>
                            <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                                <div class="d-flex w-100 justify-content-between">
                                    <h5 class="mb-1"><%= examen.getNombre()%></h5>
                                    <div class="checkbox">
                                        <label><input type="radio" name="examen" value="<%= examen.getId() %>"></label>
                                    </div>
                                </div>
                                <p class="mb-1"><%= examen.getDescripcion()%></p>
                            </a>
                            <% }%>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="card">
                            <h4 class="card-header">Pacientes</h4>
                        </div>
                        <br>
                        <div class="list-group">
                            <% for (Paciente paciente : pacientes) {%>
                            <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                                <div class="d-flex w-100 justify-content-between">
                                    <h5 class="mb-1"><%= paciente.getNombres() + " " + paciente.getApellidos()%></h5>
                                    <div class="radio">
                                        <label><input type="radio" name="paciente" value="<%= paciente.getId() %>"></label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm">
                                        <p class="mb-1"><div class="text-danger">Dirección residencia </div><%= paciente.getDireccion()%></p>
                                        <% for (Ciudad ciudad : ciudades) { %>
                                        <%  if (ciudad.getId() == paciente.getIdCiudad()) {%>
                                        <p class="mb-1"><div class="text-danger">Ciudad </div><%= ciudad.getCiudad()%></p>
                                        <%  } %>
                                        <% }%>
                                    </div>
                                    <div class="col-sm">
                                        <p class="mb-1"><div class="text-danger">Identificación </div><%= paciente.getIdentificacion()%></p>
                                    </div>
                                </div>
                                <small><%= paciente.getUsuario()%></small>
                            </a>
                            <% }%>
                        </div>
                    </div>
                </div>
                <br>
                <button type="submit" class="btn btn-primary btn-lg btn-block">Finalizar remisión</button>
            </form>
        </div>

        <br>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
