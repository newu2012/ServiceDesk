package team.dna2.serviceDesk_server.databaseService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.dna2.serviceDesk_server.databaseService.entities.UserSessionToken;

@Repository
public interface UserSessionTokensRepository extends JpaRepository<UserSessionToken, Long> {
}
