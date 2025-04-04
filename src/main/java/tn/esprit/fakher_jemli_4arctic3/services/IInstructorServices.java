package tn.esprit.fakher_jemli_4arctic3.services;

import tn.esprit.fakher_jemli_4arctic3.entities.Instructor;

import java.util.List;

public interface IInstructorServices {
    Instructor addInstructor (Instructor instructor);
    Instructor updateInstructor (Instructor instructor);
    Instructor retrieveInstructor (long numInstructor);
    void deleteInstructor (long numInstructor);
    List<Instructor> retrieveAllInstructor();
    Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse);
}
