package service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.StudentRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)          // mặc định: mọi method chỉ ĐỌC
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    // Các method được cài đặt dần từ TODO 6
}
