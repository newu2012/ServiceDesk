package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import team.dna2.serviceDesk_server.databaseService.entities.Software;
import team.dna2.serviceDesk_server.databaseService.repositories.SoftwareRepository;

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
}
