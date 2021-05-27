package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.dna2.serviceDesk_server.databaseService.entities.CompendiumTicketCategory;
import team.dna2.serviceDesk_server.databaseService.entities.Member;
import team.dna2.serviceDesk_server.databaseService.entities.Ticket;
import team.dna2.serviceDesk_server.databaseService.services.CompendiumTicketCategoryService;
import team.dna2.serviceDesk_server.databaseService.services.MemberService;
import team.dna2.serviceDesk_server.databaseService.services.TicketService;

import javax.annotation.Resource;
import java.util.Collection;

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

    @Resource
    private MemberService memberService;

    @GetMapping("/members")
    public Collection<Member> getAllMembers(){
        return memberService.getAll();
    }

    @GetMapping("/members/{memberId}")
    public Member getMember(@PathVariable Long memberId){
        return memberService.getOneById(memberId);
    }
}
