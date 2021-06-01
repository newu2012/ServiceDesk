package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import team.dna2.serviceDesk_server.databaseService.entities.TicketCategory;
import team.dna2.serviceDesk_server.databaseService.repositories.TicketCategoriesRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TicketCategoryService {

    @Resource
    private TicketCategoriesRepository ticketCategoriesRepository;

    public TicketCategory getOneById(Long id) {
        return ticketCategoriesRepository.getOne(id);
    }

    public List<TicketCategory> getAll() {
        return ticketCategoriesRepository.findAll();
    }
}
