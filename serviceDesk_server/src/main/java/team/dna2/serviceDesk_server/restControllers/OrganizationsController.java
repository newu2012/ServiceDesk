package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import team.dna2.serviceDesk_server.databaseService.entities.Licence;
import team.dna2.serviceDesk_server.databaseService.entities.Organization;
import team.dna2.serviceDesk_server.databaseService.services.LicenceService;
import team.dna2.serviceDesk_server.databaseService.services.OrganizationService;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping("/organizations")
@Slf4j
public class OrganizationsController {

    @Resource
    private OrganizationService organizationService;

    @GetMapping("/")
    @PreAuthorize("hasRole('DEVELOPER')")
    public Collection<Organization> getAllOrganizations() {
        return organizationService.getAll();
    }

    @GetMapping("/{orgId}")
    public Organization getOrganization(@PathVariable Long orgId) {
        return organizationService.getOneById(orgId);
    }

    @GetMapping("/by-user")
    public Organization getOrgByUserId(@RequestParam Long userId){
        return organizationService.getOrganizationByUserId(userId);
    }

    @GetMapping("/{orgId}/licences")
    public Collection<Licence> getOrgLicences(@PathVariable Long orgId){
        return organizationService.getLicencesByOrganizationId(orgId);
    }

}
