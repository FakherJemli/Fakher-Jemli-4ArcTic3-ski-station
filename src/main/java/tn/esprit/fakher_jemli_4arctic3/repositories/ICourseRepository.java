package tn.esprit.fakher_jemli_4arctic3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.fakher_jemli_4arctic3.entities.Course;

public interface ICourseRepository extends JpaRepository<Course, Long> {
}
