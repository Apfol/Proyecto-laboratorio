/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen;

import Conexion.ConexionDB;
import Paciente.Paciente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres Ramos
 */
public class ModeloExamen {
    
    public List<Examen> obtenerExamenesDB() throws Exception {

        List<Examen> examenes = new ArrayList<>();

        Connection connection;
        Statement statement;
        ResultSet resultSet;

        //Establecer la conexi�n
        connection = ConexionDB.conectar();

        //Crear sentencia SQL y statement
        String sentenciaSQL = "SELECT * FROM examen";
        statement = connection.createStatement();

        //Ejecutar SQL y guardar valores de consulta en resultSet
        resultSet = statement.executeQuery(sentenciaSQL);

        //Recorrer resultador de la sentencia
        while (resultSet.next()) {
            int id = resultSet.getInt("id_examen");
            String nombres = resultSet.getString("nombre");
            String descripcion = resultSet.getString("descripcion");

            examenes.add(new Examen(id, nombres, descripcion));

        }
        return examenes;
    }
}
