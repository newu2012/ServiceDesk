package team.dna2.serviceDesk_server.databaseService.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MEMBERS")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true, nullable = false)
    private User userDetails;

    @Column(name = "is_owner", nullable = false)
    private Boolean isOwner;

    @OneToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id", nullable = false)
    private Organization organization;
}
