package tn.esprit.fakher_jemli_4arctic3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.fakher_jemli_4arctic3.entities.Subscription;

public interface ISubscriptionRepository extends JpaRepository<Subscription, Long> {
}
