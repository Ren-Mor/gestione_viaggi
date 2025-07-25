package Ren_Mor.gestione_viaggi.repositories;

import Ren_Mor.gestione_viaggi.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViaggioRepository extends JpaRepository<Viaggio, Integer> {}