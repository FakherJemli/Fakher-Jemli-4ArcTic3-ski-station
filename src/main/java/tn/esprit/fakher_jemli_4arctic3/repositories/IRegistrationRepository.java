package tn.esprit.fakher_jemli_4arctic3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.fakher_jemli_4arctic3.entities.Registration;

public interface IRegistrationRepository extends JpaRepository<Registration, Long> {
}
