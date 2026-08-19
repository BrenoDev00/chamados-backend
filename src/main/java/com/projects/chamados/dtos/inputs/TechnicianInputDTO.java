package com.projects.chamados.dtos.inputs;

import com.projects.chamados.enums.TechnicianShift;
import jakarta.validation.constraints.*;

public record TechnicianInputDTO (
        @NotBlank(message = "O nome é obrigatório.")
        @Size(min=3, max=64, message = "O nome deve ter entre 3 e 64 caracteres.")
        String name,
        @NotBlank(message = "O e-mail é obrigatório.")
        @Email(message = "Informe um formato de e-mail válido.")
        String email,
        @NotNull(message = "O turno é obrigatório. Valores aceitos: Noturno ou Diurno.")
        TechnicianShift shift
){
}
