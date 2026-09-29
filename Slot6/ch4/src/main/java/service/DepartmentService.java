package service;

import pojo.Department;

import java.util.List;

public interface DepartmentService {
    long count();                                           // TODO 6
    boolean existsById(Long id);                           // TODO 6
    List<Department> findDepartmentsWithoutStudents();     // TODO 11
}
