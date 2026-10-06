package service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Course;
import pojo.Student;
import repository.CourseRepository;
import repository.StudentRepository;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EnrollmentServiceImpl implements EnrollmentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    // ===== TODO 7 =====
    @Override
    public List<Course> getCoursesOfStudent(String studentCode) {
        Student s = getStudent(studentCode);
        return s.getCourses().stream()                       // nap LAZY: van trong transaction -> OK
                .sorted(Comparator.comparing(Course::getCode))
                .toList();
    }

    @Override
    public List<Student> getStudentsOfCourse(String courseCode) {
        Course c = getCourse(courseCode);
        return c.getStudents().stream()                      // inverse side van DOC duoc binh thuong
                .sorted(Comparator.comparing(Student::getFullName))
                .toList();
    }

    // ===== helpers dung chung cho moi method =====
    private Student getStudent(String studentCode) {
        if (studentCode == null || studentCode.isBlank()) {
            throw new IllegalArgumentException("Student code must not be blank");
        }
        return studentRepository.findByStudentCode(studentCode)
                .orElseThrow(() -> new IllegalArgumentException("Student not found: " + studentCode));
    }

    private Course getCourse(String courseCode) {
        if (courseCode == null || courseCode.isBlank()) {
            throw new IllegalArgumentException("Course code must not be blank");
        }
        return courseRepository.findByCode(courseCode)
                .orElseThrow(() -> new IllegalArgumentException("Course not found: " + courseCode));
    }
}
