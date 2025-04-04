package tn.esprit.fakher_jemli_4arctic3.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numCourse;
    private int level;
    private TypeCourse typeCourse;
    private Support support;
    private Float price;
    private int timeSlot;
    @OneToMany(mappedBy = "course")
    Set<Registration> registrations;
    @ManyToOne
    private Instructor instructor;
}
