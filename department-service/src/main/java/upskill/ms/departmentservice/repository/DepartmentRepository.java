package upskill.ms.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upskill.ms.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentCode(String code);

}
