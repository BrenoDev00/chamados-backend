package com.projects.chamados.repositories;

import com.projects.chamados.models.Equipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentRepository extends JpaRepository<Equipment, UUID> {
    Page<Equipment> findByLocationContainingIgnoreCaseOrIdSefitContainingIgnoreCase(String location, String idSefit, Pageable pageable);

    Boolean existsByIdSefitIgnoreCase(String idSefit);

    Boolean existsByIdSefitIgnoreCaseAndIdNot(String idSefit, UUID id);
}
