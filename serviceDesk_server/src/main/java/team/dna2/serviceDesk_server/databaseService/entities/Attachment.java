package team.dna2.serviceDesk_server.databaseService.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.dna2.serviceDesk_server.databaseService.entities.enums.RecordTypeEnum;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ATTACHMENTS")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@NoArgsConstructor
public class Attachment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "record_type", nullable = false, updatable = false)
    private RecordTypeEnum recordType;

    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id", updatable = false)
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "comment_id", referencedColumnName = "id", updatable = false)
    private TicketComment comment;

    @OneToOne
    @JoinColumn(name = "file_id", referencedColumnName = "id", nullable = false, updatable = false)
    private File file;

}
