package tn.esprit.fakher_jemli_4arctic3.services;

import tn.esprit.fakher_jemli_4arctic3.entities.Registration;

import java.util.List;

public interface IRegistrationServices {
    Registration addRegistration (Registration registration);
    Registration updateRegistration (Registration registration);
    Registration retrieveRegistration (long numRegistration);
    void deleteRegistration (long numRegistration);
    List<Registration> retrieveAllRegistration();
}
