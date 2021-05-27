package team.dna2.serviceDesk_server.databaseService.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "COMPENDIUM_LICENCES")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
public class CompendiumLicence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id", nullable = false)
    private Organization organization;

    @OneToOne
    @JoinColumn(name = "software_id", referencedColumnName = "id", nullable = false)
    private CompendiumSoftware software;

    @Column(name = "expiration_date", nullable = false)
    private Timestamp expirationDate;

    @Column(name = "users_limit", nullable = false)
    private Integer usersLimit;

}
