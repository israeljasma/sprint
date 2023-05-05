package org.bootcamp.models;

import java.util.Date;

public class Usuario {

    private String id;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String rut;
    private String password;

    public Usuario() {
    }

    public Usuario(String nombres, String apellidos, Date fechaNacimiento, String rut) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.rut = rut;
    }

    public Usuario(String id, String nombres, String apellidos, Date fechaNacimiento, String rut) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.rut = rut;
    }
}
