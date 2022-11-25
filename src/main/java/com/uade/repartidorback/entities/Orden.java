package com.uade.repartidorback.entities;

import com.uade.repartidorback.models.Platos;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "orders")
public class Orden {
    private String id;
    private String name;
    private String orderType;
    private int orderId;
    private String orderStatus;
    private String franchise_address;
    private String client_address;
    private List <Platos> meals;
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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

    public List<Platos> getMeals() {
        return meals;
    }

    public void setMeals(List<Platos> meals) {
        this.meals = meals;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
