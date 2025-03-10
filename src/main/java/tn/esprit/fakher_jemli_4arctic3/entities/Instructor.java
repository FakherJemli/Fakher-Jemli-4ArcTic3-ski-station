package tn.esprit.fakher_jemli_4arctic3.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Instructor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numInstructor;
    private String firstName;
    private String lastName;
    private LocalDate dateOfHire;
    @OneToMany
    Set<Course> courses;

}
