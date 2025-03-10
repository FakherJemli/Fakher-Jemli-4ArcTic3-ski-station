package tn.esprit.fakher_jemli_4arctic3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.fakher_jemli_4arctic3.entities.Piste;
import tn.esprit.fakher_jemli_4arctic3.entities.Skier;
import tn.esprit.fakher_jemli_4arctic3.repositories.IPisteRepository;
import tn.esprit.fakher_jemli_4arctic3.repositories.ISkierRepository;

import java.util.List;

@Service
public class SkierServicesImpl implements ISkierServices {

    @Autowired
    private ISkierRepository skierRepository;
    @Override
    public Skier addSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier updateSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public void removeSkier(long numSkier) {
        skierRepository.deleteById(numSkier);;
    }

    @Override
    public Skier retrieveSkier(long numSkier) {
        return skierRepository.findById(numSkier).orElse(null);
    }
    public List<Skier> retriveAll() {
        return skierRepository.findAll();
    }
}
