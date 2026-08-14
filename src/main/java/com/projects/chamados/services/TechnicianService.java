package com.projects.chamados.services;

import com.projects.chamados.dtos.outputs.TechnicianOutputDTO;
import com.projects.chamados.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianService {
    public TechnicianService(){}

    @Autowired
    private TechnicianRepository technicianRepository;

    public List<TechnicianOutputDTO> listAll(){
        return this.technicianRepository.findAllWithoutPassword();
    }
}
