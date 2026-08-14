package com.projects.chamados.dtos.inputs;

import com.projects.chamados.enums.TechnicianShift;
import jakarta.validation.constraints.*;

public record TechnicianInputDTO (
        @NotBlank(message = "O nome é obrigatório.")
        @Min(value = 3, message = "Mínimo 3 caracteres.")
        @Max(value = 84, message = "Máximo 64 caracteres.")
        String name,
        @NotBlank(message = "O e-mail é obrigatório.")
        @Email(message = "Informe um formato válido.")
        String email,
        @NotNull(message = "O turno é obrigatório. Valores aceitos: DAYTIME ou NIGHTTIME.")
        TechnicianShift shift
){
}
