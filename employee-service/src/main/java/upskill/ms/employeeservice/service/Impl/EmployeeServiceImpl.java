package upskill.ms.employeeservice.service.Impl;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import upskill.ms.employeeservice.dto.APIResponseDto;
import upskill.ms.employeeservice.dto.DepartmentDto;
import upskill.ms.employeeservice.dto.EmployeeDto;
import upskill.ms.employeeservice.entity.Employee;
import upskill.ms.employeeservice.repository.EmployeeRepository;
import upskill.ms.employeeservice.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private RestTemplate restTemplate;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee=new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        Employee saveDEmployee=employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = new EmployeeDto(
                saveDEmployee.getId(),
                saveDEmployee.getFirstName(),
                saveDEmployee.getLastName(),
                saveDEmployee.getEmail(),
                saveDEmployee.getDepartmentCode()

        );
        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {

        Employee employee= employeeRepository.findById(employeeId).get();

        ResponseEntity<DepartmentDto> responseEntity= restTemplate.getForEntity("http://localhost:3306/api/departments/"+ employee.getDepartmentCode(),
        DepartmentDto.class);

        DepartmentDto departmentDto =responseEntity.getBody();

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        APIResponseDto apiResponseDto =new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }
}
