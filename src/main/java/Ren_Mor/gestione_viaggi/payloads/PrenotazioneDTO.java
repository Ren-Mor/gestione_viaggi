package Ren_Mor.gestione_viaggi.payloads;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class PrenotazioneDTO {
    @NotBlank
    public int id;
    @NotBlank
    public int viaggioId;
    @NotBlank
    public int dipendenteId;
    @NotBlank
    public LocalDate dataRichiestaPrenotazione;
}