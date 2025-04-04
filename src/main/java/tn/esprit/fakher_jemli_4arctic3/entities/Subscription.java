package tn.esprit.fakher_jemli_4arctic3.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numSub;
    private LocalDate startDate;
    private LocalDate endDate;
    private Float price;
    private TypeSubscription typeSubscription;
    //parent
    @OneToOne
    Skier skier;
}
