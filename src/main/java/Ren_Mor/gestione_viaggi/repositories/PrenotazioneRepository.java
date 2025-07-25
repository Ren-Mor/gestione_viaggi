package Ren_Mor.gestione_viaggi.repositories;

import Ren_Mor.gestione_viaggi.entities.Dipendente;
import Ren_Mor.gestione_viaggi.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {
    boolean existsByDipendenteAndDataRichiestaPrenotazione(Dipendente dipendente, LocalDate dataRichiestaPrenotazione);
}