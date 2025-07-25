package Ren_Mor.gestione_viaggi.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class DipendenteDTO {
    @NotBlank
    public String cognome;
    @NotBlank
    public String nome;
    @NotBlank
    public String username;
    @Email
    public String email;
}
