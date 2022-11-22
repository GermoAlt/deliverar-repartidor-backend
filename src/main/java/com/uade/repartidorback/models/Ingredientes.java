package com.uade.repartidorback.models;

import com.google.gson.annotations.SerializedName;

public class Ingredientes {
    private String ingredient_id;
    private String name;

    public String getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(String ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
