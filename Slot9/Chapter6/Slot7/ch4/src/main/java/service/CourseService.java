package service;

import pojo.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    long count();                                    // TODO 6
    List<Course> findAllOrderByCode();               // TODO 6
    Optional<Course> findById(Long id);              // TODO 6
}
