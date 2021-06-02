package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.dna2.serviceDesk_server.databaseService.entities.Software;
import team.dna2.serviceDesk_server.databaseService.repositories.SoftwareRepository;
import team.dna2.serviceDesk_server.restControllers.requestModels.SoftwareRequest;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SoftwareService {

    @Resource
    private SoftwareRepository softwareRepository;

    public Software getOneById(Long id) {
        return softwareRepository.getOne(id);
    }

    public List<Software> getAll() {
        return softwareRepository.findAll();
    }

    @Transactional
    public void createSoftwareFromRequest(SoftwareRequest softwareRequest){
        var software = new Software();
        software.setName(softwareRequest.getName());
        software.setDescription(softwareRequest.getDescription());
        softwareRepository.save(software);
    }
}
