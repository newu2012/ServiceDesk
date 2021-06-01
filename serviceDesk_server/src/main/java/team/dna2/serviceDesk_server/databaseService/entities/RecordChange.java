package team.dna2.serviceDesk_server.databaseService.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.dna2.serviceDesk_server.databaseService.entities.enums.RecordTypeEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;


@Entity
@Table(name = "RECORD_CHANGES")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@NoArgsConstructor
public class RecordChange implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "editor_id", referencedColumnName = "id", nullable = false, updatable = false)
    private User user;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "ticket_id", referencedColumnName = "id", updatable = false)
    private Ticket ticket;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "comment_id", referencedColumnName = "id", updatable = false)
    private TicketComment comment;

    @Column(name = "date_time", nullable = false, updatable = false)
    private Timestamp dateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "record_type", nullable = false, length = 32, updatable = false)
    private RecordTypeEnum recordType;

    public RecordChange(User user, Ticket ticket){
        this.setUser(user);
        this.setRecordType(RecordTypeEnum.TICKET);
        this.setTicket(ticket);
        this.setDateTime(Timestamp.from(Instant.now()));
    }

    public RecordChange(User user, TicketComment comment){
        this.setUser(user);
        this.setRecordType(RecordTypeEnum.COMMENT);
        this.setComment(comment);
        this.setDateTime(Timestamp.from(Instant.now()));
    }
}
