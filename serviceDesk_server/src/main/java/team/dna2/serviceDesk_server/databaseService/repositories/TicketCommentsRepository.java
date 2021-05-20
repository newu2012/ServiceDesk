package team.dna2.serviceDesk_server.databaseService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.dna2.serviceDesk_server.databaseService.entities.TicketComment;

@Repository
public interface TicketCommentsRepository extends JpaRepository<TicketComment, Long> {
}
