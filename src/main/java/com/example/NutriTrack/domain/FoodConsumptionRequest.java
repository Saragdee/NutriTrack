package com.example.NutriTrack.domain;

public class FoodConsumptionRequest {
    private String date;

    private Float value;

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

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
