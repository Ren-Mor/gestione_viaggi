package Ren_Mor.gestione_viaggi.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import Ren_Mor.gestione_viaggi.entities.Dipendente;
import Ren_Mor.gestione_viaggi.exceptions.BadRequestException;
import Ren_Mor.gestione_viaggi.exceptions.ResourceNotFoundException;
import Ren_Mor.gestione_viaggi.payloads.DipendenteDTO;
import Ren_Mor.gestione_viaggi.repositories.DipendenteRepository;


import java.util.List;

@Service
@Slf4j
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private Cloudinary cloudinaryUploader;

    public Dipendente save(DipendenteDTO body) {
        dipendenteRepository.findByEmail(body.email()).ifPresent(d -> {
            throw new BadRequestException("Email già in uso");
        });
        Dipendente d = new Dipendente(body.cognome(), body.nome(), body.username(), body.email());
        d.setImmagineProfilo("https://" + body.nome() + "+" + body.cognome());
        Dipendente saved = dipendenteRepository.save(d);
        log.info("Dipendente con id: " + saved.getId() + " salvato correttamente!");
        return saved;
    }

    public List<Dipendente> getAll() {
        return dipendenteRepository.findAll();
    }

    public Dipendente findById(int id) {
        return dipendenteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Il dipendente non esiste"));
    }

    public Dipendente update(int id, DipendenteDTO body) {
        Dipendente found = findById(id);
        if (!found.getEmail().equals(body.email()))
            dipendenteRepository.findByEmail(body.email()).ifPresent(d -> {
                throw new BadRequestException("Email già in uso");
            });
        found.setCognome(body.cognome());
        found.setNome(body.nome());
        found.setUsername(body.username());
        found.setEmail(body.email());
        found.setImmagineProfilo("https://ui-avatars.com/api/?name=" + body.nome() + "+" + body.cognome());
        Dipendente modified = dipendenteRepository.save(found);
        log.info("Dipendente con id: " + found.getId() + " modificato!");
        return modified;
    }

    public void delete(int id) {
        Dipendente found = findById(id);
        dipendenteRepository.delete(found);
    }

    public String uploadImmagineProfilo(int id, MultipartFile file) {
        Dipendente d = findById(id);
        try {
            String url = (String) cloudinaryUploader.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
            d.setImmagineProfilo(url);
            dipendenteRepository.save(d);
            return url;
        } catch (Exception e) {
            throw new BadRequestException("Errore nel salvataggio dell'immagine profilo!");
        }
    }
}