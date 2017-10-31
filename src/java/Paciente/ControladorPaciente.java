/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paciente;

import Medico.ControladorMedico;
import Medico.Medico;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres Ramos
 */
@WebServlet(name = "ControladorPaciente", urlPatterns = {"/ControladorPaciente"})
public class ControladorPaciente extends HttpServlet {

    ModeloPaciente modeloPaciente = new ModeloPaciente();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String instruccion = request.getParameter("instruccion");

        switch (instruccion) {
            case "insertar":
                insertarPaciente(request, response);
                break;
            case "validar":
                validarPaciente(request, response);
                break;
        }
    }

    private void insertarPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String usuario = request.getParameter("usuario");
            String contraseña = request.getParameter("password");
            long telefono = Long.parseLong(request.getParameter("telefono"));
            long identificacion = Long.parseLong(request.getParameter("identificacion"));
            String direccion = request.getParameter("direccion");
            int idCiudad = Integer.parseInt(request.getParameter("ciudad"));
            int idGenero = Integer.parseInt(request.getParameter("genero"));

            Paciente paciente = new Paciente(nombres, apellidos, usuario, contraseña, direccion, telefono, identificacion, idCiudad, idGenero);
            modeloPaciente.agregarPacienteDB(paciente);
            response.sendRedirect("index.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void validarPaciente(HttpServletRequest request, HttpServletResponse response) {
        try {
            String usuario = request.getParameter("usuario");
            String contraseña = request.getParameter("password");

            List<Paciente> pacientes = modeloPaciente.obtenerPacientesDB();
            for (Paciente paciente : pacientes) {
                if (usuario.equals(paciente.getUsuario()) && contraseña.equals(paciente.getContraseña())) {
                    response.sendRedirect("interfaz-paciente.jsp");
                }
            }
            response.sendRedirect("index.jsp?login=false");
        } catch (Exception ex) {
            Logger.getLogger(ControladorMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
