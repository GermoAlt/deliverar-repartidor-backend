package com.uade.repartidorback.models;

public class ClienteMensaje {
    private String status;
    private String latitud;
    private String longitud;
    private String orderType;
    private int order_id;
    private String repartidor_id;
    private String username;

    public ClienteMensaje() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getRepartidor_id() {
        return repartidor_id;
    }

    public void setRepartidor_id(String repartidor_id) {
        this.repartidor_id = repartidor_id;
    }
}
