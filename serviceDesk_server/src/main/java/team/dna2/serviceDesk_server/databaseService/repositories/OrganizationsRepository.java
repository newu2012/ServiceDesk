package team.dna2.serviceDesk_server.databaseService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import team.dna2.serviceDesk_server.databaseService.entities.Organization;

@Repository
public interface OrganizationsRepository extends JpaRepository<Organization, Long> {

    @Query("UPDATE Organization SET isActive=false, blockDate=current_timestamp WHERE id = :orgId")
    void blockOrganizationById(Long orgId);

    @Query("UPDATE Organization SET isActive=true, blockDate=null WHERE id = :orgId")
    void unblockOrganizationById(Long orgId);
}