package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import team.dna2.serviceDesk_server.databaseService.entities.Organization;
import team.dna2.serviceDesk_server.databaseService.entities.Ticket;
import team.dna2.serviceDesk_server.databaseService.services.OrganizationService;
import team.dna2.serviceDesk_server.databaseService.services.TicketService;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping("/tickets")
@Slf4j
public class TicketsController {

    @Resource
    private TicketService ticketService;

    @Resource
    private OrganizationService organizationService;

    @GetMapping("/")
    public Collection<Ticket> getTickets(Long userId){
        Organization org = organizationService.getOrganizationByUserId(userId);
        return ticketService.getAllTicketsByOrganization(org.getId());
    }

    @GetMapping("/{ticketId}")
    public Ticket getTicket(@PathVariable Long ticketId){
        return ticketService.getOneById(ticketId);
    }

    @GetMapping("/by-author/{authorId}")
    public Collection<Ticket> getTicketsByAuthor(@PathVariable Long authorId){
        return ticketService.getAllByAuthor(authorId);
    }

    @GetMapping("/by-dev/{devId}")
    public Collection<Ticket> getTicketsByDeveloper(@PathVariable Long devId){
        return ticketService.getAllByDev(devId);
    }

}
