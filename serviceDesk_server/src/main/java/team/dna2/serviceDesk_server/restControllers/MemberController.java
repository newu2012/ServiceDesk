package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
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

//    @GetMapping("/tickets")
//    public List<Ticket> getTickets(Long orgId){
//        return ticketService.getAllTicketsByOrganization(orgId);
//    }
    //TODO

    @GetMapping("/tickets/{ticketId}")
    public Ticket getSelectedTicket(@PathVariable Long ticketId){
        return ticketService.getOneTicket(ticketId);
    }
}
