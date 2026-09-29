package service;

import pojo.Student;

import java.util.Optional;

public interface StudentService {
    long count();                            // TODO 6
    Optional<Student> findById(Long id);     // TODO 6
}
