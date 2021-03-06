package team.dna2.serviceDesk_server.databaseService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import team.dna2.serviceDesk_server.databaseService.entities.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("UPDATE User SET isActive = false, blockDate = current_timestamp WHERE id = :id")
    void blockUserById(Long id);

    @Modifying
    @Query("UPDATE User SET isActive = true, blockDate = null WHERE id = :id")
    void unblockUserById(Long id);

    User findByEmail(String email);
}
