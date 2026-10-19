package com.projects.chamados.repositories;

import com.projects.chamados.models.OpenTicket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OpenTicketRepository extends JpaRepository<OpenTicket, UUID> {
    Page<OpenTicket> findByIdChamadoContainingIgnoreCaseOrEquipment_IdSefitContainingIgnoreCaseOrderByIdChamadoDesc
            (String idChamado, String idSefit, Pageable pageable);

    Boolean existsByIdChamado(String idChamado);
}
