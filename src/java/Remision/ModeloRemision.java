/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Remision;

import Conexion.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
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
public class ModeloRemision {

    public void agregarRemisionDB(Remision remision) throws SQLException {

        Connection connection;
        PreparedStatement preparedStatement;

        //Establecer la conexi�n
        connection = ConexionDB.conectar();

        //Crear sentencia SQL y statement
        String sentenciaSQL = "INSERT INTO remision "
                + "(id_paciente,fecha,id_medico, realizada)"
                + " VALUES (?,?,?,?)";
        preparedStatement = connection.prepareStatement(sentenciaSQL);

        //Pasar valores del objeto cliente a la sentenciaSQL
        preparedStatement.setInt(1, remision.getIdPaciente());
        preparedStatement.setDate(2, remision.getFecha());
        preparedStatement.setInt(3, remision.getIdMedico());
        preparedStatement.setBoolean(4, remision.isRealizada());

        preparedStatement.execute();
    }

    public List<Remision> obtenerRemisionesDB() throws Exception {

        List<Remision> remisiones = new ArrayList<>();

        Connection connection;
        Statement statement;
        ResultSet resultSet;

        //Establecer la conexi�n
        connection = ConexionDB.conectar();

        //Crear sentencia SQL y statement
        String sentenciaSQL = "SELECT * FROM remision";
        statement = connection.createStatement();

        //Ejecutar SQL y guardar valores de consulta en resultSet
        resultSet = statement.executeQuery(sentenciaSQL);

        //Recorrer resultador de la sentencia
        while (resultSet.next()) {
            int id = resultSet.getInt("id_remision");
            int idPaciente = resultSet.getInt("id_paciente");
            int idMedico = resultSet.getInt("id_medico");
            Date fecha = resultSet.getDate("fecha");
            boolean realizada = resultSet.getBoolean("realizada");

            remisiones.add(new Remision(id, idPaciente, idMedico, fecha, realizada));

        }
        return remisiones;
    }

    public void actualizarRemisionDB(int idRemision, boolean reailzada) throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;

        //Establecer la conexión
        connection = ConexionDB.conectar();

        String sentenciaNombre = "UPDATE remision SET realizada=? WHERE id_remision=?";
        preparedStatement = connection.prepareStatement(sentenciaNombre);
        preparedStatement.setBoolean(1, reailzada);
        preparedStatement.setInt(2, idRemision);
        preparedStatement.executeUpdate();
    }
}
