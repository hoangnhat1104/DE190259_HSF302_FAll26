package repository;

import dto.DepartmentStatDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pojo.Department;

import java.util.List;
import java.util.Optional;
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // ===== TODO 11 =====
    Optional<Department> findByCode(String code);
    List<Department> findByStudentsIsEmpty();

    // ===== TODO 14 =====
    @Query("SELECT new dto.DepartmentStatDTO(d.code, d.name, COUNT(s), AVG(s.gpa)) " +
           "FROM Department d LEFT JOIN d.students s " +
           "GROUP BY d.code, d.name " +
           "ORDER BY d.code")
    List<DepartmentStatDTO> getDepartmentStats();

    // ===== TODO 16 =====
    @Query("SELECT d FROM Department d LEFT JOIN FETCH d.students WHERE d.code = :code")
    Optional<Department> findByCodeWithStudents(@Param("code") String code);

    // ===== Bonus: count students per department (native SQL) =====
    @Query(value = "SELECT d.code, d.name, COUNT(s.id) AS total " +
                   "FROM departments d LEFT JOIN students s ON s.department_id = d.id " +
                   "GROUP BY d.code, d.name " +
                   "ORDER BY d.code",
           nativeQuery = true)
    List<Object[]> countStudentsPerDepartmentNative();
}
