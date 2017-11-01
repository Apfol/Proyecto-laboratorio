<%-- 
    Document   : registro-parametros
    Created on : Oct 31, 2017, 7:51:09 PM
    Author     : Andres Ramos
--%>

<%@page import="Parametro.ModeloParametro"%>
<%@page import="Parametro.Parametro"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Examen.ModeloExamen"%>
<%@page import="Examen.Examen"%>
<%@page import="Remision_Examen.Remision_Examen"%>
<%@page import="Remision_Examen.ModeloRemision_Examen"%>
<%@page import="Medico.ModeloMedico"%>
<%@page import="Medico.Medico"%>
<%@page import="Paciente.ModeloPaciente"%>
<%@page import="Paciente.Paciente"%>
<%@page import="Remision.ModeloRemision"%>
<%@page import="Remision.Remision"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Remision remision = null;
    Paciente paciente = null;
    Medico medico = null;
    List<Examen> examenesRemision = new ArrayList<>();
    String idRemisionString = request.getParameter("remision");
    int idRemision = Integer.parseInt(idRemisionString);
    List<Remision> remisiones = new ModeloRemision().obtenerRemisionesDB();
    List<Remision_Examen> remisionesExamen = new ModeloRemision_Examen().obtenerRemisionesExamenesDB();
    List<Paciente> pacientes = new ModeloPaciente().obtenerPacientesDB();
    List<Medico> medicos = new ModeloMedico().obtenerMedicosDB();
    List<Examen> examenes = new ModeloExamen().obtenerExamenesDB();
    List<Parametro> parametros = new ModeloParametro().obtenerParametrosDB();

    for (Remision remi : remisiones) {
        if (remi.getId() == idRemision) {
            remision = remi;
        }
    }

    for (Remision_Examen remiExam : remisionesExamen) {
        if (remiExam.getIdRemision() == remision.getId()) {
            for (Examen exam : examenes) {
                if (exam.getId() == remiExam.getIdExamen()) {
                    examenesRemision.add(exam);
                }
            }
        }
    }

    for (Paciente pacient : pacientes) {
        if (pacient.getId() == remision.getIdPaciente()) {
            paciente = pacient;
        }
    }

    for (Medico doc : medicos) {
        if (doc.getId() == remision.getIdMedico()) {
            medico = doc;
        }
    }
%>
<!DOCTYPE html>
<head>
    <title>Registro parámetros</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap-grid.css" type="text/css"/>

</head>

<body class="bg-light">
    <nav class="navbar navbar-dark bg-primary">
        <a class="navbar-brand" href="index.jsp">Sistema gestión de remisiones</a>
    </nav>
    <br><br>
    <div class="container">
        <div class="row justify-content-center align-items-center">
            <div class="col align-self-center">
                <h2 class="text-center">REGISTRO PARÁMETROS</h2>
                <br>
                <br>
                <h4>Nombre paciente: <%= paciente.getNombres() + " " + paciente.getApellidos()%></h4>
                <h4>Nombre médico: <%= medico.getNombres() + " " + medico.getApellidos()%></h4>
                <h4>Fecha remisión: <%= remision.getFecha()%></h4>
                <br>
                <% int counter = 1; %>
                <% for (Examen examen : examenesRemision) {%>
                <div class="card text-white bg-danger mb-3">
                    <div class="card-header">Examen N° <%= counter%></div>
                    <div class="card-body">
                        <h4 class="card-title"><%= examen.getNombre()%></h4>
                        <form action="ControladorResultado" method="post">
                            <input type="hidden" name="instruccion" value="insertar"/>
                            <p class="card-text">
                                <%= examen.getDescripcion()%>
                                <br>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Parámetro</th>
                                        <th scope="col">Valor mínimo</th>
                                        <th scope="col">Valor máximo</th>
                                        <th scope="col">Valor encontrado</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% int counterParameter = 1; %>
                                    <% for (Parametro parametro : parametros) { %>
                                    <% if (parametro.getIdExamen() == examen.getId()) {%>
                                <input type="hidden" name="parametro<%= counterParameter%>" value="<%= parametro.getId()%>"/>
                                <tr>
                                    <th scope="row"><%= counterParameter%></th>
                                    <td><%= parametro.getNombre()%></td>
                                    <td><%= parametro.getValorMinimo()%></td>
                                    <td><%= parametro.getValorMaximo()%></td>
                                    <td><input class="form-control mr-sm-2" type="search" name="valor<%= counterParameter%>" placeholder="Ingresar valor" aria-label="Search"></td>
                                </tr>
                                <% counterParameter++; %>
                                <% } %>
                                <% }%>
                                </tbody>
                            </table>
                            </p>
                            <input type="hidden" name="cantidadParametros" value="<%= counterParameter - 1%>"/>
                            <input type="hidden" name="idPaciente" value="<%= paciente.getId()%>"/>
                            <input type="hidden" name="idRemision" value="<%= remision.getId()%>"/>
                            <button type="submit" class="btn btn-primary bg-dark">Registrar valores</button>
                        </form>
                    </div>
                </div>
                <% counter++; %>
                <% }%>
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
