package com.projects.chamados.dtos.outputs;

import org.springframework.data.domain.Page;

import java.util.List;

public record OpenTicketListOutputDTO(
        Long total,
        List<OpenTicketOutputDTO> items
) {
    public OpenTicketListOutputDTO(Page<OpenTicketOutputDTO> openTickets){
        this(openTickets.getTotalElements(), openTickets.getContent());
    }
}
