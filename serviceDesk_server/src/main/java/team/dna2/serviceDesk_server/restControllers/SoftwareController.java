package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.dna2.serviceDesk_server.databaseService.entities.Software;
import team.dna2.serviceDesk_server.databaseService.entities.SoftwareModule;
import team.dna2.serviceDesk_server.databaseService.services.SoftwareModuleService;
import team.dna2.serviceDesk_server.databaseService.services.SoftwareService;

import javax.annotation.Resource;
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

    @GetMapping("/{softwareId}")
    public Software getSoftware(@PathVariable Long softwareId){
        return softwareService.getOneById(softwareId);
    }

    @GetMapping("/modules")
    public Collection<SoftwareModule> getAllModules(){
        return moduleService.getAll();
    }

    @GetMapping("/modules/{moduleId}")
    public SoftwareModule getModule(@PathVariable Long moduleId){
        return moduleService.getOneById(moduleId);
    }
}
