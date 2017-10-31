/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paciente;

import Conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Andres Ramos
 */
public class ModeloPaciente {
    
    public void agregarPacienteDB(Paciente paciente) throws SQLException {

        Connection connection;
        PreparedStatement preparedStatement;

        //Establecer la conexi�n
        connection = ConexionDB.conectar();

        //Crear sentencia SQL y statement
        String sentenciaSQL = "INSERT INTO paciente "
                + "(nombres,apellidos,usuario,contraseña,telefono,identificacion,direccion,id_ciudad,id_genero)"
                + " VALUES (?,?,?,?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sentenciaSQL);

        //Pasar valores del objeto cliente a la sentenciaSQL
        preparedStatement.setString(1, paciente.getNombres());
        preparedStatement.setString(2, paciente.getApellidos());
        preparedStatement.setString(3, paciente.getUsuario());
        preparedStatement.setString(4, paciente.getContraseña());
        preparedStatement.setLong(5, paciente.getTelefono());
        preparedStatement.setLong(6, paciente.getIdentificacion());
        preparedStatement.setString(7, paciente.getDireccion());
        preparedStatement.setInt(8, paciente.getIdCiudad());
        preparedStatement.setInt(9, paciente.getIdGenero());

        preparedStatement.execute();
    }
}
