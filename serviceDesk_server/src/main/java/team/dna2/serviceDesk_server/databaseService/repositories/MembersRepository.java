package team.dna2.serviceDesk_server.databaseService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import team.dna2.serviceDesk_server.databaseService.entities.Member;

import java.util.List;
import java.util.Optional;

@Repository
public interface MembersRepository extends JpaRepository<Member, Long> {
    @Query("update Member set isOwner=false where id = :id")
    void updateMemberOwnershipById(Long id);

    @Query("update Member set isOwner=true where id=:id")
    void setMemberOwnershipById(Long id);

    Optional<Member> findMemberIdByOrganization_IdAndIsOwnerTrue(Long organizationId);

    List<Member> findMembersByOrganization_Id(Long orgId);

    Optional<Member> findMemberByUser_Id(Long userId);
}
