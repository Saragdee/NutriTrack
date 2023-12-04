package com.example.NutriTrack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "foodconsumption")
public class FoodConsumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FoodID")
    private Long id;

    @Column(name = "food_name")
    private String productName;
    @Column(name = "log_date")
    private String date;
    @Column(name = "food_quant")
    private double quantity;
    @Column(name = "food_unit")
    private String unit;

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    // Getters and setters
}
