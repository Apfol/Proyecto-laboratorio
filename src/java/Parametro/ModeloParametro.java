/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parametro;

import Conexion.ConexionDB;
import Medico.Medico;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres Ramos
 */
public class ModeloParametro {

    public List<Parametro> obtenerParametrosDB() throws Exception {

        List<Parametro> parametros = new ArrayList<>();

        Connection connection;
        Statement statement;
        ResultSet resultSet;

        //Establecer la conexi�n
        connection = ConexionDB.conectar();

        //Crear sentencia SQL y statement
        String sentenciaSQL = "SELECT * FROM parametro";
        statement = connection.createStatement();

        //Ejecutar SQL y guardar valores de consulta en resultSet
        resultSet = statement.executeQuery(sentenciaSQL);

        //Recorrer resultador de la sentencia
        while (resultSet.next()) {
            int id = resultSet.getInt("id_parametro");
            int idExamen = resultSet.getInt("id_examen");
            String valorMaximo = resultSet.getString("valor_maximo");
            String valorMinimo = resultSet.getString("valor_minimo");
            String nombre = resultSet.getString("nombre");
            String descripcion = resultSet.getString("descripcion");
            
            parametros.add(new Parametro(id, idExamen, valorMaximo, valorMinimo, nombre, descripcion));
            

        }
        return parametros;
    }
}
