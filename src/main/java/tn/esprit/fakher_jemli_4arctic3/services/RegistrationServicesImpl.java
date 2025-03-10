package tn.esprit.fakher_jemli_4arctic3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.fakher_jemli_4arctic3.entities.Registration;
import tn.esprit.fakher_jemli_4arctic3.repositories.IRegistrationRepository;

import java.util.List;
@Service
public class RegistrationServicesImpl implements  IRegistrationServices{
    @Autowired
    IRegistrationRepository registrationRepository;

    @Override
    public Registration addRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration updateRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration retrieveRegistration(long numRegistration) {
        return registrationRepository.findById(numRegistration).orElse(null);
    }

    @Override
    public void deleteRegistration(long numRegistration) {
        registrationRepository.deleteById(numRegistration);

    }

    @Override
    public List<Registration> retrieveAllRegistration() {
        return registrationRepository.findAll();
    }
}
