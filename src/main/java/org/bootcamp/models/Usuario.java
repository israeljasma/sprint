package org.bootcamp.models;

import java.util.Date;

public class Usuario {

    private int id;
    private String username;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String rut;
    private String password;

    public Usuario() {
    }

    public Usuario(String username, String nombres, String apellidos, Date fechaNacimiento, String rut, String password) {
        this.username = username;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.rut = rut;
        this.password = password;
    }

    public Usuario(int id, String username, String nombres, String apellidos, Date fechaNacimiento, String rut, String password) {
        this.id = id;
        this.username = username;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.rut = rut;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
