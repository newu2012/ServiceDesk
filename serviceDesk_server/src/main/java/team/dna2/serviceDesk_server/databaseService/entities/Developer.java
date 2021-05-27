package team.dna2.serviceDesk_server.databaseService.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DEVELOPERS")
@Data
@NoArgsConstructor
public class Developer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true, nullable = false)
    private User userDetails;

    @Column(name = "bio", length = 512)
    private String bio;
}
