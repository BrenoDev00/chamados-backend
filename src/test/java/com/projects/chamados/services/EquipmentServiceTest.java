package com.projects.chamados.services;

import com.projects.chamados.exceptions.NotFoundException;
import com.projects.chamados.models.Equipment;
import com.projects.chamados.repositories.EquipmentRepository;
import com.projects.chamados.utils.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static com.projects.chamados.constants.EquipmentConstants.EQUIPMENT_ID;
import static com.projects.chamados.constants.EquipmentConstants.EQUIPMENT_ONE;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EquipmentServiceTest {
    @InjectMocks
    private EquipmentService equipmentService;

    @Mock
    private EquipmentRepository equipmentRepository;

    @Test
    public void findIfExists(){
        when(this.equipmentRepository.findById(EQUIPMENT_ID)).thenReturn(Optional.of(EQUIPMENT_ONE));

        var equipment = this.equipmentService.findIfExists(EQUIPMENT_ID);

        assertThat(equipment).isEqualTo(EQUIPMENT_ONE);
    }

    @Test
    public void findIfExistsThrowsException(){
        when(this.equipmentRepository.findById(EQUIPMENT_ID))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> this.equipmentService.findIfExists(EQUIPMENT_ID))
                .isInstanceOf(NotFoundException.class)
                .hasMessage(Constants.EQUIPMENT_NOT_FOUND);
    }

    @Test
    public void listAllBySearch(){
        var searchTerm = "BR 070";
        var page = PageRequest.of(0, 10);
        Page<Equipment> equipmentPage = new PageImpl<>(List.of(EQUIPMENT_ONE), page, 1);

        when(this.equipmentRepository
                .findByLocationContainingIgnoreCaseOrIdSefitContainingIgnoreCase(searchTerm, searchTerm, page))
                .thenReturn(equipmentPage);

        var equipmentList = this.equipmentService.listAllBySearch(searchTerm, page);

        assertThat(equipmentList.total()).isEqualTo(1);
        assertThat(equipmentList.items().getFirst()).isEqualTo(EQUIPMENT_ONE);
        assertThat(equipmentList.items().size()).isEqualTo(1);
    }

    @Test
    public void listAllBySearchReturnsEmptyPage(){
        var searchTerm = "Inexistente";
        var page = PageRequest.of(0, 10);

        when(this.equipmentRepository
                .findByLocationContainingIgnoreCaseOrIdSefitContainingIgnoreCase(searchTerm, searchTerm, page))
                .thenReturn(Page.empty(page));

        var equipmentList = this.equipmentService.listAllBySearch(searchTerm, page);

        assertThat(equipmentList.total()).isEqualTo(0);
        assertThat(equipmentList.items().size()).isEqualTo(0);
    }

    @Test
    public void deleteById(){
        when(this.equipmentRepository.findById(EQUIPMENT_ID))
                .thenReturn(Optional.of(EQUIPMENT_ONE));

        assertThatCode(() ->
                this.equipmentService.deleteById(EQUIPMENT_ID)).doesNotThrowAnyException();
    }
}
