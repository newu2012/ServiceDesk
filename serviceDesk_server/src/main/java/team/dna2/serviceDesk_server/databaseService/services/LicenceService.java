package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.dna2.serviceDesk_server.databaseService.entities.Licence;
import team.dna2.serviceDesk_server.databaseService.repositories.LicencesRepository;
import team.dna2.serviceDesk_server.databaseService.repositories.OrganizationsRepository;
import team.dna2.serviceDesk_server.databaseService.repositories.SoftwareRepository;
import team.dna2.serviceDesk_server.restControllers.requestModels.LicenceRequest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;


@Service
public class LicenceService {

    @Resource
    private LicencesRepository licencesRepository;

    @Resource
    private OrganizationsRepository organizationsRepository;

    @Resource
    private SoftwareRepository softwareRepository;

    public Licence getOneById(Long id) {
        return licencesRepository.getOne(id);
    }

    public List<Licence> getAll() {
        return licencesRepository.findAll();
    }

    @Transactional
    public void createLicenceFromRequest(LicenceRequest licenceRequest){
        var licence = new Licence();
        licence.setSerialNumber(licenceRequest.getSerialNumber());
        licence.setOrganization(organizationsRepository.getOne(licenceRequest.getOrganizationId()));
        licence.setSoftware(softwareRepository.getOne(licenceRequest.getSoftwareId()));
        licence.setStartDate(licenceRequest.getStartDate() == null ? Timestamp.from(Instant.now()) : licenceRequest.getStartDate());
        licence.setExpirationDate(licenceRequest.getExpirationDate());
        licence.setUsersLimit(licenceRequest.getUsersLimit());
        licence.setIsActive(true);
        licencesRepository.save(licence);
    }
}
