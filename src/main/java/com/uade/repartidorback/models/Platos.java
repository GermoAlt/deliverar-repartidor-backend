package com.uade.repartidorback.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Platos {
    private String meal_id;
    private String name;
    private String photo_url;
    private double price;
    private List<Ingredientes> ingredients;

    public String getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(String meal_id) {
        this.meal_id = meal_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Ingredientes> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredientes> ingredients) {
        this.ingredients = ingredients;
    }
}
