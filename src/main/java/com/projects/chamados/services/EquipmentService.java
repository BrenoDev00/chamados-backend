package com.projects.chamados.services;

import com.projects.chamados.dtos.outputs.EquipmentOutputDTO;
import com.projects.chamados.repositories.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<EquipmentOutputDTO> listAll(){
        return this.equipmentRepository.findAll().stream()
                .map(equipment -> new EquipmentOutputDTO(equipment))
                .toList();
    }
}
