package team.dna2.serviceDesk_server.databaseService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.dna2.serviceDesk_server.databaseService.entities.TicketComment;

import java.util.List;

@Repository
public interface TicketCommentsRepository extends JpaRepository<TicketComment, Long> {

    //Взять все комменты по тикету (самый новый - первый)
    List<TicketComment> findAllByTicket_IdOrderByCreationDateDesc(Long ticketId);
}
