package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.dna2.serviceDesk_server.databaseService.entities.CompendiumLicence;
import team.dna2.serviceDesk_server.databaseService.services.CompendiumLicenceService;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping("/developer/licences")
@Slf4j
public class LicencesController {

    @Resource
    private CompendiumLicenceService licenceService;

    @GetMapping("/")
    public Collection<CompendiumLicence> getAllLicences() {
        return licenceService.getAll();
    }

    @GetMapping("/{licenceId}")
    public CompendiumLicence getLicence(@PathVariable Long licenceId) {
        return  licenceService.getOneById(licenceId);
    }

    /*
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String addLicence(@RequestBody CompendiumLicence licence){
        return "200";
        //TODO
    }
    */
}
