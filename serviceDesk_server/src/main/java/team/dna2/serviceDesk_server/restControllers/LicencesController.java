package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import team.dna2.serviceDesk_server.databaseService.entities.CompendiumLicence;
import team.dna2.serviceDesk_server.databaseService.services.CompendiumLicenceService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/developer/licences")
@Slf4j
public class LicencesController {

    @Resource
    private CompendiumLicenceService licenceService;

    @GetMapping("/all")
    public List<CompendiumLicence> getAllLicences() {
        return licenceService.getAllLicences();
    }

    @GetMapping("/id/{licenceId}")
    public CompendiumLicence getLicence(@PathVariable Long licenceId) {
        return  licenceService.getOneById(licenceId);
    }

//    @PostMapping("/add")
//    public String addLicence(CompendiumLicence licence){
//        return "200";
//    }
}
