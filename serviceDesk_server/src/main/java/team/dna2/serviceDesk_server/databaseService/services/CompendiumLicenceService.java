package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import team.dna2.serviceDesk_server.databaseService.entities.CompendiumLicence;
import team.dna2.serviceDesk_server.databaseService.repositories.CompendiumLicencesRepository;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CompendiumLicenceService {

    @Resource
    private CompendiumLicencesRepository licencesRepository;

    public CompendiumLicence getOneById(Long id) {
        return licencesRepository.getOne(id);
    }

    public List<CompendiumLicence> getAllLicences(){
        return licencesRepository.findAll();
    }

//    public String addNewLicence(CompendiumLicence newLicence) {
//        licencesRepository.save(newLicence);
//        return
//    }
}
