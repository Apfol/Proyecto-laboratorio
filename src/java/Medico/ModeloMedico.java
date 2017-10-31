/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medico;

import Conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    
    public List<Medico> obtenerMedicosDB() throws Exception {

        List<Medico> medicos = new ArrayList<>();

        Connection connection;
        Statement statement;
        ResultSet resultSet;

        //Establecer la conexi�n
        connection = ConexionDB.conectar();

        //Crear sentencia SQL y statement
        String sentenciaSQL = "SELECT * FROM medico";
        statement = connection.createStatement();

        //Ejecutar SQL y guardar valores de consulta en resultSet
        resultSet = statement.executeQuery(sentenciaSQL);

        //Recorrer resultador de la sentencia
        while (resultSet.next()) {
            int id = resultSet.getInt("id_medico");
            String nombres = resultSet.getString("nombres");
            String apellidos = resultSet.getString("apellidos");
            long identificacion = resultSet.getLong("identificacion");
            long telefono = resultSet.getLong("telefono");
            String usuario = resultSet.getString("usuario");
            String contraseña = resultSet.getString("contraseña");
            int registros = resultSet.getInt("registros");
            int idCiudad = resultSet.getInt("id_ciudad");
            int idGenero = resultSet.getInt("id_genero");

            medicos.add(new Medico(id, nombres, apellidos, usuario, contraseña, telefono, identificacion, registros, idCiudad, idGenero));

        }
        return medicos;
    }
    
}
