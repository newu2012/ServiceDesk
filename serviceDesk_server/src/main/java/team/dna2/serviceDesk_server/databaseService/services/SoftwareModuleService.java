package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.dna2.serviceDesk_server.databaseService.entities.SoftwareModule;
import team.dna2.serviceDesk_server.databaseService.repositories.SoftwareModulesRepository;
import team.dna2.serviceDesk_server.databaseService.repositories.SoftwareRepository;
import team.dna2.serviceDesk_server.restControllers.requestModels.SoftwareModuleRequest;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SoftwareModuleService {

    @Resource
    private SoftwareModulesRepository softwareModulesRepository;

    @Resource
    private SoftwareRepository softwareRepository;

    public SoftwareModule getOneById(Long id) {
        return softwareModulesRepository.getOne(id);
    }

    public List<SoftwareModule> getAll() {
        return softwareModulesRepository.findAll();
    }

    @Transactional
    public void createModuleFromRequest(SoftwareModuleRequest moduleRequest){
        var softwareModule = new SoftwareModule();
        softwareModule.setSoftware(softwareRepository.getOne(moduleRequest.getSoftwareId()));
        softwareModule.setName(moduleRequest.getName());
        softwareModule.setDescription(moduleRequest.getDescription());
        softwareModulesRepository.save(softwareModule);
    }
}
