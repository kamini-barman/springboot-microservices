package upskill.ms.organizationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upskill.ms.organizationservice.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {

    Organization findByOrganizationCode(String organizationCode);

}
