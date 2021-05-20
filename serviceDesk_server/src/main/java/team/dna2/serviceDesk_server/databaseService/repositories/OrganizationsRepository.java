package team.dna2.serviceDesk_server.databaseService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import team.dna2.serviceDesk_server.databaseService.entities.Organization;

@Repository
public interface OrganizationsRepository extends JpaRepository<Organization, Long> {

    @Query("UPDATE Organization SET isActive=false, blockDate=current_timestamp WHERE id = :id")
    void blockOrganizationById(Long id);

    @Query("UPDATE Organization SET isActive=true, blockDate=null WHERE id = :id")
    void unblockOrganizationById(Long id);
}