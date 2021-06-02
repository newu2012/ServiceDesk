package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.dna2.serviceDesk_server.databaseService.entities.TicketCategory;
import team.dna2.serviceDesk_server.databaseService.services.TicketCategoryService;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping("/developer/categories")
@Slf4j
public class TicketCategoriesController {

    @Resource
    private TicketCategoryService ticketCategoryService;

    @GetMapping("/")
    public Collection<TicketCategory> getAllTicketCategories(){
        return ticketCategoryService.getAll();
    }

    @GetMapping("/{ticketCategoryId}/")
    public TicketCategory getTicketCategory(@PathVariable Long ticketCategoryId){
        return ticketCategoryService.getOneById(ticketCategoryId);
    }
}
