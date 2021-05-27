package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import team.dna2.serviceDesk_server.databaseService.entities.CompendiumSoftwareModule;
import team.dna2.serviceDesk_server.databaseService.repositories.CompendiumSoftwareModulesRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompendiumSoftwareModuleService {

    @Resource
    private CompendiumSoftwareModulesRepository softwareModulesRepository;

    public CompendiumSoftwareModule getOneById(Long id) {
        return softwareModulesRepository.getOne(id);
    }

    public List<CompendiumSoftwareModule> getAllSoftwareModules(){
        return softwareModulesRepository.findAll();
    }
}
