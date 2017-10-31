/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bacteriologo;

import Conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Andres Ramos
 */
public class ModeloBacteriologo {

    public void agregarBacteriologaDB(Bacteriologo bacteriologa) throws SQLException {

        Connection connection;
        PreparedStatement preparedStatement;

        //Establecer la conexi�n
        connection = ConexionDB.conectar();

        //Crear sentencia SQL y statement
        String sentenciaSQL = "INSERT INTO bacteriologa "
                + "(nombres,apellidos,usuario,contraseña,telefono,identificacion,id_ciudad,id_genero)"
                + " VALUES (?,?,?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sentenciaSQL);

        //Pasar valores del objeto cliente a la sentenciaSQL
        preparedStatement.setString(1, bacteriologa.getNombres());
        preparedStatement.setString(2, bacteriologa.getApellidos());
        preparedStatement.setString(3, bacteriologa.getUsuario());
        preparedStatement.setString(4, bacteriologa.getContraseña());
        preparedStatement.setLong(5, bacteriologa.getTelefono());
        preparedStatement.setLong(6, bacteriologa.getIdentificacion());
        preparedStatement.setInt(7, bacteriologa.getIdCiudad());
        preparedStatement.setInt(8, bacteriologa.getIdGenero());

        preparedStatement.execute();
    }
}
