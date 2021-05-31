package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import team.dna2.serviceDesk_server.databaseService.entities.Licence;
import team.dna2.serviceDesk_server.databaseService.services.LicenceService;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping("/developer/licences")
@Slf4j
public class LicencesController {

    @Resource
    private LicenceService licenceService;

    @GetMapping("/")
    public Collection<Licence> getAllLicences() {
        return licenceService.getAll();
    }

    @GetMapping("/{licenceId}")
    public Licence getLicence(@PathVariable Long licenceId) {
        return  licenceService.getOneById(licenceId);
    }

}
