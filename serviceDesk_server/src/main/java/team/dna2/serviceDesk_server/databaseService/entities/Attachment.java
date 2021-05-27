package team.dna2.serviceDesk_server.databaseService.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import team.dna2.serviceDesk_server.databaseService.entities.enums.RecordTypeEnum;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ATTACHMENTS")
@Data
@NoArgsConstructor
public class Attachment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "record_type", nullable = false, length = 32)
    private RecordTypeEnum recordType;

    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    private TicketComment comment;

    @OneToOne
    @JoinColumn(name = "file_id", referencedColumnName = "id", nullable = false)
    private File file;

}
