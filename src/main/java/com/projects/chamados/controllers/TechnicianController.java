package com.projects.chamados.controllers;

import com.projects.chamados.dtos.inputs.TechnicianInputDTO;
import com.projects.chamados.dtos.outputs.TechnicianOutputDTO;
import com.projects.chamados.services.TechnicianService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="/technicians")
public class TechnicianController {
    @Autowired
    private TechnicianService technicianService;

    @GetMapping
    public ResponseEntity<List<TechnicianOutputDTO>> getAll(){
        var technicians = this.technicianService.listAll();

        return ResponseEntity.ok().body(technicians);
    }

    @PutMapping(value = "/{technicianId}")
    public ResponseEntity<TechnicianOutputDTO> put(@PathVariable UUID technicianId, @Valid @RequestBody TechnicianInputDTO technician){
        var updatedTechnician = this.technicianService.updateById(technicianId, technician);

        return ResponseEntity.ok().body(updatedTechnician);
    }
}
