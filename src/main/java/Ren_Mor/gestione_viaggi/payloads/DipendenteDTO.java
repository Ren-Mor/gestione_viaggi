package Ren_Mor.gestione_viaggi.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DipendenteDTO(
        @NotBlank(message = "Non può essere vuoto")
        String username,
        @NotBlank(message = "Non può essere vuoto")
        String nome,
        @NotBlank(message = "Non può essere vuoto")
        String cognome,
        @Email
        @NotBlank(message = "Non può essere vuoto")
        String email){}



