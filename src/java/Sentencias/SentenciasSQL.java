/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sentencias;

import Conexion.ConexionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Andres Ramos
 */
public class SentenciasSQL {
    public static int obtenerUltimoIdGenerado(String entidad) throws SQLException {

        Connection connection;
        Statement statement;
        ResultSet resultSet;

        //Establecer la conexi�n
        connection = ConexionDB.conectar();
        int maxID = 0;
        //Crear sentencia SQL y statement
        String sentenciaSQL = "SELECT max(id_"+ entidad +") from "+ entidad;
        statement = connection.createStatement();

        //Ejecutar SQL y guardar valores de consulta en resultSet
        resultSet = statement.executeQuery(sentenciaSQL);

        //Recorrer resultador de la sentencia
        if (resultSet.next()) {
            maxID = resultSet.getInt(1);
        }

        return maxID;
    }
}
