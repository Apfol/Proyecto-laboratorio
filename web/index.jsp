<%-- 
    Document   : index
    Created on : Oct 30, 2017, 5:53:55 PM
    Author     : Andres Ramos
--%>

<%@page import="Usuario.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Sistema laboratorio</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-grid.css" type="text/css"/>

    </head>

    <body class="bg-light">
        <nav class="navbar navbar-dark bg-primary">
            <a class="navbar-brand" href="#">Sistema gestión de remisiones</a>
        </nav>

        <br>

        <div class="container">
            <h2 class="text-center">USUARIOS DEL SISTEMA</h2>
            <br>
            <div class="row">
                <div class="col-sm">
                    <div class="card" style="width: 20rem;">
                        <img class="card-img-top" src="images/doctor.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title">Médico</h4>
                            <p class="card-text">Ingresa para generar las respectivas remisiones.</p>
                            <a href="#" class="card-link" data-toggle="modal" data-target="#modalDoctor">Incio de sesión</a>
                            <a href="registro.jsp?usuario=<%= Usuario.MEDICO%>" class="card-link">Registro</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm">
                    <div class="card" style="width: 20rem;">
                        <img class="card-img-top" src="images/bacteriologa.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title">Bacterióloga</h4>
                            <p class="card-text">Ingresa para registrar los valores de los parametros cada de examen de la remisión.</p>
                            <a href="#" class="card-link" data-toggle="modal" data-target="#modalBacteriologist">Incio de sesión</a>
                            <a href="registro.jsp?usuario=<%= Usuario.BACTERIOLOGO%>" class="card-link">Registro</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm">
                    <div class="card" style="width: 20rem;">
                        <img class="card-img-top" src="images/paciente.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title">Paciente</h4>
                            <p class="card-text">Ingresa para ver los resultados de tus examenes.</p>
                            <a href="#" class="card-link" data-toggle="modal" data-target="#modalPatient">Incio de sesión</a>
                            <a href="registro.jsp?usuario=<%= Usuario.PACIENTE%>" class="card-link">Registro</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal médico-->
        <div class="modal fade" id="modalDoctor" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Incio sesión médico</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="ControladorMedico" method="post">
                        <input type="hidden" name="instruccion" value="validar"/>
                        <div class="modal-body">
                            <div class="form-group">
                                <input type="text" name="usuario" class="form-control" id="formGroupExampleInput" placeholder="Usuario">
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" class="form-control" id="formGroupExampleInput2" placeholder="Contraseña">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                            <button type="submit" class="btn btn-primary">Iniciar sesión</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Modal bacteriologist-->
        <div class="modal fade" id="modalBacteriologist" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Incio sesión bacterióloga</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="ControladorBacteriologo" method="post">
                        <input type="hidden" name="instruccion" value="validar"/>
                        <div class="modal-body">
                            <div class="form-group">
                                <input type="text" name="usuario" class="form-control" id="formGroupExampleInput" placeholder="Usuario">
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" class="form-control" id="formGroupExampleInput2" placeholder="Contraseña">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                            <button type="submit" class="btn btn-primary">Iniciar sesión</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Modal patient-->
        <div class="modal fade" id="modalPatient" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Incio sesión paciente</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="ControladorPaciente" method="post">
                        <input type="hidden" name="instruccion" value="validar"/>
                        <div class="modal-body">
                            <div class="form-group">
                                <input type="text" name="usuario" class="form-control" id="formGroupExampleInput" placeholder="Usuario">
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" class="form-control" id="formGroupExampleInput2" placeholder="Contraseña">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                            <button type="submit" class="btn btn-primary">Iniciar sesión</button>
                        </div>
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
