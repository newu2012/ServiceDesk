package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import team.dna2.serviceDesk_server.databaseService.entities.Ticket;
import team.dna2.serviceDesk_server.databaseService.repositories.MembersRepository;
import team.dna2.serviceDesk_server.databaseService.repositories.TicketsRepository;

import javax.annotation.Resource;

@Service
public class TicketService {

    @Resource
    private TicketsRepository ticketsRepository;

    @Resource
    private MembersRepository membersRepository;

    @Resource
    private OrganizationService organizationService;

//    public List<Ticket> getAllTicketsByOrganization(Long orgId) {
//        return organizationService.getOrganizationByUserId();
//    }
    //TODO

    public Ticket getOneTicket(Long ticketId) {
        var ticket = ticketsRepository.findById(ticketId);
        if(ticket.isPresent())
            return ticketsRepository.findById(ticketId).get();
        else
            throw new NullPointerException();
    }
}
