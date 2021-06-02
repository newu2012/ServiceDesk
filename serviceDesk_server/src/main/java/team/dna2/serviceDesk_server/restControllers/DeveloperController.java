package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import team.dna2.serviceDesk_server.databaseService.entities.Developer;
import team.dna2.serviceDesk_server.databaseService.services.DeveloperService;
import team.dna2.serviceDesk_server.restControllers.requestModels.DeveloperRequest;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/developer")
@Slf4j
public class DeveloperController {

    @Resource
    private DeveloperService developerService;

    @GetMapping("/developers/")
    public Collection<Developer> getAllDevelopers(){
        return developerService.getAll();
    }

    @PostMapping(value = "/developers/", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('DEVELOPER')")
    public void createDeveloper(@Valid @RequestBody DeveloperRequest developerRequest) throws Exception{
        developerService.createDeveloperFromRequest(developerRequest);
    }

    @GetMapping("/developers/{developerId}/")
    public Developer getDeveloper(@PathVariable Long developerId){
        return developerService.getOneById(developerId);
    }
}
