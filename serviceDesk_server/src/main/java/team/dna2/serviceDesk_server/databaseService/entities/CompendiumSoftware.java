package team.dna2.serviceDesk_server.databaseService.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COMPENDIUM_SOFTWARE")
@Data
@NoArgsConstructor
public class CompendiumSoftware implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "software_name", unique = true, nullable = false, length = 128)
    private String softwareName;

    @Column(name = "description", length = 1024)
    private String description;
}
