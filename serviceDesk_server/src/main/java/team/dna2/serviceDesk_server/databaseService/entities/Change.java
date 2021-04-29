package team.dna2.serviceDesk_server.databaseService.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import team.dna2.serviceDesk_server.databaseService.entities.enums.RecordTypeEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "CHANGES")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Change implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "editor_user_id", referencedColumnName = "id", nullable = false)
    private User editorUser;

    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    private TicketComment comment;

    @Column(name = "date_time", nullable = false)
    private Timestamp dateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "record_type", nullable = false, length = 32)
    private RecordTypeEnum recordType;
}
