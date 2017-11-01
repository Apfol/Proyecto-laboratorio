/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Remision_Examen;

import Examen.Examen;
import Examen.ModeloExamen;
import Medico.ControladorMedico;
import Remision.ModeloRemision;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "ControladorRemision_Examen", urlPatterns = {"/ControladorRemision_Examen"})
public class ControladorRemision_Examen extends HttpServlet {

    ModeloRemision modeloRemision = new ModeloRemision();
    ModeloRemision_Examen modeloRemision_Examen = new ModeloRemision_Examen();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Examen> examenes = new ModeloExamen().obtenerExamenesDB();
            List<Examen> examenesRemision = new ArrayList<>();
            String valor = req.getParameter("examen");

            /*int contador = 1;
            for (Examen examen : examenes) {
                String valor = req.getParameter("examen" + String.valueOf(contador));
                if (valor != null) {
                    if (examen.getId() == Integer.parseInt(req.getParameter("examen" + String.valueOf(contador)))) {
                        examenesRemision.add((examen));
                    }
                }
                contador++;
            }*/
            insertarRemisionExamen(req, resp, valor);
        } catch (Exception ex) {
            Logger.getLogger(ControladorRemision_Examen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Examen> examenes = new ModeloExamen().obtenerExamenesDB();
            List<Examen> examenesRemision = new ArrayList<>();
            String valor = req.getParameter("examen");

            /*int contador = 1;
            for (Examen examen : examenes) {
                String valor = req.getParameter("examen" + String.valueOf(contador));
                if (valor != null) {
                    if (examen.getId() == Integer.parseInt(req.getParameter("examen" + String.valueOf(contador)))) {
                        examenesRemision.add((examen));
                    }
                }
                contador++;
            }*/
            insertarRemisionExamen(req, resp, valor);
        } catch (Exception ex) {
            Logger.getLogger(ControladorRemision_Examen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insertarRemisionExamen(HttpServletRequest request, HttpServletResponse response, String idExamen) throws Exception {

        try {
            int idRemision = Integer.parseInt(request.getAttribute("remision").toString());
            Remision_Examen remision_examen = new Remision_Examen(idRemision, Integer.parseInt(idExamen));
            modeloRemision_Examen.agregarRemisionExamenDB(remision_examen);
            /*for (Examen examen : examenes) {

                int idExamen = examen.getId();
                int idRemision = Integer.parseInt(request.getAttribute("remision").toString());

                Remision_Examen remision_examen = new Remision_Examen(idRemision, idExamen);
                modeloRemision_Examen.agregarRemisionExamenDB(remision_examen);
            }*/
            response.sendRedirect("interfaz-medico.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMedico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
