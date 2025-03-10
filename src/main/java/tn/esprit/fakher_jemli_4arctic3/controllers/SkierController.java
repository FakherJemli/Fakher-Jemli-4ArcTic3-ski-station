package tn.esprit.fakher_jemli_4arctic3.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.fakher_jemli_4arctic3.entities.Piste;
import tn.esprit.fakher_jemli_4arctic3.entities.Skier;
import tn.esprit.fakher_jemli_4arctic3.services.ISkierServices;

import java.util.List;

@RequestMapping("skier")
public class SkierController {
    private ISkierServices skierServices;
    @PostMapping("add")
   public Skier addSkier(@RequestBody Skier skier){
        return skierServices.addSkier(skier);
    }
    @PutMapping("update")
    public Skier update(@RequestBody Skier skier) {
        return skierServices.updateSkier(skier);
    }
    @GetMapping("get/{numSkier}")
    public Skier retrieveSkier(@RequestBody long numSkier) {
        return skierServices.retrieveSkier(numSkier);
    }
    @DeleteMapping("delete/{numSkier}")
    public void deleteSkier(@RequestBody long numSkier) {
        skierServices.removeSkier(numSkier);
    }
    @GetMapping("all")
    public List<Skier> retrieveAll() {
        return skierServices.retriveAll();
    }
}
