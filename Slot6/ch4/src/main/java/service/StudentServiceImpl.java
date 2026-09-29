package service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Student;
import repository.StudentRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    // ===== Part B =====
    @Override
    public long count() {
        return studentRepository.count();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }
}
