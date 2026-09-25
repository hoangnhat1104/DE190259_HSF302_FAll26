package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pojo.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // sẽ bổ sung dần ở các TODO sau
}
