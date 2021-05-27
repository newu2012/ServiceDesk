package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import team.dna2.serviceDesk_server.databaseService.entities.Ticket;
import team.dna2.serviceDesk_server.databaseService.repositories.MembersRepository;
import team.dna2.serviceDesk_server.databaseService.repositories.TicketsRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TicketService {

    @Resource
    private TicketsRepository ticketsRepository;

    @Resource
    private MembersRepository membersRepository;

    public List<Ticket> getAllTicketsByOrganization(Long orgId) {
        return ticketsRepository.findTicketsByOrganization_Id(orgId);
    }

    public Ticket getOneTicket(Long ticketId) {
        var ticket = ticketsRepository.findById(ticketId);
        if(ticket.isPresent())
            return ticketsRepository.findById(ticketId).get();
        else
            throw new NullPointerException();
    }
}
