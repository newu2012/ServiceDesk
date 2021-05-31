package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import team.dna2.serviceDesk_server.databaseService.entities.Licence;
import team.dna2.serviceDesk_server.databaseService.repositories.LicencesRepository;

import javax.annotation.Resource;
import java.util.List;


@Service
public class LicenceService {

    @Resource
    private LicencesRepository licencesRepository;

    public Licence getOneById(Long id) {
        return licencesRepository.getOne(id);
    }

    public List<Licence> getAll() {
        return licencesRepository.findAll();
    }

//    public String addNewLicence(Licence newLicence) {
//        licencesRepository.save(newLicence);
//        return
//    }
}
