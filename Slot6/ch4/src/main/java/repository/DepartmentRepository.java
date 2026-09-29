package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pojo.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // ===== TODO 11 =====
    Optional<Department> findByCode(String code);
    List<Department> findByStudentsIsEmpty();
}
