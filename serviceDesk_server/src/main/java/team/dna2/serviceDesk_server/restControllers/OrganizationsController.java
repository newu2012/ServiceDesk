package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.dna2.serviceDesk_server.databaseService.entities.Organization;
import team.dna2.serviceDesk_server.databaseService.services.OrganizationService;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping("/developer/organizations")
@Slf4j
public class OrganizationsController {

    @Resource
    private OrganizationService organizationService;

    @GetMapping("/")
    public Collection<Organization> getAllLicences() {
        return organizationService.getAll();
    }

    @GetMapping("/{organizationId}")
    public Organization getLicence(@PathVariable Long organizationId) {
        return  organizationService.getOneById(organizationId);
    }

}
