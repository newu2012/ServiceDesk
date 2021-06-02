package team.dna2.serviceDesk_server.restControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.dna2.serviceDesk_server.databaseService.entities.Licence;
import team.dna2.serviceDesk_server.databaseService.entities.Software;
import team.dna2.serviceDesk_server.databaseService.entities.SoftwareModule;
import team.dna2.serviceDesk_server.databaseService.entities.TicketCategory;
import team.dna2.serviceDesk_server.databaseService.services.LicenceService;
import team.dna2.serviceDesk_server.databaseService.services.SoftwareModuleService;
import team.dna2.serviceDesk_server.databaseService.services.SoftwareService;
import team.dna2.serviceDesk_server.databaseService.services.TicketCategoryService;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping("/basic")
@Slf4j
public class BasicController {

    @Resource
    private SoftwareService softwareService;

    @Resource
    private SoftwareModuleService moduleService;

    @Resource
    private TicketCategoryService categoryService;

    @Resource
    private LicenceService licenceService;

    @GetMapping("/software")
    public Collection<Software> getBasicSoftware() {
        return softwareService.getAll();
    }

    @GetMapping("/software-modules")
    public Collection<SoftwareModule> getBasicSoftwareModules(){
        return moduleService.getAll();
    }

    @GetMapping("/categories")
    public Collection<TicketCategory> getBasicTicketCategories(){
        return categoryService.getAll();
    }

    @GetMapping("/licences")
    public Collection<Licence> getBasicAllLicences(){
        return licenceService.getAll();
    }


//    @GetMapping("/developer")
//    public String getDev() {
//        return "HELLO DEVELOPER! THIS IS SERVICE DESK! DO YOU SEE ME?";
//    }
//
//    @GetMapping("/member")
//    public String getMember() {
//        return "HELLO MEMBER! THIS IS SERVICE DESK! DO YOU SEE ME?";
//    }
//
//    @GetMapping("/owner")
//    public String getOwner() {
//        return "HELLO OWNER! THIS IS SERVICE DESK! DO YOU SEE ME?";
//    }
//
//    @GetMapping("/member/tickets")
//    public String getTickets() {
//        return "HELLO OWNER! THIS IS TICKETS! DO YOU SEE ME?";
//    }
//

}
