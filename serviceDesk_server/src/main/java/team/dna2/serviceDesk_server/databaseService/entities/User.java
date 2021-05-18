package team.dna2.serviceDesk_server.databaseService.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import team.dna2.serviceDesk_server.databaseService.entities.enums.UserRoleEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false, unique = true, length = 63)
    private String email;

//    @Column(name = "login", nullable = false, unique = true, updatable = false, length = 63)
//    private String login;

    @Column(name = "password_hash", nullable = false, length = 127)
    private String passwordHash;

    @Column(name = "last_name", nullable = false, length = 31)
    private String lastName;

    @Column(name = "first_name", nullable = false, length = 31)
    private String firstName;

    @Column(name = "patronymic_name", length = 31)
    private String patronymicName;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 63)
    private UserRoleEnum role;

    @OneToOne
    @JoinColumn(name = "avatar_file_id", referencedColumnName = "id")
    private File avatarFile;

    @Column(name = "registration_date", nullable = false)
    private Timestamp registrationDate;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "block_date")
    private Timestamp blockDate;
}
