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

//    @Query("SELECT Organization from Member m where m.id =:id")
//    Long findOrganizationByMember_id(Long id);
//
//    @Query("SELECT Member from Member where organization.id=:id")
//    List<Member> findMembersByOrganization_Id(Long id);


    //Optional<Organization> findOrganizationUser_Id(Long userId);

}