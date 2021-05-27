package team.dna2.serviceDesk_server.databaseService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import team.dna2.serviceDesk_server.databaseService.entities.Ticket;

import java.util.List;

@Repository
public interface TicketsRepository extends JpaRepository<Ticket, Long> {

    //Взять все тикеты по автору
    List<Ticket> findTicketsByAuthor_Id(Long userId);

    //Взять все тикеты по исполнителю
    List<Ticket> findTicketsByDeveloper_Id(Long devId);

    //List<Ticket> findTicketsByOrganization_Id(Long orgId);


//    @Query("select Ticket from Ticket t join Member m where m.organization.id = :orgId")
//    List<Ticket> findTicketsByOrganizationName();

    //найти тикет по организации
    //от организации найти мембера
    //возможно стоит оставлять организацию в тикете(!)
}
