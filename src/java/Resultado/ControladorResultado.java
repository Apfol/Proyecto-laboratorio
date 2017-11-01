/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resultado;

import Bacteriologo.Bacteriologo;
import Bacteriologo.ControladorBacteriologo;
import Bacteriologo.ModeloBacteriologo;
import Cookies.ControladorCookie;
import Medico.ControladorMedico;
import Medico.Medico;
import Remision.ModeloRemision;
import Sentencias.SentenciasSQL;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
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
@WebServlet(name = "ControladorResultado", urlPatterns = {"/ControladorResultado"})
public class ControladorResultado extends HttpServlet {
    
    ModeloResultado modeloResultado = new ModeloResultado();
    ModeloRemision modeloRemision = new ModeloRemision();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String instruccion = request.getParameter("instruccion");

        switch (instruccion) {
            case "insertar":
                insertarResultado(request, response);
                break;
        }
    }

    private void insertarResultado(HttpServletRequest request, HttpServletResponse response) {
        try {
            int cantidadValores = Integer.parseInt(request.getParameter("cantidadParametros"));

            for (int i = 1; i <= cantidadValores; i++) {
                
                String valor = request.getParameter("valor" + i);
                String idParametroString = request.getParameter("parametro" + i);
                int idParametro = Integer.parseInt(idParametroString);
                ModeloBacteriologo modeloBacteriologo = new ModeloBacteriologo();
                List<Bacteriologo> bacteriologos = modeloBacteriologo.obtenerBacteriologosDB();
                Bacteriologo bacteriologo = new ControladorBacteriologo().obtenerBacteriologoCookie(bacteriologos, request);
                int idBacteriologa = bacteriologo.getId();
                int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
                
                Date fechaRealizacion = Date.valueOf(LocalDate.now());
                
                Resultado resultado = new Resultado(idPaciente, idBacteriologa, idParametro, fechaRealizacion, valor);
                modeloResultado.agregarResultadoDB(resultado);
            }
            int idRemision = Integer.parseInt(request.getParameter("idRemision"));
            modeloRemision.actualizarRemisionDB(idRemision, true);
            response.sendRedirect("index.jsp");
        } catch (Exception ex) {
            Logger.getLogger(ControladorMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
