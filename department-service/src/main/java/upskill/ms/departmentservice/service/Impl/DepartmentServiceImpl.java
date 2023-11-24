package upskill.ms.departmentservice.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import upskill.ms.departmentservice.dto.DepartmentDto;
import upskill.ms.departmentservice.entity.Department;
import upskill.ms.departmentservice.repository.DepartmentRepository;
import upskill.ms.departmentservice.service.DepartmentService;
@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        //convert department dto to department jpa entity
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );

       Department savedDepartment = departmentRepository.save(department);

       DepartmentDto savedDepartmentDto = new DepartmentDto(
               savedDepartment.getId(),
               savedDepartment.getDepartmentName(),
               savedDepartment.getDepartmentDescription(),
               savedDepartment.getDepartmentCode()
       );
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentcode) {

        Department department=departmentRepository.findByDepartmentCode(departmentcode);

        DepartmentDto departmentDto=new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }
}
