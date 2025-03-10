package tn.esprit.fakher_jemli_4arctic3.services;

import tn.esprit.fakher_jemli_4arctic3.entities.Piste;

import java.util.List;

public interface IPisteServices {

    Piste addPiste(Piste piste);
    Piste updatePiste(Piste piste);
    Piste retrievePiste(long numPiste);
    void deletePiste(long numPiste);
    List<Piste> retriveAll();
}
