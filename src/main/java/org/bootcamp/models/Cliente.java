package org.bootcamp.models;

import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Usuario {
    private int telefono;
    private String afp;
    private int sistemaSalud;
    private String direccion;
    private String comuna;
    private int edad;
    private ArrayList<Capacitacion> capacitaciones;

    public Cliente() {
        super();
        this.capacitaciones = new ArrayList<>();
    }

    public Cliente(String username, String nombres, String apellidos, Date fechaNacimiento, String rut, int rol, String password, int telefono, String afp, int sistemaSalud, String direccion, String comuna, int edad) {
        super(username, nombres, apellidos, fechaNacimiento, rut, rol, password);
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaSalud = sistemaSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
        this.capacitaciones = new ArrayList<>();
    }

    public Cliente(int id, String username, String nombres, String apellidos, Date fechaNacimiento, String rut, int rol, String password, int telefono, String afp, int sistemaSalud, String direccion, String comuna, int edad) {
        super(id, username, nombres, apellidos, fechaNacimiento, rut, rol, password);
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaSalud = sistemaSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
        this.capacitaciones = new ArrayList<>();
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public int getSistemaSalud() {
        return sistemaSalud;
    }

    public void setSistemaSalud(int sistemaSalud) {
        this.sistemaSalud = sistemaSalud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
