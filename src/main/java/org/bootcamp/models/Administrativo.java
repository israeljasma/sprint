package org.bootcamp.models;

import java.util.Date;

public class Administrativo extends Usuario{
    private String area;
    private String experiencia;

    public Administrativo() {
        super();
    }

    public Administrativo(String username, String nombres, String apellidos, Date fechaNacimiento, String rut, String password, String area, String experiencia) {
        super(username, nombres, apellidos, fechaNacimiento, rut, password);
        this.area = area;
        this.experiencia = experiencia;
    }

    public Administrativo(int id, String username, String nombres, String apellidos, Date fechaNacimiento, String rut, String password, String area, String experiencia) {
        super(id, username, nombres, apellidos, fechaNacimiento, rut, password);
        this.area = area;
        this.experiencia = experiencia;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }
}
