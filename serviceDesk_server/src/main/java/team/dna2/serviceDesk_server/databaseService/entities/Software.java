package team.dna2.serviceDesk_server.databaseService.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "COMPENDIUM_SOFTWARE")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Software implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "software_name", unique = true, nullable = false, length = 128)
    private String name;

    @Column(name = "description", length = 1024)
    private String description;

    @Transient
    @OneToMany(mappedBy = "software")
    @JsonBackReference(value = "moduleReference")
    private Set<SoftwareModule> modules;

    @Transient
    @OneToMany(mappedBy = "software")
    @JsonBackReference(value = "moduleReference")
    private Set<Licence> licence;
}
