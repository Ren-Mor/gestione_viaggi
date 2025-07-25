package Ren_Mor.gestione_viaggi.repositories;



import Ren_Mor.gestione_viaggi.entities.Dipendente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DipendenteRepository extends JpaRepository<Dipendente, Integer> {
    Optional<Object> findByEmail(@Email @NotBlank(message = "Non può essere vuoto") String email);
}
