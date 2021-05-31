package team.dna2.serviceDesk_server.databaseService.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "TICKET_COMMENTS")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@NoArgsConstructor
public class TicketComment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Ticket ticket;

    @OneToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false, updatable = false)
    private User author;

    @Column(name = "comment_text", nullable = false, length = 2047)
    private String commentText;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private Timestamp creationDate;

    @OneToOne
    @JoinColumn(name = "last_change_id", referencedColumnName = "id")
    private RecordChange lastChange;
}
