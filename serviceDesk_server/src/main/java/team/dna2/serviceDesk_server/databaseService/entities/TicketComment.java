package team.dna2.serviceDesk_server.databaseService.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "TICKET_COMMENTS")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class TicketComment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "ticket_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Ticket ticket;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false, updatable = false)
    private User user;

    @Column(name = "comment_text", nullable = false, length = 2047)
    private String commentText;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private Timestamp creationDate;

//    @OneToOne
//    @JsonManagedReference
//    @JoinColumn(name = "last_change_id", referencedColumnName = "id")
//    private RecordChange lastChange;

    @Transient
    @OneToMany(mappedBy = "comment")
    @JsonBackReference(value = "recordChangeReference")
    private Set<RecordChange> changes;

    @Transient
    @OneToMany(mappedBy = "comment")
    @JsonBackReference(value = "attachmentReference")
    private Set<Attachment> attachments;
}
