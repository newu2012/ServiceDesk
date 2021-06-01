package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.dna2.serviceDesk_server.databaseService.entities.RecordChange;
import team.dna2.serviceDesk_server.databaseService.entities.Ticket;
import team.dna2.serviceDesk_server.databaseService.repositories.*;
import team.dna2.serviceDesk_server.restControllers.requestModels.TicketRequest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class TicketService {

    @Resource
    private TicketsRepository ticketsRepository;

    @Resource
    private DevelopersRepository developersRepository;

    @Resource
    private TicketStatusRepository statusRepository;

    @Resource
    private RecordChangesRepository changesRepository;

    @Resource
    private UsersRepository usersRepository;

    @Resource
    private SoftwareModulesRepository softwareModulesRepository;

    @Resource
    private TicketCategoriesRepository categoriesRepository;

    @Resource
    private OrganizationsRepository organizationsRepository;

    public List<Ticket> getAllTicketsByOrganization(Long orgId) {
        return ticketsRepository.findTicketsByOrganization_Id(orgId);
    }

    public List<Ticket> getAllByAuthor(Long authorId){
        return ticketsRepository.findTicketsByUser_Id(authorId);
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

    //TODO Протестить
    @Transactional
    public void setDeveloperToTicket(Long editorId, Long ticketId, Long devId){
        var ticket = ticketsRepository.getOne(ticketId);
        var dev = developersRepository.getOne(devId);

        ticket.setDeveloper(dev);

        var newRecordChange = new RecordChange(usersRepository.getOne(editorId), ticket);
        changesRepository.save(newRecordChange);
        //ticket.setLastChange(changesRepository.findFirstByTicket_IdOrderByDateTimeDesc(ticketId));

        ticketsRepository.save(ticket);
    }

    @Transactional
    public void setStatusToTicket(Long editorId, Long ticketId, Long statusId){
        var ticket = ticketsRepository.getOne(ticketId);
        var status = statusRepository.getOne(statusId);

        ticket.setTicketStatus(status);

        var newRecordChange = new RecordChange(usersRepository.getOne(editorId), ticket);
        changesRepository.save(newRecordChange);
        //ticket.setLastChange(changesRepository.findFirstByTicket_IdOrderByDateTimeDesc(ticketId));

        ticketsRepository.save(ticket);
    }

    @Transactional
    public void editTicket(Long editorId, Long ticketId, Ticket editedTicket){
        var ticket = ticketsRepository.getOne(ticketId);

        ticket.setTicketText(editedTicket.getTicketText());
        ticket.setTitle(editedTicket.getTitle());
        ticket.setTicketCategory(editedTicket.getTicketCategory());
        ticket.setSoftwareModule(editedTicket.getSoftwareModule());

        var newRecordChange = new RecordChange(usersRepository.getOne(editorId), ticket);
        changesRepository.save(newRecordChange);
        //ticket.setLastChange(changesRepository.findFirstByTicket_IdOrderByDateTimeDesc(ticketId));

        ticketsRepository.save(ticket);
    }

//    //TODO
    @Transactional
    public void createTicketFromRequest(TicketRequest ticketRequest){
        var ticket = new Ticket();
        ticket.setUser(usersRepository.getOne(ticketRequest.getAuthorId()));
        ticket.setTicketCategory(categoriesRepository.getOne(ticketRequest.getCategoryId()));
        ticket.setTitle(ticketRequest.getTitle());
        ticket.setTicketText(ticketRequest.getText());
        ticket.setSoftwareModule(softwareModulesRepository.getOne(ticketRequest.getSoftwareModuleId()));
        ticket.setCreationDate(Timestamp.from(Instant.now()));
        ticket.setTicketStatus(statusRepository.getOne(1L));
        ticket.setOrganization(organizationsRepository.getOne(ticketRequest.getOrganizationId()));
        ticketsRepository.save(ticket);
    }
}
