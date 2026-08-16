package com.projects.chamados.controllers;

import com.projects.chamados.dtos.outputs.EquipmentOutputDTO;
import com.projects.chamados.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/equipments")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @GetMapping
    public ResponseEntity<List<EquipmentOutputDTO>> getAll(){
        var equipments = this.equipmentService.listAll();

        return ResponseEntity.ok().body(equipments);
    }
}
