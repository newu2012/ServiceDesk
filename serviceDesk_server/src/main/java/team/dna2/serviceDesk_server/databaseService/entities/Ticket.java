package team.dna2.serviceDesk_server.databaseService.entities;

import lombok.*;
import org.springframework.context.annotation.Bean;
import team.dna2.serviceDesk_server.databaseService.entities.enums.TicketStatusEnum;
import team.dna2.serviceDesk_server.databaseService.repositories.MembersRepository;
import team.dna2.serviceDesk_server.databaseService.repositories.OrganizationsRepository;
import team.dna2.serviceDesk_server.databaseService.services.OrganizationService;

import javax.annotation.Resource;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "TICKETS")
@Data
@NoArgsConstructor
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_user_id", referencedColumnName = "id", nullable = false)
    private User author;

    @Column(name = "title", nullable = false, length = 127)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 63)
    private TicketStatusEnum status;

    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private CompendiumTicketCategory category;

    @OneToOne
    @JoinColumn(name = "software_module_id", referencedColumnName = "id", nullable = false)
    private CompendiumSoftwareModule softwareModule;

    @Column(name = "creation_date", nullable = false)
    private Timestamp creationDate;

    @Column(name = "completed_date")
    private Timestamp completedDate;

    @OneToOne
    @JoinColumn(name = "developer_id", referencedColumnName = "id")
    private Developer developer;

    @Column(name = "ticket_text", nullable = false, length = 8191)
    private String ticketText;

    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id", nullable = false)
    private Organization organization;

}
