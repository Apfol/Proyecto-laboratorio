/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genero;

import Conexion.ConexionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres Ramos
 */
public class ModeloGenero {
    
    public List<Genero> getGeneros() throws Exception {
        List<Genero> generos = new ArrayList<>();

        Connection connection;
        Statement statement;
        ResultSet resultSet;

        //Establecer la conexion
        connection = ConexionDB.conectar();

        //Crear sentencia SQL y statement
        String sentenciaSQL = "SELECT * FROM genero";
        statement = connection.createStatement();

        //Ejecutar SQL
        resultSet = statement.executeQuery(sentenciaSQL);

        //Recorrer resultados de la sentencia mientras existan
        while (resultSet.next()) {

            int id = resultSet.getInt("id_genero");
            String nombre = resultSet.getString("tipoGenero");

            Genero genero = new Genero(id, nombre);
            generos.add(genero);

        }
        return generos;
    }
}
