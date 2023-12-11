package com.example.NutriTrack.domain;

import java.util.List;

public class FoodConsumptionRequest {
    private String date;

    private String value;

    private String attrId;

    // Getters and setters for 'date' and 'nutrients'
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Getters and setters for 'name' and 'value'
    public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
