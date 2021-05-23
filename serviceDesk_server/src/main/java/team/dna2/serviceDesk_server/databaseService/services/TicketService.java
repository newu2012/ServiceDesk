package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import team.dna2.serviceDesk_server.databaseService.entities.Ticket;
import team.dna2.serviceDesk_server.databaseService.repositories.MembersRepository;
import team.dna2.serviceDesk_server.databaseService.repositories.TicketsRepository;

import java.util.List;

@Service
public class TicketService {

    private TicketsRepository ticketsRepository;
    private MembersRepository membersRepository;

    public List<Ticket> getTickets(Long userId){
        return ticketsRepository.findTicketsByAuthor_Id(userId);
    }
}
