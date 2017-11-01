/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resultado;

import Conexion.ConexionDB;
import Medico.Medico;
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
public class ModeloResultado {

    public void agregarResultadoDB(Resultado resultado) throws SQLException {

        Connection connection;
        PreparedStatement preparedStatement;

        //Establecer la conexi�n
        connection = ConexionDB.conectar();

        //Crear sentencia SQL y statement
        String sentenciaSQL = "INSERT INTO resultado "
                + "(id_paciente,id_bacteriologa,id_parametro,fecha,valor)"
                + " VALUES (?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sentenciaSQL);

        //Pasar valores del objeto cliente a la sentenciaSQL
        preparedStatement.setInt(1, resultado.getIdPaciente());
        preparedStatement.setInt(2, resultado.getIdBacteriologa());
        preparedStatement.setInt(3, resultado.getIdParametro());
        preparedStatement.setDate(4, resultado.getFechaRealizacion());
        preparedStatement.setString(5, resultado.getValor());

        preparedStatement.execute();
    }
    
    public List<Resultado> obtenerResultadosDB() throws Exception {

        List<Resultado> resultados = new ArrayList<>();

        Connection connection;
        Statement statement;
        ResultSet resultSet;

        //Establecer la conexi�n
        connection = ConexionDB.conectar();

        //Crear sentencia SQL y statement
        String sentenciaSQL = "SELECT * FROM resultado";
        statement = connection.createStatement();

        //Ejecutar SQL y guardar valores de consulta en resultSet
        resultSet = statement.executeQuery(sentenciaSQL);

        //Recorrer resultador de la sentencia
        while (resultSet.next()) {
            int id = resultSet.getInt("id_resultado");
            int idPaciente = resultSet.getInt("id_paciente");
            int idBacteriologa = resultSet.getInt("id_bacteriologa");
            int idParametro = resultSet.getInt("id_parametro");
            Date fecha = resultSet.getDate("fecha");
            String valor = resultSet.getString("valor");
            
            resultados.add(new Resultado(id, idPaciente, idBacteriologa, idParametro, fecha, valor));

        }
        return resultados;
    }
}
