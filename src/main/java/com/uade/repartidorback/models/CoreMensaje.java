package com.uade.repartidorback.models;

public class CoreMensaje {
    private Object mensaje;
    private String tipo;

    public CoreMensaje(Object mensaje, String tipo) {
        this.mensaje = mensaje;
        this.tipo = tipo;
    }

    public CoreMensaje() {

    }

    public Object getMensaje() {
        return mensaje;
    }

    public void setMensaje(Object mensaje) {
        this.mensaje = mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
