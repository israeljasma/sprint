package org.bootcamp.models;

public class Capacitacion {
    private String id;
    private String rutCliente;
    private String dia;
    private String hora;
    private String lugar;
    private int duracion;
    private int cantidad;

    public Capacitacion() {
    }

    public Capacitacion(String rutCliente, String dia, String hora, String lugar, int duracion, int cantidad) {
        this.rutCliente = rutCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.duracion = duracion;
        this.cantidad = cantidad;
    }

    public Capacitacion(String id, String rutCliente, String dia, String hora, String lugar, int duracion, int cantidad) {
        this.id = id;
        this.rutCliente = rutCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.duracion = duracion;
        this.cantidad = cantidad;
    }
}
