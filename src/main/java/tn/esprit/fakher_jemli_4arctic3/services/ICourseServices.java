package tn.esprit.fakher_jemli_4arctic3.services;

import tn.esprit.fakher_jemli_4arctic3.entities.Course;

import java.util.List;

public interface ICourseServices {
    Course addCourse (Course course);
    Course updateCourse (Course course);
    Course retrieveCourse (long numCourse);
    void deleteCourse (long numCourse);
    List<Course> retrieveAllCourse();
}
