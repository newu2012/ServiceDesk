package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import team.dna2.serviceDesk_server.databaseService.entities.CompendiumSoftware;
import team.dna2.serviceDesk_server.databaseService.repositories.CompendiumSoftwareRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompendiumSoftwareService {

    @Resource
    private CompendiumSoftwareRepository softwareRepository;

    public CompendiumSoftware getOneById(Long id) {
        return softwareRepository.getOne(id);
    }

    public List<CompendiumSoftware> getAllSoftware(){
        return softwareRepository.findAll();
    }
}
