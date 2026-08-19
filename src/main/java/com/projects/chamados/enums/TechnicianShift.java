package com.projects.chamados.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TechnicianShift {
    DAYTIME("Diurno"),
    NIGHTTIME("Noturno");

    private String description;

    private TechnicianShift(String description){
        this.description = description;
    }

    @JsonValue
    public String getDescription(){
        return this.description;
    }
}
