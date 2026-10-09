package fu.de190259.Chapter6.repository;

import fu.de190259.Chapter6.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /** Email da ton tai? (dung khi them moi) */
    boolean existsByEmailIgnoreCase(String email);

    /** Email da duoc sinh vien KHAC dung? (dung khi cap nhat) */
    boolean existsByEmailIgnoreCaseAndIdNot(String email, Long id);
}
