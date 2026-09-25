package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pojo.Student;

public interface StudentRepository extends JpaRepository<Student, Long>,
                                           JpaSpecificationExecutor<Student> {
    // sẽ bổ sung dần ở các TODO sau
}
