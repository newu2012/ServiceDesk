package team.dna2.serviceDesk_server.databaseService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import team.dna2.serviceDesk_server.databaseService.entities.Ticket;

import java.util.List;

@Repository
public interface TicketsRepository extends JpaRepository<Ticket, Long> {

    //Взять все тикеты по автору
    List<Ticket> findTicketsByUser_Id(Long userId);

    //Взять все тикеты по исполнителю
    List<Ticket> findTicketsByDeveloper_Id(Long devId);

    List<Ticket> findTicketsByOrganization_Id(Long orgId);

}
