package team.dna2.serviceDesk_server.databaseService.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.dna2.serviceDesk_server.databaseService.entities.enums.TicketStatusEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "TICKETS")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@NoArgsConstructor
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private User author;

    @Column(name = "title", nullable = false, length = 127)
    private String title;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    private TicketStatus status;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private TicketCategory category;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "software_module_id", referencedColumnName = "id", nullable = false)
    private SoftwareModule softwareModule;

    @Column(name = "creation_date", nullable = false)
    private Timestamp creationDate;

    @Column(name = "completed_date")
    private Timestamp completedDate;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "developer_id", referencedColumnName = "id")
    private Developer developer;

    @Column(name = "ticket_text", nullable = false, length = 8191)
    private String ticketText;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "organization_id", referencedColumnName = "id", nullable = false)
    private Organization organization;

//    @OneToOne
//    @JsonManagedReference
//    @JoinColumn(name = "last_change_id", referencedColumnName = "id")
//    private RecordChange lastChange;

    @OneToMany(mappedBy = "ticket")
    @JsonBackReference
    @Transient
    private Set<RecordChange> changes;
}
