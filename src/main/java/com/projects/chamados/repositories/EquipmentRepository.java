package com.projects.chamados.repositories;

import com.projects.chamados.models.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EquipmentRepository extends JpaRepository<Equipment, UUID> {
    List<Equipment> findByLocationContainingIgnoreCaseOrIdSefitContainingIgnoreCase(String location, String idSefit);

    Boolean existsByIdSefitIgnoreCase(String idSefit);

    Boolean existsByIdSefitIgnoreCaseAndIdNot(String idSefit, UUID id);
}
