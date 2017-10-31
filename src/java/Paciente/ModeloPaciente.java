/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paciente;

import Conexion.ConexionDB;
import Medico.Medico;
import java.sql.Connection;
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
    
    public List<Paciente> obtenerPacientesDB() throws Exception {

        List<Paciente> pacientes = new ArrayList<>();

        Connection connection;
        Statement statement;
        ResultSet resultSet;

        //Establecer la conexi�n
        connection = ConexionDB.conectar();

        //Crear sentencia SQL y statement
        String sentenciaSQL = "SELECT * FROM paciente";
        statement = connection.createStatement();

        //Ejecutar SQL y guardar valores de consulta en resultSet
        resultSet = statement.executeQuery(sentenciaSQL);

        //Recorrer resultador de la sentencia
        while (resultSet.next()) {
            int id = resultSet.getInt("id_paciente");
            String nombres = resultSet.getString("nombres");
            String apellidos = resultSet.getString("apellidos");
            long identificacion = resultSet.getLong("identificacion");
            long telefono = resultSet.getLong("telefono");
            String usuario = resultSet.getString("usuario");
            String contraseña = resultSet.getString("contraseña");
            String direccion = resultSet.getString("direccion");
            int idCiudad = resultSet.getInt("id_ciudad");
            int idGenero = resultSet.getInt("id_genero");

            pacientes.add(new Paciente(id, nombres, apellidos, usuario, contraseña, direccion, telefono, identificacion, idCiudad, idGenero));

        }
        return pacientes;
    }
}
