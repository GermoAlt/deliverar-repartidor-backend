package com.uade.repartidorback.models;

import com.uade.repartidorback.entities.User;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

public class OrdenFranquicia {

    private int order_id;
    private String order_status;
    private String franchise_address;
    private String client_address;
    private List <Comidas> comidas;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getFranchise_address() {
        return franchise_address;
    }

    public void setFranchise_address(String franchise_address) {
        this.franchise_address = franchise_address;
    }

    public String getClient_address() {
        return client_address;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address;
    }

    public List<Comidas> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comidas> comidas) {
        this.comidas = comidas;
    }
}
