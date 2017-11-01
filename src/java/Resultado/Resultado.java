/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resultado;

import java.sql.Date;

public class Resultado {
    
    private int id;
    private int idPaciente;
    private int idBacteriologa;
    private int idParametro;
    private Date fechaRealizacion;
    private String valor;

    public Resultado(int id, int idPaciente, int idBacteriologa, int idParametro, Date fechaRealizacion, String valor) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.idBacteriologa = idBacteriologa;
        this.idParametro = idParametro;
        this.fechaRealizacion = fechaRealizacion;
        this.valor = valor;
    }

    public Resultado(int idPaciente, int idBacteriologa, int idParametro, Date fechaRealizacion, String valor) {
        this.idPaciente = idPaciente;
        this.idBacteriologa = idBacteriologa;
        this.idParametro = idParametro;
        this.fechaRealizacion = fechaRealizacion;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdBacteriologa() {
        return idBacteriologa;
    }

    public void setIdBacteriologa(int idBacteriologa) {
        this.idBacteriologa = idBacteriologa;
    }

    public int getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(int idParametro) {
        this.idParametro = idParametro;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
    
}
