package Ren_Mor.gestione_viaggi.payloads;

import Ren_Mor.gestione_viaggi.enums.StatoViaggio;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class ViaggioDTO {
        @NotBlank
        public String destinazione;
        @NotBlank
        public LocalDate dataPartenza;
        @NotBlank
        public StatoViaggio stato;
}
