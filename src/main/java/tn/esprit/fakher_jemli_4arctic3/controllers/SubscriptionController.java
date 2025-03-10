package tn.esprit.fakher_jemli_4arctic3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.fakher_jemli_4arctic3.entities.Subscription;
import tn.esprit.fakher_jemli_4arctic3.services.ISubscriptionServices;

import java.util.List;

@RestController
@RequestMapping("subscription")
public class SubscriptionController {
    @Autowired
    private ISubscriptionServices subscriptionServices;

    @PostMapping("add")
    public Subscription addSubscription(@RequestBody Subscription subscription) {
        return subscriptionServices.addSubscription(subscription);
    }
    @PutMapping("update")
    public Subscription updateSubscription(@RequestBody Subscription subscription) {
        return subscriptionServices.updateSubscription(subscription);
    }
    @GetMapping("get/{numSubscription}")
    public Subscription retrieveSubscription(@PathVariable Long numSubscription) {
        return subscriptionServices.retrieveSubscription(numSubscription);
    }
    @DeleteMapping("delete/{numSubscription}")
    public void deleteSubscription(@PathVariable Long numSubscription) {
        subscriptionServices.deleteSubscription(numSubscription);
    }
    @GetMapping("all")
    public List<Subscription> retrieveAllSubscription() {
        return subscriptionServices.retrieveAllSubscription();
    }
}
