package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import team.dna2.serviceDesk_server.databaseService.entities.Licence;
import team.dna2.serviceDesk_server.databaseService.services.LicenceService;
import team.dna2.serviceDesk_server.restControllers.requestModels.LicenceRequest;

import javax.annotation.Resource;
import javax.validation.Valid;
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

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('DEVELOPER')")
    public void createLicence(@Valid @RequestBody LicenceRequest licenceRequest){
        licenceService.createLicenceFromRequest(licenceRequest);
    }

    @GetMapping("/{licenceId}/")
    public Licence getLicence(@PathVariable Long licenceId) {
        return  licenceService.getOneById(licenceId);
    }

}
