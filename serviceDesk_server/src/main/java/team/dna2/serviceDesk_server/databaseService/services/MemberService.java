package team.dna2.serviceDesk_server.databaseService.services;

import org.springframework.stereotype.Service;
import team.dna2.serviceDesk_server.databaseService.entities.Member;
import team.dna2.serviceDesk_server.databaseService.repositories.MembersRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberService {

    @Resource
    private MembersRepository membersRepository;

    public Member getOneById(Long id) {
        return membersRepository.getOne(id);
    }

    public List<Member> getAll() {
        return membersRepository.findAll();
    }
}
