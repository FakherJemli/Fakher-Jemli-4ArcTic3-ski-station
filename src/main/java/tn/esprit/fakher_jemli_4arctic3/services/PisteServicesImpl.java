package tn.esprit.fakher_jemli_4arctic3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.fakher_jemli_4arctic3.entities.Piste;
import tn.esprit.fakher_jemli_4arctic3.repositories.IPisteRepository;

import java.util.List;
@Service

public class PisteServicesImpl implements IPisteServices {
    @Autowired
    private IPisteRepository pisteRepository;
    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste retrievePiste(long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }

    @Override
    public void deletePiste(long numPiste) {
pisteRepository.deleteById(numPiste);
    }

    @Override
    public List<Piste> retriveAll() {
        return pisteRepository.findAll();
    }
}
