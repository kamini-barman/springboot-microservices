package upskill.ms.departmentservice.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import upskill.ms.departmentservice.dto.DepartmentDto;
import upskill.ms.departmentservice.entity.Department;
import upskill.ms.departmentservice.mapper.DepartmentMapper;
import upskill.ms.departmentservice.repository.DepartmentRepository;
import upskill.ms.departmentservice.service.DepartmentService;
@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        //convert department dto to department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

       Department savedDepartment = departmentRepository.save(department);

       DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentcode) {

        Department department=departmentRepository.findByDepartmentCode(departmentcode);

        DepartmentDto departmentDto= DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
    }
}
