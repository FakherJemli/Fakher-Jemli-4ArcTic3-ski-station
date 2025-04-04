package tn.esprit.fakher_jemli_4arctic3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.fakher_jemli_4arctic3.entities.Course;
import tn.esprit.fakher_jemli_4arctic3.entities.Instructor;
import tn.esprit.fakher_jemli_4arctic3.repositories.ICourseRepository;
import tn.esprit.fakher_jemli_4arctic3.repositories.IInstructorRepository;

import java.util.List;
@Service
public class InstructorServicesImpl implements IInstructorServices {
    @Autowired
     IInstructorRepository instructorRepository;
     ICourseRepository courseRepository;

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor retrieveInstructor(long numInstructor) {
        return instructorRepository.findById(numInstructor).orElse(null);
    }

    @Override
    public void deleteInstructor(long numInstructor) {
        instructorRepository.deleteById(numInstructor);

    }

    @Override
    public List<Instructor> retrieveAllInstructor() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse) {

        Course course = courseRepository.findById(numCourse).orElse(null);


        if (course == null) {
            return null;
        }
        Instructor savedInstructor = instructorRepository.save(instructor);
        course.setInstructor(savedInstructor);
        courseRepository.save(course);
        return savedInstructor;
    }
}
