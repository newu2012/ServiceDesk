package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import team.dna2.serviceDesk_server.databaseService.entities.Organization;
import team.dna2.serviceDesk_server.databaseService.entities.Ticket;
import team.dna2.serviceDesk_server.databaseService.services.OrganizationService;
import team.dna2.serviceDesk_server.databaseService.services.TicketService;
import team.dna2.serviceDesk_server.restControllers.requestModels.TicketRequest;

import javax.annotation.Resource;
import javax.validation.Valid;
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
    public Collection<Ticket> getTickets(@RequestParam Long userId){
        Organization org = organizationService.getOrganizationByUserId(userId);
        return ticketService.getAllTicketsByOrganization(org.getId());
    }

    @GetMapping("/{ticketId}")
    public Ticket getTicket(@PathVariable Long ticketId){
        return ticketService.getOneById(ticketId);
    }

    @GetMapping("/by-author")
    public Collection<Ticket> getTicketsByAuthor(@RequestParam Long authorId){
        return ticketService.getAllByAuthor(authorId);
    }

    @GetMapping("/by-dev")
    @PreAuthorize("hasRole('DEVELOPER')")
    public Collection<Ticket> getTicketsByDeveloper(@RequestParam Long devId){
        return  ticketService.getAllByDev(devId);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerson(@Valid @RequestBody TicketRequest ticketRequest) {
        ticketService.createTicketFromRequest(ticketRequest);
    }

    @PutMapping("/{ticketId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void editTicket(@PathVariable Long ticketId, @RequestParam Long editorId, @RequestBody Ticket editedTicket){
        ticketService.editTicket(editorId, ticketId, editedTicket);
    }

    @PatchMapping("/{ticketId}/set-status")
    @PreAuthorize("hasRole('DEVELOPER')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void setStatusToTicket(@PathVariable Long ticketId, @RequestParam Long editorId, @RequestParam Long statusId){
        ticketService.setStatusToTicket(editorId, ticketId, statusId);
    }

    @PatchMapping("/{ticketId}/set-developer")
    @PreAuthorize("hasRole('DEVELOPER')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void setDeveloperToTicket(@PathVariable Long ticketId, @RequestParam Long editorId, @RequestParam Long devId){
        ticketService.setDeveloperToTicket(editorId, ticketId, devId);
    }
}
