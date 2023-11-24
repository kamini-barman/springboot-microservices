package upskill.ms.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upskill.ms.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
