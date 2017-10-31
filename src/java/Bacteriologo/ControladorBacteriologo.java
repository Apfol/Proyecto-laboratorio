/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bacteriologo;

import Medico.ControladorMedico;
import Medico.Medico;
import Sentencias.SentenciasSQL;
import com.mallbit.cookies.ControladorCookie;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres Ramos
 */
@WebServlet(name = "ControladorBacteriologo", urlPatterns = {"/ControladorBacteriologo"})
public class ControladorBacteriologo extends HttpServlet {

    ModeloBacteriologo modeloBacteriologo = new ModeloBacteriologo();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String instruccion = request.getParameter("instruccion");

        switch (instruccion) {
            case "insertar":
                insertarBacteriologo(request, response);
                break;
            case "validar":
                validarBacteriologo(request, response);
                break;
        }
    }

    private void insertarBacteriologo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String usuario = request.getParameter("usuario");
            String contraseña = request.getParameter("password");
            long telefono = Long.parseLong(request.getParameter("telefono"));
            long identificacion = Long.parseLong(request.getParameter("identificacion"));
            int idCiudad = Integer.parseInt(request.getParameter("ciudad"));
            int idGenero = Integer.parseInt(request.getParameter("genero"));
            Bacteriologo bacteriologa = new Bacteriologo(nombres, apellidos, usuario, contraseña, telefono, identificacion, idCiudad, idGenero);
            modeloBacteriologo.agregarBacteriologaDB(bacteriologa);
            ControladorCookie.crearCookie(SentenciasSQL.obtenerUltimoIdGenerado("bacteriologa"), Bacteriologo.BACTERIOLOGO_COOKIE, response);
            response.sendRedirect("interfaz-bacteriologo.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorBacteriologo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void validarBacteriologo(HttpServletRequest request, HttpServletResponse response) {
        try {
            String usuario = request.getParameter("usuario");
            String contraseña = request.getParameter("password");

            List<Bacteriologo> bacteriologos = modeloBacteriologo.obtenerBacteriologosDB();
            for (Bacteriologo bacteriologo : bacteriologos) {
                if (usuario.equals(bacteriologo.getUsuario()) && contraseña.equals(bacteriologo.getContraseña())) {
                    ControladorCookie.crearCookie(bacteriologo.getId(), Bacteriologo.BACTERIOLOGO_COOKIE, response);
                    response.sendRedirect("interfaz-bacteriologo.jsp");
                }
            }
            response.sendRedirect("index.jsp?login=false");
        } catch (Exception ex) {
            Logger.getLogger(ControladorMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Bacteriologo obtenerBacteriologoCookie(List<Bacteriologo> bacteriologos, HttpServletRequest request) {
        Bacteriologo bacteriologo = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(Bacteriologo.BACTERIOLOGO_COOKIE)) {
                for (Bacteriologo bac : bacteriologos) {
                    if (bac.getId() == Integer.parseInt(cookie.getValue())) {
                        bacteriologo = bac;
                        break;
                    }
                }
            }
        }
        return bacteriologo;
    }
}
