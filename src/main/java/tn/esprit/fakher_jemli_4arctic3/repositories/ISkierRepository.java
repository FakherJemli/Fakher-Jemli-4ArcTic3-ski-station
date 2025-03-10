package tn.esprit.fakher_jemli_4arctic3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.fakher_jemli_4arctic3.entities.Skier;

import java.util.List;

public interface ISkierRepository extends JpaRepository<Skier,Long> {
List<Skier> findByFirstNameAndLastName(String fName, String lName);
}
