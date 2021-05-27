package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.dna2.serviceDesk_server.databaseService.entities.CompendiumSoftware;
import team.dna2.serviceDesk_server.databaseService.entities.CompendiumSoftwareModule;
import team.dna2.serviceDesk_server.databaseService.services.CompendiumSoftwareModuleService;
import team.dna2.serviceDesk_server.databaseService.services.CompendiumSoftwareService;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping("/developer/software")
@Slf4j
public class SoftwareController {

    @Resource
    private CompendiumSoftwareService softwareService;

    @Resource
    private CompendiumSoftwareModuleService moduleService;

    @GetMapping("/")
    public Collection<CompendiumSoftware> getAllSoftware(){
        return softwareService.getAll();
    }

    @GetMapping("/{softwareId}")
    public CompendiumSoftware getSoftware(@PathVariable Long softwareId){
        return softwareService.getOneById(softwareId);
    }

    @GetMapping("/modules")
    public Collection<CompendiumSoftwareModule> getAllModules(){
        return moduleService.getAll();
    }

    @GetMapping("/modules/{moduleId}")
    public CompendiumSoftwareModule getModule(@PathVariable Long moduleId){
        return moduleService.getOneById(moduleId);
    }
}
