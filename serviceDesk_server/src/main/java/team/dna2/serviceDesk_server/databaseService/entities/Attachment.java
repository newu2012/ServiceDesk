package team.dna2.serviceDesk_server.databaseService.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    @JoinColumn(name = "ticket_id", referencedColumnName = "id", updatable = false)
    private Ticket ticket;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "comment_id", referencedColumnName = "id", updatable = false)
    private TicketComment comment;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "file_id", referencedColumnName = "id", nullable = false, updatable = false)
    private File file;

}
