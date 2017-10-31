/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Remision_Examen;

/**
 *
 * @author Andres Ramos
 */
public class Remision_Examen {
    
    private int idRemision;
    private int idExamen;

    public Remision_Examen(int idRemision, int idExamen) {
        this.idRemision = idRemision;
        this.idExamen = idExamen;
    }

    public int getIdRemision() {
        return idRemision;
    }

    public void setIdRemision(int idRemision) {
        this.idRemision = idRemision;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }
    
    
}
