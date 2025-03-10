package tn.esprit.fakher_jemli_4arctic3.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.fakher_jemli_4arctic3.entities.Piste;
import tn.esprit.fakher_jemli_4arctic3.services.IPisteServices;

import java.util.List;

public class PisteRestController {
    private IPisteServices pisteServices;
    @PostMapping("add")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteServices.addPiste(piste);
    }
    @PutMapping("update")
    public Piste update(@RequestBody Piste piste) {
        return pisteServices.updatePiste(piste);
    }
@GetMapping("get/{numPiste}")
    public Piste retrievePiste(@RequestBody long numPiste) {
        return pisteServices.retrievePiste(numPiste);
    }
    @DeleteMapping("delete/{numPiste}")
    public void deletePiste(@RequestBody long numPiste) {
         pisteServices.deletePiste(numPiste);
    }
   @GetMapping("all")
    public List<Piste> retrieveAll() {
   return pisteServices.retriveAll();
   }
}
