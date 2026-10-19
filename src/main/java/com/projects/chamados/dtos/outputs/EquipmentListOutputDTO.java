package com.projects.chamados.dtos.outputs;

import org.springframework.data.domain.Page;

import java.util.List;

public record EquipmentListOutputDTO(
        Long total,
        List<EquipmentOutputDTO> items
) {
    public EquipmentListOutputDTO(Page<EquipmentOutputDTO> equipments){
        this(equipments.getTotalElements(), equipments.getContent());
    }
}
