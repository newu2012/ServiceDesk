package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import team.dna2.serviceDesk_server.databaseService.entities.Organization;
import team.dna2.serviceDesk_server.databaseService.entities.Ticket;
import team.dna2.serviceDesk_server.databaseService.repositories.MembersRepository;
import team.dna2.serviceDesk_server.databaseService.repositories.TicketsRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TicketService {

    @Resource
    private TicketsRepository ticketsRepository;

    public List<Ticket> getAllTicketsByOrganization(Long orgId) {
        return ticketsRepository.findTicketsByOrganization_Id(orgId);
    }

    public List<Ticket> getAllByAuthor(Long authorId){
        return ticketsRepository.findTicketsByAuthor_Id(authorId);
    }

    public List<Ticket> getAllByDev(Long devId){
        return ticketsRepository.findTicketsByDeveloper_Id(devId);
    }

    public Ticket getOneById(Long ticketId) {
        var ticket = ticketsRepository.findById(ticketId);
        if (ticket.isPresent())
            return ticketsRepository.findById(ticketId).get();
        else
            throw new NullPointerException();
    }

    public List<Ticket> getAll(){
        return ticketsRepository.findAll();
    }
}
