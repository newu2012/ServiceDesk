package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import team.dna2.serviceDesk_server.databaseService.entities.SoftwareModule;
import team.dna2.serviceDesk_server.databaseService.repositories.SoftwareModulesRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SoftwareModuleService {

    @Resource
    private SoftwareModulesRepository softwareModulesRepository;

    public SoftwareModule getOneById(Long id) {
        return softwareModulesRepository.getOne(id);
    }

    public List<SoftwareModule> getAll() {
        return softwareModulesRepository.findAll();
    }
}
