package tn.esprit.fakher_jemli_4arctic3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.fakher_jemli_4arctic3.entities.*;
import tn.esprit.fakher_jemli_4arctic3.repositories.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkierServicesImpl implements ISkierServices {

    @Autowired
    ISkierRepository skierRepository;
    IPisteRepository pisteRepository;
    ICourseRepository courseRepository;
    IRegistrationRepository registrationRepository;
    ISubscriptionRepository subscriptionRepository;
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
    @Override
    public Skier assignSkierToPiste(Long numSkier, Long numPiste) {
        Skier skier = skierRepository.findById(numSkier).orElse(null);
        Piste piste = pisteRepository.findById(numPiste).orElse(null);
        if (skier == null || piste == null) {
            return null;
        }
        skier.getPistes().add(piste);
        return skierRepository.save(skier);
    }

    @Override
    public Skier addSkierAndAssignToCourse(Skier skier, Long numCourse) {
        Course course = courseRepository.findById(numCourse).orElse(null);
        if (course == null) {
            return null;
        }
        Skier savedSkier = skierRepository.save(skier);

        Registration registration = new Registration();
        registration.setSkier(savedSkier);
        registration.setCourse(course);
        registrationRepository.save(registration);
        Subscription subscription = new Subscription();
        subscription.setSkier(savedSkier);
        subscriptionRepository.save(subscription);
        return skierRepository.findById(savedSkier.getNumSkier()).orElse(null);
    }

    @Override
    public List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription typeSubscription) {
        List<Skier> allSkiers = skierRepository.findAll();
        return allSkiers.stream()
                .filter(skier -> skier.getSubscription() != null &&
                        skier.getSubscription().getTypeSubscription() == typeSubscription)
                .collect(Collectors.toList());
    }
}
