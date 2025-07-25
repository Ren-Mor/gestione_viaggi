package Ren_Mor.gestione_viaggi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    private int id;

    private String cognome;
    private String nome;
    private String username;
    private String email;

    public Dipendente(){}

    public Dipendente(String cognome, String nome, String username, String email) {
        this.cognome = cognome;
        this.nome = nome;
        this.username = username;
        this.email = email;
    }

    public int getId() {
        return id;
    }


    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
