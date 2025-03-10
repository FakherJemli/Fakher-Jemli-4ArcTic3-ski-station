package tn.esprit.fakher_jemli_4arctic3.services;

import tn.esprit.fakher_jemli_4arctic3.entities.Piste;
import tn.esprit.fakher_jemli_4arctic3.entities.Skier;

import java.util.List;

public interface ISkierServices {
    public Skier addSkier(Skier skier);
    public Skier updateSkier(Skier skier);
    public void removeSkier(long numSkier );
    public Skier retrieveSkier(long numSkier);
    List<Skier> retriveAll();

}
