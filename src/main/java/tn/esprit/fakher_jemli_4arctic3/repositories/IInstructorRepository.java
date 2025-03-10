package tn.esprit.fakher_jemli_4arctic3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.fakher_jemli_4arctic3.entities.Instructor;
import tn.esprit.fakher_jemli_4arctic3.entities.Skier;

public interface IInstructorRepository extends JpaRepository<Instructor, Long> {

}
