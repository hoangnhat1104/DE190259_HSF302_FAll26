package fu.de190259.Chapter6.service.impl;

import fu.de190259.Chapter6.entity.Student;
import fu.de190259.Chapter6.repository.StudentRepository;
import fu.de190259.Chapter6.service.StudentService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)         // mac dinh: moi method chi doc
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    @Transactional                      // ghi du lieu -> bo readOnly
    public Student create(Student student) {
        student.setId(null);            // luon INSERT, khong bao gio ghi de ban ghi cu
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public boolean update(Long id, Student data) {
        return studentRepository.findById(id)
                .map(existing -> {
                    existing.setName(data.getName());
                    existing.setEmail(data.getEmail());
                    existing.setAge(data.getAge());
                    existing.setMajor(data.getMajor());
                    existing.setGpa(data.getGpa());
                    // Khong can goi save(): entity dang "managed",
                    // Hibernate tu sinh UPDATE khi transaction commit (dirty checking)
                    return true;
                })
                .orElse(false);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        if (!studentRepository.existsById(id)) {
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean isEmailTaken(String email, Long excludeId) {
        if (email == null || email.isBlank()) return false;
        return excludeId == null
                ? studentRepository.existsByEmailIgnoreCase(email.trim())
                : studentRepository.existsByEmailIgnoreCaseAndIdNot(email.trim(), excludeId);
    }

    @Override
    public List<String> getMajors() {
        return List.of("CNTT", "KTPM", "HTTT", "ATTT", "MMT");
    }
}
