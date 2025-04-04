package tn.esprit.fakher_jemli_4arctic3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.fakher_jemli_4arctic3.entities.Course;
import tn.esprit.fakher_jemli_4arctic3.entities.Registration;
import tn.esprit.fakher_jemli_4arctic3.entities.Skier;
import tn.esprit.fakher_jemli_4arctic3.entities.TypeCourse;
import tn.esprit.fakher_jemli_4arctic3.repositories.ICourseRepository;
import tn.esprit.fakher_jemli_4arctic3.repositories.IRegistrationRepository;
import tn.esprit.fakher_jemli_4arctic3.repositories.ISkierRepository;

import java.util.List;
@Service
public class RegistrationServicesImpl implements  IRegistrationServices{
    @Autowired
    IRegistrationRepository registrationRepository;
    ISkierRepository skierRepository;
    ICourseRepository courseRepository;

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
    @Override
    public Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkieur) {

        Skier skier = skierRepository.findById(numSkieur).orElse(null);
        if (skier == null) {
            return null;
        }

        Registration savedRegistration = registrationRepository.save(registration);

        skier.getRegistrations().add(savedRegistration);

        skierRepository.save(skier);

        return savedRegistration;
    }

    @Override
    public Registration assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Registration registration = registrationRepository.findById(numRegistration).orElse(null);

        Course course = courseRepository.findById(numCourse).orElse(null);

        if (registration == null || course == null) {
            return null;
        }

        registration.setCourse(course);

        return registrationRepository.save(registration);
    }

    @Override
    public Registration addRegistrationAndAssignToSkierAndCourse(Registration registration, Long numSkier, Long numCourse) {
        Skier skier = skierRepository.findById(numSkier).orElse(null);
        Course course = courseRepository.findById(numCourse).orElse(null);

        if (skier == null || course == null) {
            return null;
        }

        if ((course.getTypeCourse() == TypeCourse.COLLECTIVE_CHILDREN ||
                course.getTypeCourse() == TypeCourse.COLLECTIVE_ADULT) &&
                course.getRegistrations().size() >= 6) {
            return null;
        }

        registration.setCourse(course);
        Registration savedRegistration = registrationRepository.save(registration);

        skier.getRegistrations().add(savedRegistration);

        // Mettre à jour le skieur
        skierRepository.save(skier);

        return savedRegistration;
    }
}
