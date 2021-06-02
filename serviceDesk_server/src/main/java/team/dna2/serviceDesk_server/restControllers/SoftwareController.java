package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import team.dna2.serviceDesk_server.databaseService.entities.Software;
import team.dna2.serviceDesk_server.databaseService.entities.SoftwareModule;
import team.dna2.serviceDesk_server.databaseService.services.SoftwareModuleService;
import team.dna2.serviceDesk_server.databaseService.services.SoftwareService;
import team.dna2.serviceDesk_server.restControllers.requestModels.SoftwareModuleRequest;
import team.dna2.serviceDesk_server.restControllers.requestModels.SoftwareRequest;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/developer/software")
@Slf4j
public class SoftwareController {

    @Resource
    private SoftwareService softwareService;

    @Resource
    private SoftwareModuleService moduleService;

    @GetMapping("/")
    public Collection<Software> getAllSoftware(){
        return softwareService.getAll();
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('DEVELOPER')")
    public void createSoftware(@Valid @RequestBody SoftwareRequest softwareRequest){
        softwareService.createSoftwareFromRequest(softwareRequest);
    }

    @GetMapping("/{softwareId}/")
    public Software getSoftware(@PathVariable Long softwareId){
        return softwareService.getOneById(softwareId);
    }

    @GetMapping("/modules/")
    public Collection<SoftwareModule> getAllModules(){
        return moduleService.getAll();
    }

    @PostMapping(value = "/modules/", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('DEVELOPER')")
    public void createSoftwareModule(@Valid @RequestBody SoftwareModuleRequest softwareModuleRequest){
        moduleService.createModuleFromRequest(softwareModuleRequest);
    }

    @GetMapping("/modules/{moduleId}")
    public SoftwareModule getModule(@PathVariable Long moduleId){
        return moduleService.getOneById(moduleId);
    }
}
