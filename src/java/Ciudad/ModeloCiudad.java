/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciudad;

import Conexion.ConexionDB;
import Genero.Genero;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres Ramos
 */
public class ModeloCiudad {
    
    public List<Ciudad> getCiudades() throws Exception {
        List<Ciudad> ciudades = new ArrayList<>();

        Connection connection;
        Statement statement;
        ResultSet resultSet;

        //Establecer la conexion
        connection = ConexionDB.conectar();

        //Crear sentencia SQL y statement
        String sentenciaSQL = "SELECT * FROM ciudad";
        statement = connection.createStatement();

        //Ejecutar SQL
        resultSet = statement.executeQuery(sentenciaSQL);

        //Recorrer resultados de la sentencia mientras existan
        while (resultSet.next()) {

            int id = resultSet.getInt("id_ciudad");
            String nombre = resultSet.getString("nombre");

            ciudades.add(new Ciudad(id, nombre));

        }
        return ciudades;
    }
}
