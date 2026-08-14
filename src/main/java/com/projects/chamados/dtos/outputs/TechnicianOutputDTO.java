package com.projects.chamados.dtos.outputs;

import com.projects.chamados.enums.TechnicianShift;

import java.util.UUID;

public record TechnicianOutputDTO(
        UUID id,
        String name,
        String email,
        TechnicianShift shift
) {
}
