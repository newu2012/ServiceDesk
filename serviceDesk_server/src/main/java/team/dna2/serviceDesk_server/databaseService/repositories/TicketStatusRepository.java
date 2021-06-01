package team.dna2.serviceDesk_server.databaseService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.dna2.serviceDesk_server.databaseService.entities.TicketStatus;

@Repository
public interface TicketStatusRepository extends JpaRepository<TicketStatus, Long> {
}
