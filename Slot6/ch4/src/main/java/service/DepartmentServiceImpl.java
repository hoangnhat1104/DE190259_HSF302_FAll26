package service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.DepartmentRepository;
import repository.StudentRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final StudentRepository studentRepository;      // dùng ở TODO 22 (chuyển sinh viên)

    // Các method được cài đặt dần từ TODO 6
}
