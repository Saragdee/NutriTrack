package com.example.NutriTrack.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "foodconsumption")
public class FoodConsumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FoodID")
    private Long id;

    @Column(name = "food_name")
    private String productName;
    @Column(name = "sup_name")
    private String supNameFromAPI;
    @Column(name = "log_date")
    private String date;
    @Column(name = "sup_quant")
    private String supQuantFromAPI;
    @Column(name = "attr_id")
    private Long attrIdFromAPI;

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

    public String getSupNameFromAPI() {
        return supNameFromAPI;
    }

    public void setSupNameFromAPI(String supNameFromAPI) {
        this.supNameFromAPI = supNameFromAPI;
    }

    public String getSupQuantFromAPI() {
        return supQuantFromAPI;
    }

    public void setSupQuantFromAPI(String supQuantFromAPI) {
        this.supQuantFromAPI = supQuantFromAPI;
    }

    public Long getAttrIdFromAPI() {
        return attrIdFromAPI;
    }

    public void setAttrIdFromAPI(Long attrIdFromAPI) {
        this.attrIdFromAPI = attrIdFromAPI;
    }
}
