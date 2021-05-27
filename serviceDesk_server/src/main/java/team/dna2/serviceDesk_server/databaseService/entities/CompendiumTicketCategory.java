package team.dna2.serviceDesk_server.databaseService.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COMPENDIUM_TICKET_CATEGORIES")
@Data
@NoArgsConstructor
public class CompendiumTicketCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name", unique = true, nullable = false, length = 32)
    private String categoryName;

    @Column(name = "description", length = 1024)
    private String description;
}
