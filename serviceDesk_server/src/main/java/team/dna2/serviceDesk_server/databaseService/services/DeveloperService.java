package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import team.dna2.serviceDesk_server.databaseService.entities.Developer;
import team.dna2.serviceDesk_server.databaseService.repositories.DevelopersRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeveloperService {

    @Resource
    private DevelopersRepository developersRepository;

    public Developer getOneById(Long id) {
        return developersRepository.getOne(id);
    }

    public List<Developer> getAll() {
        return developersRepository.findAll();
    }
}
