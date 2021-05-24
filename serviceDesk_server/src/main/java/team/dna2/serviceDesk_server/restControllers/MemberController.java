package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.dna2.serviceDesk_server.databaseService.entities.Ticket;
import team.dna2.serviceDesk_server.databaseService.services.TicketService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {

    @Resource
    private TicketService ticketService;

    @GetMapping("/tickets")
    public List<Ticket> getTickets(Long orgId){
        return ticketService.getAllTicketsByOrganization(orgId);
    }

    @GetMapping("/tickets/id")
    public Ticket getSelectedTicket(Long ticketId){
        return ticketService.getOneTicket(ticketId);
    }
}
