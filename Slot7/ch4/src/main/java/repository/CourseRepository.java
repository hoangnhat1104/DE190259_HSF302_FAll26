package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pojo.Course;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // ===== TODO 7 =====
    Optional<Course> findByCode(String code);
}
