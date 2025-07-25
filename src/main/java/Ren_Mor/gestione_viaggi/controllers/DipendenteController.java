package Ren_Mor.gestione_viaggi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import Ren_Mor.gestione_viaggi.entities.Dipendente;
import Ren_Mor.gestione_viaggi.exceptions.ValidationException;
import Ren_Mor.gestione_viaggi.payloads.DipendenteDTO;
import Ren_Mor.gestione_viaggi.services.DipendenteService;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping
    public List<Dipendente> findAll() {
        return dipendenteService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente save(@RequestBody @Validated DipendenteDTO payload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            throw new ValidationException(validationResult.getFieldErrors()
                    .stream().map(fieldError -> fieldError.getDefaultMessage()).toList());
        }
        return dipendenteService.save(payload);
    }

    @GetMapping("/{id}")
    public Dipendente getById(@PathVariable int id) {
        return dipendenteService.findById(id);
    }

    @PutMapping("/{id}")
    public Dipendente update(@PathVariable int id, @RequestBody @Validated DipendenteDTO payload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            throw new ValidationException(validationResult.getFieldErrors()
                    .stream().map(fieldError -> fieldError.getDefaultMessage()).toList());
        }
        return dipendenteService.update(id, payload);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        dipendenteService.delete(id);
    }

    @PatchMapping("/{id}/immagine-profilo")
    public String uploadImmagineProfilo(@PathVariable int id, @RequestParam("file") MultipartFile file) {
        return dipendenteService.uploadImmagineProfilo(id, file);
    }
}
