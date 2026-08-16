package com.projects.chamados.dtos.outputs;

import com.projects.chamados.enums.EquipmentType;
import com.projects.chamados.models.Equipment;

import java.util.UUID;

public record EquipmentOutputDTO(
        UUID id,
        String location,
        String idSefit,
        EquipmentType type,
        String serialNumber,
        UUID technicianId
) {
    public EquipmentOutputDTO(Equipment equipment){
        this(
                equipment.getId(),
                equipment.getLocation(),
                equipment.getIdSefit(),
                equipment.getType(),
                equipment.getSerialNumber(),
                equipment.getTechnician().getId()
        );
    }
}
