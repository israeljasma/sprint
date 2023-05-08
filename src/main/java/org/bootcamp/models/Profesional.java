package org.bootcamp.models;

import java.util.Date;

public class Profesional extends Usuario {
    private String titulo;
    private String fechaIngreso;

    public Profesional() {
        super();
    }

    public Profesional(String username, String nombres, String apellidos, Date fechaNacimiento, String rut, int rol, String password, String titulo, String fechaIngreso) {
        super(username, nombres, apellidos, fechaNacimiento, rut, rol, password);
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    public Profesional(int id, String username, String nombres, String apellidos, Date fechaNacimiento, String rut, int rol, String password, String titulo, String fechaIngreso) {
        super(id, username, nombres, apellidos, fechaNacimiento, rut, rol, password);
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
