package upskill.ms.organizationservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import upskill.ms.organizationservice.Mapper.OrganizationMapper;
import upskill.ms.organizationservice.dto.OrganizationDto;
import upskill.ms.organizationservice.entity.Organization;
import upskill.ms.organizationservice.repository.OrganizationRepository;
import upskill.ms.organizationservice.service.OrganizationService;
@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        // convert OrganizationDto into Organization jpa entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }

}
