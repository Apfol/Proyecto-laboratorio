<%-- 
    Document   : interfaz-paciente
    Created on : Oct 30, 2017, 11:44:58 PM
    Author     : Andres Ramos
--%>

<%@page import="Bacteriologo.ModeloBacteriologo"%>
<%@page import="Bacteriologo.Bacteriologo"%>
<%@page import="Resultado.ModeloResultado"%>
<%@page import="Resultado.Resultado"%>
<%@page import="Paciente.ControladorPaciente"%>
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
    ModeloPaciente modeloPaciente = new ModeloPaciente();
    List<Paciente> pacientes = modeloPaciente.obtenerPacientesDB();
    Paciente paciente = new ControladorPaciente().obtenerPacienteCookie(pacientes, request);
    boolean sinResultados = true;

    List<Remision> remisionesPaciente = new ArrayList<>();
    Medico medico = null;
    List<Remision> remisiones = new ModeloRemision().obtenerRemisionesDB();
    List<Remision_Examen> remisionesExamen = new ModeloRemision_Examen().obtenerRemisionesExamenesDB();
    List<Medico> medicos = new ModeloMedico().obtenerMedicosDB();
    List<Examen> examenes = new ModeloExamen().obtenerExamenesDB();
    List<Parametro> parametros = new ModeloParametro().obtenerParametrosDB();
    List<Resultado> resultados = new ModeloResultado().obtenerResultadosDB();
    List<Resultado> resultadosPaciente = new ArrayList<>();
    List<Bacteriologo> bacteriologos = new ModeloBacteriologo().obtenerBacteriologosDB();

    for (Remision remision : remisiones) {
        if (remision.getIdPaciente() == paciente.getId()) {
            remisionesPaciente.add(remision);
        }
    }

    for (Resultado resultado : resultados) {
        if (resultado.getIdPaciente() == paciente.getId()) {
            resultadosPaciente.add(resultado);
        }
    }

    /*
    for (Medico doc : medicos) {
        if (doc.getId() == remision.getIdMedico()) {
            medico = doc;
        }
    }*/
%>
<!DOCTYPE html>
<head>
    <title>Resultados parámetros</title>
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
                <h1>Resultados de parámetros</h1>
                <br>
                <h4>Nombre paciente: <%= paciente.getNombres() + " " + paciente.getApellidos()%></h4>
                <br>
                <h2 class="text-center">REMISIONES</h2>
                <br>
                <% int counter = 1; %>
                <% for (Remision remision : remisionesPaciente) { %>
                <% if (remision.isRealizada()) {%>
                <% sinResultados = false;%>
                <div class="card text-white bg-danger mb-3">
                    <div class="card-header">Remisión N° <%= counter%></div>
                    <%
                        for (Remision_Examen remiExam : remisionesExamen) {
                            if (remiExam.getIdRemision() == remision.getId()) {
                                for (Examen examen : examenes) {
                                    if (examen.getId() == remiExam.getIdExamen()) {%>
                    <div class="card-body">
                        <h4 class="card-title">Examen: <%= examen.getNombre()%></h4>
                        <p class="card-text">

                            <% for (Medico doc : medicos) { %>
                            <% if (remision.getIdMedico() == doc.getId()) {%>
                            Médico : <%= doc.getNombres() + " " + doc.getApellidos()%>
                            <% } %>
                            <% }%>
                            <br>

                            <br>
                            <%= examen.getDescripcion()%>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Parámetro</th>
                                    <th scope="col">Valor mínimo</th>
                                    <th scope="col">Valor máximo</th>
                                    <th scope="col">Resultado</th>
                                    <th scope="col">Bacterióloga</th>
                                    <th scope="col">Fecha realización</th>
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
                                <% for (Resultado result : resultadosPaciente) { %>
                                <% if (result.getIdParametro() == parametro.getId()) {%>
                                <td><%= result.getValor()%></td>
                                <% for (Bacteriologo bacteriologo : bacteriologos) { %>
                                <% if (bacteriologo.getId() == result.getIdBacteriologa()) {%>
                                <td><%= bacteriologo.getNombres() + " " + bacteriologo.getApellidos()%></td>
                                <td><%= result.getFechaRealizacion() %></td>
                                <% } %>
                                <% } %>
                                <% } %>
                                <% } %>
                            </tr>
                            <% counterParameter++; %>
                            <% } %>
                            <% }%>
                            </tbody>
                        </table>
                        </p>
                    </div>
                    <%}
                                }
                            }
                        }
                    %>

                </div>
                <% } %>
                <% }%>
                <% if (sinResultados) { %>
                <h4 class="text-danger">SIN RESULTADOS</h4>
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
