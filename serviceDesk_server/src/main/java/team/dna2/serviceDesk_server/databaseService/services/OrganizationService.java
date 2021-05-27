package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import team.dna2.serviceDesk_server.databaseService.entities.Organization;
import team.dna2.serviceDesk_server.databaseService.repositories.MembersRepository;
import team.dna2.serviceDesk_server.databaseService.repositories.OrganizationsRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrganizationService {

    @Resource
    private MembersRepository membersRepository;
    @Resource
    private OrganizationsRepository organizationsRepository;

    public Organization getOrganizationByUserId(Long userId) {
        var member = membersRepository.findMemberByUser_Id(userId);
        return member.get().getOrganization();
    }

    public Organization getOneById(Long id) {
        return organizationsRepository.getOne(id);
    }

    public List<Organization> getAll() {
        return organizationsRepository.findAll();
    }
}
