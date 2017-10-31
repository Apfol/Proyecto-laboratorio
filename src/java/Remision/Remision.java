/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Remision;

import java.sql.Date;



/**
 *
 * @author Andres Ramos
 */
public class Remision {
    
    private int id;
    private int idPaciente;
    private int idMedico;
    private Date fecha;

    public Remision(int idRemision, int idPaciente, int idMedico, Date fecha) {
        this.id = idRemision;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.fecha = fecha;
    }

    public Remision(int idPaciente, int idMedico, Date fecha) {
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.fecha = fecha;
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

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
