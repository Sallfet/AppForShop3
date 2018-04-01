package com.viktorkrasnovid.appforshop3.model;

public enum ProductListKind {
    RECIPE(1, "Recipe"),
    SHOPPING_LIST(2, "Shopping list");

    int id;
    String name;


    ProductListKind(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }
}
