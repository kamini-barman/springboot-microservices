package upskill.ms.departmentservice.service;

import upskill.ms.departmentservice.dto.DepartmentDto;
import upskill.ms.departmentservice.entity.Department;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}
