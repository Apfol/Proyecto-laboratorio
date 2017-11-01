/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parametro;

/**
 *
 * @author Andres Ramos
 */
public class Parametro {
    
    private int id;
    private int idExamen;
    private String valorMaximo;
    private String valorMinimo;
    private String nombre;
    private String descripcion;

    public Parametro(int id, int idExamen, String valorMaximo, String valorMinimo, String nombre, String descripcion) {
        this.id = id;
        this.idExamen = idExamen;
        this.valorMaximo = valorMaximo;
        this.valorMinimo = valorMinimo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Parametro(int idExamen, String valorMaximo, String valorMinimo, String nombre, String descripcion) {
        this.idExamen = idExamen;
        this.valorMaximo = valorMaximo;
        this.valorMinimo = valorMinimo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public String getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(String valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public String getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(String valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
