package Ren_Mor.gestione_viaggi.payloads;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record PrenotazioneDTO(
        @NotBlank(message = "Id del dipendente obbligatorio")
        Integer dipendenteId,
        @NotBlank(message = "Id del viaggio obbligatorio")
        Integer ViaggioId,
        @NotBlank(message = "Data richiesta obbligatoria")
        LocalDate dataRichiesta,
        String note) {
}
