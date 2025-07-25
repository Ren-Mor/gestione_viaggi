package Ren_Mor.gestione_viaggi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_viaggio")
    private Viaggio viaggio;

    @ManyToOne
    @JoinColumn(name = "id_dipendente")
    private Dipendente dipendente;

    private LocalDate dataRichiestaPrenotazione;

    public Prenotazione(){}

    public Prenotazione(Viaggio viaggio, Dipendente dipendente, LocalDate dataRichiestaPrenotazione) {
        this.viaggio = viaggio;
        this.dipendente = dipendente;
        this.dataRichiestaPrenotazione = dataRichiestaPrenotazione;
    }

    public int getId() {
        return id;
    }

    public Viaggio getViaggio() {
        return viaggio;
    }

    public void setViaggio(Viaggio viaggio) {
        this.viaggio = viaggio;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public LocalDate getDataRichiestaPrenotazione() {
        return dataRichiestaPrenotazione;
    }

    public void setDataRichiestaPrenotazione(LocalDate dataRichiestaPrenotazione) {
        this.dataRichiestaPrenotazione = dataRichiestaPrenotazione;
    }
}
