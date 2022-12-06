package com.project.models;

public class Cart {
    private int id;
    private String nameDishCart;
    private Double priceEachDishCart;
    private int numberEachDishCart;
    private Double totalEachDishCart;

    public Cart(int id, String nameDishCart, Double priceEachDishCart, int numberEachDishCart, Double totalEachDishCart) {
        this.id = id;
        this.nameDishCart = nameDishCart;
        this.priceEachDishCart = priceEachDishCart;
        this.numberEachDishCart = numberEachDishCart;
        this.totalEachDishCart = totalEachDishCart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameDishCart() {
        return nameDishCart;
    }

    public void setNameDishCart(String nameDishCart) {
        this.nameDishCart = nameDishCart;
    }

    public Double getPriceEachDishCart() {
        return priceEachDishCart;
    }

    public void setPriceEachDishCart(Double priceEachDishCart) {
        this.priceEachDishCart = priceEachDishCart;
    }

    public int getNumberEachDishCart() {
        return numberEachDishCart;
    }

    public void setNumberEachDishCart(int numberEachDishCart) {
        this.numberEachDishCart = numberEachDishCart;
    }

    public Double getTotalEachDishCart() {
        return totalEachDishCart;
    }

    public void setTotalEachDishCart(Double totalEachDishCart) {
        this.totalEachDishCart = totalEachDishCart;
    }
}
