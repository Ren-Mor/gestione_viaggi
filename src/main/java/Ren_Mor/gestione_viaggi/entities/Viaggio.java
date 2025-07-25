package Ren_Mor.gestione_viaggi.entities;

import Ren_Mor.gestione_viaggi.enums.StatoViaggio;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String destinazione;
    private LocalDate dataPartenza;
    @Enumerated(EnumType.STRING)
    private StatoViaggio stato;

    public Viaggio (){}

    public Viaggio(String destinazione, LocalDate dataPartenza, StatoViaggio stato) {
        this.destinazione = destinazione;
        this.dataPartenza = dataPartenza;
        this.stato = stato;
    }

    public int getId() {
        return id;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public LocalDate getDataPartenza() {
        return dataPartenza;
    }

    public void setDataPartenza(LocalDate dataPartenza) {
        this.dataPartenza = dataPartenza;
    }

    public StatoViaggio getStato() {
        return stato;
    }

    public void setStato(StatoViaggio stato) {
        this.stato = stato;
    }
}
