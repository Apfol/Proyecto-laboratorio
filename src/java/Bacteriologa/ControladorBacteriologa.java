/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bacteriologa;

import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "ControladorBacteriologa", urlPatterns = {"/ControladorBacteriologa"})
public class ControladorBacteriologa extends HttpServlet {
    
    ModeloBacteriologa modeloBacteriologa = new ModeloBacteriologa();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String instruccion = request.getParameter("instruccion");

        switch (instruccion) {
            case "insertar":
                insertarBacteriologa(request, response);
                break;
        }
    }

    private void insertarBacteriologa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String usuario = request.getParameter("usuario");
            String contraseña = request.getParameter("password");
            long telefono = Long.parseLong(request.getParameter("telefono"));
            long identificacion = Long.parseLong(request.getParameter("identificacion"));
            int idCiudad = Integer.parseInt(request.getParameter("ciudad"));
            int idGenero = Integer.parseInt(request.getParameter("genero"));
            
            Bacteriologa bacteriologa = new Bacteriologa(nombres, apellidos, usuario, contraseña, telefono, identificacion, idCiudad, idGenero);
            modeloBacteriologa.agregarBacteriologaDB(bacteriologa);
            response.sendRedirect("index.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorBacteriologa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
