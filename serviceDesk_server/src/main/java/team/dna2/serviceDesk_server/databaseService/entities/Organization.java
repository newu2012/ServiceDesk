package team.dna2.serviceDesk_server.databaseService.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "ORGANIZATIONS")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Organization implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "organization_name", unique = true, nullable = false, length = 63)
    private String name;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "logo_file_id", referencedColumnName = "id")
    private File logoFile;

    @Column(name = "description", length = 1024)
    private String description;

    @Column(name = "registration_date", nullable = false, updatable = false)
    private Timestamp registrationDate;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "block_date")
    private Timestamp blockDate;

    @Transient
    @OneToMany(mappedBy = "organization")
    @JsonBackReference(value = "licenceReference")
    private Set<Licence> licenceSet;

    @Transient
    @OneToMany(mappedBy = "organization")
    @JsonBackReference(value = "memberReference")
    private Set<Member> members;

    @Transient
    @OneToMany(mappedBy = "organization")
    @JsonBackReference(value = "ticketReference")
    private Set<Ticket> ticketSet;
}
