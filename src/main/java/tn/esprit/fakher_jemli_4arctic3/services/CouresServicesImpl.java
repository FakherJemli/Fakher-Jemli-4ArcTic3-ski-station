package tn.esprit.fakher_jemli_4arctic3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.fakher_jemli_4arctic3.entities.Course;
import tn.esprit.fakher_jemli_4arctic3.repositories.ICourseRepository;

import java.util.List;

@Service
public class CouresServicesImpl implements ICourseServices {
    @Autowired
    ICourseRepository courseRepository;

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course retrieveCourse(long numCourse) {
        return courseRepository.findById(numCourse).orElse(null);
    }

    @Override
    public void deleteCourse(long numCourse) {
        courseRepository.deleteById(numCourse);

    }

    @Override
    public List<Course> retrieveAllCourse() {
        return courseRepository.findAll();
    }
}

