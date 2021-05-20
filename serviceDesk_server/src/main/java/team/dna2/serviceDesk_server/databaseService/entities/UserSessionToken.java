package team.dna2.serviceDesk_server.databaseService.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "USER_SESSION_TOKENS")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserSessionToken implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "token", nullable = false, length = 127)
    private String token;

    @Column(name = "expiration_datetime", nullable = false)
    private Timestamp expirationDateTime;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}
