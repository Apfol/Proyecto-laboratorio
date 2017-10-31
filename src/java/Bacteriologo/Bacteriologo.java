/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bacteriologo;

/**
 *
 * @author Andres Ramos
 */
public class Bacteriologo {
    
    public static final String BACTERIOLOGO_COOKIE = "bacteriologo";
    
    private int id;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String contraseña;
    private Long telefono;
    private Long identificacion;
    private int idCiudad;
    private int idGenero;

    public Bacteriologo(int id, String nombres, String apellidos, String usuario, String contraseña, Long telefono, Long identificacion, int idCiudad, int idGenero) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.idCiudad = idCiudad;
        this.idGenero = idGenero;
    }

    public Bacteriologo(String nombres, String apellidos, String usuario, String contraseña, Long telefono, Long identificacion, int idCiudad, int idGenero) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.idCiudad = idCiudad;
        this.idGenero = idGenero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }
}
