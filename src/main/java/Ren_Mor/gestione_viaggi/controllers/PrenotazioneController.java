package Ren_Mor.gestione_viaggi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import Ren_Mor.gestione_viaggi.entities.Prenotazione;
import Ren_Mor.gestione_viaggi.exceptions.ValidationException;
import Ren_Mor.gestione_viaggi.payloads.PrenotazioneDTO;
import Ren_Mor.gestione_viaggi.services.PrenotazioneService;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @GetMapping
    public List<Prenotazione> findAll() {
        return prenotazioneService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazione save(@RequestBody @Validated PrenotazioneDTO payload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            throw new ValidationException(validationResult.getFieldErrors()
                    .stream().map(fieldError -> fieldError.getDefaultMessage()).toList());
        }
        return prenotazioneService.save(payload);
    }

    @GetMapping("/{id}")
    public Prenotazione getById(@PathVariable int id) {
        return prenotazioneService.findById(id);
    }

    @PutMapping("/{id}")
    public Prenotazione update(@PathVariable int id, @RequestBody @Validated PrenotazioneDTO payload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            throw new ValidationException(validationResult.getFieldErrors()
                    .stream().map(fieldError -> fieldError.getDefaultMessage()).toList());
        }
        return prenotazioneService.update(id, payload);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        prenotazioneService.delete(id);
    }
}
