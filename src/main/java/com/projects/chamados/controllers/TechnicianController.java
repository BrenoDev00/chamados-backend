package com.projects.chamados.controllers;

import com.projects.chamados.dtos.outputs.TechnicianOutputDTO;
import com.projects.chamados.services.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
