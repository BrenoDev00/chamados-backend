package com.projects.chamados.services;

import com.projects.chamados.exceptions.NotFoundException;
import com.projects.chamados.repositories.TechnicianRepository;
import com.projects.chamados.utils.Constants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

import static com.projects.chamados.constants.TechnicianConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TechnicianServiceTest {
    @InjectMocks
    private TechnicianService technicianService;

    @Mock
    private TechnicianRepository technicianRepository;

    @AfterEach
    public void clearSecurityContext(){
        SecurityContextHolder.clearContext();
    }

    private void authenticateTechnician(String email){
        var auth = new UsernamePasswordAuthenticationToken(email, null, null);

        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    @Test
    public void findIfExists(){
        when(this.technicianRepository.findById(TECHNICIAN_ID))
                .thenReturn(Optional.of(TECHNICIAN_ONE));

        var technician = this.technicianService.findIfExists(TECHNICIAN_ID);

        assertThat(technician).isEqualTo(TECHNICIAN_ONE);
    }

    @Test
    public void findIfExistsThrowsException(){
        when(this.technicianRepository.findById(TECHNICIAN_ID))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> this.technicianService.findIfExists(TECHNICIAN_ID))
                .isInstanceOf(NotFoundException.class)
                .hasMessage(Constants.TECHNICIAN_NOT_FOUND);
    }

    @Test
    public void findAuthenticated(){
        String technicianEmail = TECHNICIAN_ONE.getEmail();
        this.authenticateTechnician(technicianEmail);

        when(this.technicianRepository.findByEmailIgnoreCase(technicianEmail))
                .thenReturn(Optional.of(TECHNICIAN_ONE));

        var technician = this.technicianService.findAuthenticated();

        assertThat(technician).isEqualTo(TECHNICIAN_ONE);
    }

    @Test
    public void findAuthenticatedThrowsException(){
        String technicianEmail = TECHNICIAN_ONE.getEmail();
        this.authenticateTechnician(technicianEmail);

        when(this.technicianRepository.findByEmailIgnoreCase(technicianEmail))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> this.technicianService.findAuthenticated())
                .isInstanceOf(NotFoundException.class)
                .hasMessage(Constants.TECHNICIAN_NOT_FOUND);
    }

    @Test
    public void listAll(){
        when(technicianRepository.findAllWithoutPassword()).thenReturn(TECHNICIAN_LIST);

        var technicianList = this.technicianService.listAll();

        assertThat(technicianList).isEqualTo(TECHNICIAN_LIST);
    }

   //fazer testes dos métodos updateById e loadUserByUsername

}
