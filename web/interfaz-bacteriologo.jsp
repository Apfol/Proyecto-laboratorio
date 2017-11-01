<%-- 
    Document   : interfaz-bacteriologo
    Created on : Oct 30, 2017, 11:28:28 PM
    Author     : Andres Ramos
--%>

<%@page import="Medico.ModeloMedico"%>
<%@page import="Medico.Medico"%>
<%@page import="Paciente.ModeloPaciente"%>
<%@page import="Paciente.Paciente"%>
<%@page import="Remision.ModeloRemision"%>
<%@page import="Remision.Remision"%>
<%@page import="Remision_Examen.ModeloRemision_Examen"%>
<%@page import="Remision_Examen.Remision_Examen"%>
<%@page import="Bacteriologo.ControladorBacteriologo"%>
<%@page import="Bacteriologo.Bacteriologo"%>
<%@page import="java.util.List"%>
<%@page import="Bacteriologo.ModeloBacteriologo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ModeloBacteriologo modeloBacteriologo = new ModeloBacteriologo();
    List<Bacteriologo> bacteriologos = modeloBacteriologo.obtenerBacteriologosDB();
    Bacteriologo bacteriologo = new ControladorBacteriologo().obtenerBacteriologoCookie(bacteriologos, request);

    List<Remision> remisiones = new ModeloRemision().obtenerRemisionesDB();
    List<Paciente> pacientes = new ModeloPaciente().obtenerPacientesDB();
    List<Medico> medicos = new ModeloMedico().obtenerMedicosDB();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-grid.css" type="text/css"/>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-primary">
            <a class="navbar-brand" href="#">Navbar</a>
        </nav>

        <% if (remisiones != null) { %>
        <br>
        <div class="container">
            <div class="row">
                <% for (Remision remision : remisiones) { %>
                <% if (!remision.isRealizada()) { %>
                <div class="col-sm-6">
                    <div class="card text-white bg-info mb-3">
                        <div class="card-body">
                            <% for (Paciente paciente : pacientes) { %>
                            <%  if (paciente.getId() == remision.getIdPaciente()) {%>
                            <h4 class="card-title"><%= paciente.getNombres() + " " + paciente.getApellidos()%></h4>
                            <%  } %>
                            <% }%>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="registro-parametros.jsp?remision=<%= remision.getId()%>" class="btn btn-primary bg-danger">Seleccionar remisión</a>
                        </div>
                    </div>
                </div>
                <% } %>
                <% } %>
            </div>
        </div>
        <% }%>


        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>


</html>
