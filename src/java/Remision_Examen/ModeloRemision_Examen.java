/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Remision_Examen;

import Conexion.ConexionDB;
import Remision.Remision;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres Ramos
 */
public class ModeloRemision_Examen {
    
    public void agregarRemisionExamenDB(Remision_Examen remision_examen) throws SQLException {

        Connection connection;
        PreparedStatement preparedStatement;

        //Establecer la conexi�n
        connection = ConexionDB.conectar();

        //Crear sentencia SQL y statement
        String sentenciaSQL = "INSERT INTO remision_examen "
                + "(id_remision,id_examen)"
                + " VALUES (?,?)";
        preparedStatement = connection.prepareStatement(sentenciaSQL);

        //Pasar valores del objeto cliente a la sentenciaSQL
        preparedStatement.setInt(1, remision_examen.getIdRemision());
        preparedStatement.setInt(2, remision_examen.getIdExamen());

        preparedStatement.execute();
    }
    
    /*public List<Remision_Examen> obtenerRemisionesExamenesDB() throws Exception {

        List<Remision_Examen> remisionesExamenes = new ArrayList<>();

        Connection connection;
        Statement statement;
        ResultSet resultSet;

        //Establecer la conexi�n
        connection = ConexionDB.conectar();

        //Crear sentencia SQL y statement
        String sentenciaSQL = "SELECT * FROM remision_examen";
        statement = connection.createStatement();

        //Ejecutar SQL y guardar valores de consulta en resultSet
        resultSet = statement.executeQuery(sentenciaSQL);

        //Recorrer resultador de la sentencia
        while (resultSet.next()) {
            int id = resultSet.getInt("id_remision");
            int idPaciente = resultSet.getInt("id_paciente");
            int idMedico = resultSet.getInt("id_medico");
            Date fecha = resultSet.getDate("fecha");

            remisiones.add(new Remision(id, idPaciente, idMedico, fecha));

        }
        return remisiones;
    }*/
}
