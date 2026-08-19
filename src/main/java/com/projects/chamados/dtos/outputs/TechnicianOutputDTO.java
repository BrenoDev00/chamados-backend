package com.projects.chamados.dtos.outputs;

import com.projects.chamados.enums.TechnicianShift;
import com.projects.chamados.models.Technician;

import java.util.UUID;

public record TechnicianOutputDTO(
        UUID id,
        String name,
        String email,
        TechnicianShift shift
) {

    public TechnicianOutputDTO(Technician technician){
        this(
                technician.getId(),
                technician.getName(),
                technician.getEmail(),
                technician.getShift()
        );
    }
}
