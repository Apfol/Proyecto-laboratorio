/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Remision;

import Bacteriologo.ControladorBacteriologo;
import Examen.Examen;
import Examen.ModeloExamen;
import Medico.ControladorMedico;
import Medico.Medico;
import Medico.ModeloMedico;
import Sentencias.SentenciasSQL;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres Ramos
 */
@WebServlet(name = "ControladorRemision", urlPatterns = {"/ControladorRemision"})
public class ControladorRemision extends HttpServlet {

    ModeloRemision modeloRemision = new ModeloRemision();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String instruccion = request.getParameter("instruccion");

            switch (instruccion) {
                case "insertar":
                    insertarRemision(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(ControladorRemision.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insertarRemision(HttpServletRequest request, HttpServletResponse response) throws IOException, Exception {
        try {
            List<Examen> examenes = new ModeloExamen().obtenerExamenesDB();
            List<Examen> examenesRemision = new ArrayList<>();

            int contador = 1;
            for (Examen examen : examenes) {
                String valor = request.getParameter("examen" + String.valueOf(contador));
                if (valor != null) {
                    if (examen.getId() == Integer.parseInt(request.getParameter("examen" + String.valueOf(contador)))) {
                        examenesRemision.add((examen));
                    }
                }
                contador++;
            }
            
            for(Examen examen: examenesRemision){
                request.setAttribute("examen" + String.valueOf(contador), examen.getId());
            }
            int idPaciente = Integer.parseInt(request.getParameter("paciente"));
            ModeloMedico modeloMedico = new ModeloMedico();
            List<Medico> medicos = modeloMedico.obtenerMedicosDB();
            Medico medico = new ControladorMedico().obtenerMedicoCookie(medicos, request);
            Date fecha = Date.valueOf(LocalDate.now());
            Remision remision = new Remision(idPaciente, medico.getId(), fecha);
            modeloRemision.agregarRemisionDB(remision);
            request.setAttribute("remision", SentenciasSQL.obtenerUltimoIdGenerado("remision"));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("ControladorRemision_Examen");
            requestDispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorBacteriologo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
