package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.dna2.serviceDesk_server.databaseService.entities.Developer;
import team.dna2.serviceDesk_server.databaseService.repositories.DevelopersRepository;
import team.dna2.serviceDesk_server.databaseService.repositories.UsersRepository;
import team.dna2.serviceDesk_server.restControllers.requestModels.DeveloperRequest;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeveloperService {

    @Resource
    private DevelopersRepository developersRepository;

    @Resource
    private UsersRepository usersRepository;

    @Resource
    private UserService userService;

    public Developer getOneById(Long id) {
        return developersRepository.getOne(id);
    }

    public List<Developer> getAll() {
        return developersRepository.findAll();
    }

    @Transactional
    public void createDeveloperFromRequest(DeveloperRequest developerRequest) throws Exception{
        var developer = new Developer();
        userService.createUserDeveloperFromRequest(developerRequest);
        developer.setUser(usersRepository.findByEmail(developerRequest.getEmail()));
        developer.setBio(developerRequest.getBio());
        developersRepository.save(developer);
    }
}
