package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.dna2.serviceDesk_server.databaseService.entities.Developer;
import team.dna2.serviceDesk_server.databaseService.services.DeveloperService;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping("/developer")
@Slf4j
public class DeveloperController {

    @Resource
    private DeveloperService developerService;

    @GetMapping("/developers")
    public Collection<Developer> getAllDevelopers(){
        return developerService.getAll();
    }

    @GetMapping("/developers/{developerId}")
    public Developer getDeveloper(@PathVariable Long developerId){
        return developerService.getOneById(developerId);
    }
}
