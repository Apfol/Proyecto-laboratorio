/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medico;

import Conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Andres Ramos
 */
public class ModeloMedico {
    
    public void agregarMedicoDB(Medico medico) throws SQLException {

        Connection connection;
        PreparedStatement preparedStatement;

        //Establecer la conexi�n
        connection = ConexionDB.conectar();

        //Crear sentencia SQL y statement
        String sentenciaSQL = "INSERT INTO medico "
                + "(nombres,apellidos,usuario,contraseña,telefono,identificacion,registros,id_ciudad,id_genero)"
                + " VALUES (?,?,?,?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sentenciaSQL);

        //Pasar valores del objeto cliente a la sentenciaSQL
        preparedStatement.setString(1, medico.getNombres());
        preparedStatement.setString(2, medico.getApellidos());
        preparedStatement.setString(3, medico.getUsuario());
        preparedStatement.setString(4, medico.getContraseña());
        preparedStatement.setLong(5, medico.getTelefono());
        preparedStatement.setLong(6, medico.getIdentificacion());
        preparedStatement.setInt(7, medico.getRegistros());
        preparedStatement.setInt(8, medico.getIdCiudad());
        preparedStatement.setInt(9, medico.getIdGenero());

        preparedStatement.execute();
    }
    
}
