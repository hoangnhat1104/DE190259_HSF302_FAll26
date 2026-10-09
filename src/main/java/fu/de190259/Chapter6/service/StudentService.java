package fu.de190259.Chapter6.service;

import fu.de190259.Chapter6.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAll();

    Optional<Student> findById(Long id);

    Student create(Student student);

    /** @return true neu tim thay va cap nhat; false neu khong ton tai id */
    boolean update(Long id, Student data);

    /** @return true neu xoa duoc; false neu khong ton tai id */
    boolean delete(Long id);

    /** Kiem tra email trung. excludeId = null khi them moi, = id hien tai khi cap nhat */
    boolean isEmailTaken(String email, Long excludeId);

    List<String> getMajors();
}
