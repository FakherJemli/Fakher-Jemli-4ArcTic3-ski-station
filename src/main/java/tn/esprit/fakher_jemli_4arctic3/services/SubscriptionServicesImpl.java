package tn.esprit.fakher_jemli_4arctic3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.fakher_jemli_4arctic3.entities.Subscription;
import tn.esprit.fakher_jemli_4arctic3.entities.TypeSubscription;
import tn.esprit.fakher_jemli_4arctic3.repositories.ISubscriptionRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;

@Service
public class SubscriptionServicesImpl implements ISubscriptionServices{
    @Autowired
    ISubscriptionRepository subscriptionRepository;

    @Override
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription retrieveSubscription(long numSubscription) {
        return subscriptionRepository.findById(numSubscription).orElse(null);
    }

    @Override
    public void deleteSubscription(long numSubscription) {
        subscriptionRepository.deleteById(numSubscription);

    }

    @Override
    public List<Subscription> retrieveAllSubscription() {
        return subscriptionRepository.findAll();
    }
    @Override
    public Set<Subscription> getSubscriptionByType(TypeSubscription type) {
        List<Subscription> allSubscriptions = subscriptionRepository.findAll();

        Set<Subscription> filteredSubscriptions = allSubscriptions.stream()
                .filter(subscription -> subscription.getTypeSubscription() == type)
                .sorted(Comparator.comparing(Subscription::getStartDate))
                .collect(Collectors.toCollection(HashSet::new));

        return filteredSubscriptions;
    }

    @Override
    public List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        List<Subscription> allSubscriptions = subscriptionRepository.findAll();
        return allSubscriptions.stream()
                .filter(subscription -> {
                    LocalDate creationDate = subscription.getStartDate();
                    return (creationDate.isEqual(startDate) || creationDate.isAfter(startDate)) &&
                            (creationDate.isEqual(endDate) || creationDate.isBefore(endDate));
                })
                .collect(Collectors.toList());
    }
}
