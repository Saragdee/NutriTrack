package com.example.NutriTrack.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "supplements_model")
public class SupplementModel {

    @Id
    private Integer attr_id;
    private String sup_name;
    private String sup_unit;
    private float f_dosage;
    private float m_dosage;

    // Getters and setters for each attribute
    public Integer getAttr_id() {
        return attr_id;
    }

    public void setAttr_id(Integer attr_id) {
        this.attr_id = attr_id;
    }

    public String getSup_name() {
        return sup_name;
    }

    public void setSup_name(String sup_name) {
        this.sup_name = sup_name;
    }

    public String getSup_unit() {
        return sup_unit;
    }

    public void setSup_unit(String sup_unit) {
        this.sup_unit = sup_unit;
    }

    public float getF_dosage() {
        return f_dosage;
    }

    public void setF_dosage(float f_dosage) {
        this.f_dosage = f_dosage;
    }

    public float getM_dosage() {
        return m_dosage;
    }

    public void setM_dosage(float m_dosage) {
        this.m_dosage = m_dosage;
    }
}
