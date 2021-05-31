package team.dna2.serviceDesk_server.databaseService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.dna2.serviceDesk_server.databaseService.entities.RecordChange;

@Repository
public interface RecordChangesRepository extends JpaRepository<RecordChange, Long> {

    //Взять последнее изменение коммента
    RecordChange findFirstByComment_IdOrderByDateTimeDesc(Long commentId);

    //Взять последнее изменение тикета
    RecordChange findFirstByTicket_IdOrderByDateTimeDesc(Long ticketId);


}
