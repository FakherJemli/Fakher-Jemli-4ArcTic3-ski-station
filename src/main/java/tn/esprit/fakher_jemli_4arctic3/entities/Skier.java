package tn.esprit.fakher_jemli_4arctic3.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Skier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numSkier;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String city;
    //child
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    Subscription subscription;

    @OneToMany(mappedBy = "skier")
    Set<Registration> registrations;
    @ManyToMany(mappedBy = "skiers")
    List<Piste> pistes;
}
