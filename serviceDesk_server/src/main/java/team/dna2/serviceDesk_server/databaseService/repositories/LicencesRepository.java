package team.dna2.serviceDesk_server.databaseService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.dna2.serviceDesk_server.databaseService.entities.Licence;

import java.util.List;

@Repository
public interface LicencesRepository extends JpaRepository<Licence, Long> {

    List<Licence> findLicencesByOrganization_Id(Long orgId);
}
