package team.dna2.serviceDesk_server.databaseService.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MEMBERS")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@NoArgsConstructor
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true, nullable = false, updatable = false)
    private User user;

    @Column(name = "is_owner", nullable = false)
    private Boolean isOwner;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "organization_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Organization organization;
}
