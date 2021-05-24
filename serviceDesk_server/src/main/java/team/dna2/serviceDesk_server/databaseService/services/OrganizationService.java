package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import team.dna2.serviceDesk_server.databaseService.entities.Member;
import team.dna2.serviceDesk_server.databaseService.entities.Organization;
import team.dna2.serviceDesk_server.databaseService.repositories.MembersRepository;

@Service
public class OrganizationService {

    private MembersRepository membersRepository;

    public Organization getOrganizationByUserId(Long userId){
        var member = membersRepository.findMemberByUser_Id(userId);
        return member.get().getOrganization();
    }
}
