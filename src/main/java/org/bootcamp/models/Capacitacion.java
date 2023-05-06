package org.bootcamp.models;

import java.time.LocalTime;
import java.util.Date;

public class Capacitacion {
    private int id;
    private String rutCliente;
    private Date dia;
    private LocalTime hora;
    private String lugar;
    private int duracion;
    private int cantidad;

    public Capacitacion() {
    }

    public Capacitacion(String rutCliente, Date dia, LocalTime hora, String lugar, int duracion, int cantidad) {
        this.rutCliente = rutCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.duracion = duracion;
        this.cantidad = cantidad;
    }

    public Capacitacion(int id, String rutCliente, Date dia, LocalTime hora, String lugar, int duracion, int cantidad) {
        this.id = id;
        this.rutCliente = rutCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.duracion = duracion;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
