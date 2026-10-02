package service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CourseRepository;
import repository.StudentRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EnrollmentServiceImpl implements EnrollmentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    // cai dat dan tu TODO 7
}
