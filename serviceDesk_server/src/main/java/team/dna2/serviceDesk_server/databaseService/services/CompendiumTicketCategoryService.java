package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import team.dna2.serviceDesk_server.databaseService.entities.CompendiumTicketCategory;
import team.dna2.serviceDesk_server.databaseService.repositories.CompendiumTicketCategoriesRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompendiumTicketCategoryService {

    @Resource
    private CompendiumTicketCategoriesRepository ticketCategoriesRepository;

    public CompendiumTicketCategory getOneById(Long id) {
        return ticketCategoriesRepository.getOne(id);
    }

    public List<CompendiumTicketCategory> getAll() {
        return ticketCategoriesRepository.findAll();
    }
}
