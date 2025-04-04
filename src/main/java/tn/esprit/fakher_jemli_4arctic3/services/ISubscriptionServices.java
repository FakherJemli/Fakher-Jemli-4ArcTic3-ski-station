package tn.esprit.fakher_jemli_4arctic3.services;

import tn.esprit.fakher_jemli_4arctic3.entities.Subscription;
import tn.esprit.fakher_jemli_4arctic3.entities.TypeSubscription;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ISubscriptionServices {
    Subscription addSubscription (Subscription subscription);
    Subscription updateSubscription (Subscription subscription);
    Subscription retrieveSubscription (long numSubscription);
    void deleteSubscription (long numSubscription);
    List<Subscription> retrieveAllSubscription();
    Set<Subscription> getSubscriptionByType(TypeSubscription type);
    List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);

}
