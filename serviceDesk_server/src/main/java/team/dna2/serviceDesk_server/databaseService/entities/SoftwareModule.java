package team.dna2.serviceDesk_server.databaseService.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "COMPENDIUM_SOFTWARE_MODULES")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class SoftwareModule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "software_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Software software;

    @Column(name = "module_name", nullable = false, length = 128)
    private String name;

    @Column(name = "description", length = 1024)
    private String description;

    @Transient
    @OneToMany(mappedBy = "softwareModule")
    @JsonBackReference
    private Set<Ticket> ticketSet;
}
