package com.uade.repartidorback.models;

public class OperadorMensaje {
    private String status;
    private String name;
    private String client_address;
    private String franchise_address;
    private String orderType;
    private int order_id;
    private String repartidor_id;

    public OperadorMensaje() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClient_address() {
        return client_address;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address;
    }

    public String getFranchise_address() {
        return franchise_address;
    }

    public void setFranchise_address(String franchise_address) {
        this.franchise_address = franchise_address;
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
