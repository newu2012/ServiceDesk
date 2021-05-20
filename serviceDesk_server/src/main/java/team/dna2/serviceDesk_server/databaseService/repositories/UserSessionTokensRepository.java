package team.dna2.serviceDesk_server.databaseService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.dna2.serviceDesk_server.databaseService.entities.UserSessionToken;

import java.util.Optional;

@Repository
public interface UserSessionTokensRepository extends JpaRepository<UserSessionToken, Long> {

    //Взять активный токен юзера
    //(optional<> здесь для того чтобы если их несколько, не было исключения в рантайме)
    Optional<UserSessionToken> findUserSessionTokenByUser_IdAndIsActiveTrue(Long userId);
}
