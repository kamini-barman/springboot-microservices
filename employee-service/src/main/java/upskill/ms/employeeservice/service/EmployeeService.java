package upskill.ms.employeeservice.service;

import upskill.ms.employeeservice.dto.APIResponseDto;
import upskill.ms.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
