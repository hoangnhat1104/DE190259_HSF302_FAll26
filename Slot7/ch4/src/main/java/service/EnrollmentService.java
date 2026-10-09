package service;

import pojo.Course;
import pojo.Student;

import java.util.List;

public interface EnrollmentService {

    // ===== TODO 7 =====
    List<Course> getCoursesOfStudent(String studentCode);
    List<Student> getStudentsOfCourse(String courseCode);
}
