package team.dna2.serviceDesk_server.databaseService.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "USERS")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@NoArgsConstructor
public class User implements Serializable, UserDetails {
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

    @ManyToMany(fetch = FetchType.EAGER)
    //@JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    @JoinColumn(nullable = false)
    private Set<Role> roles;

    @OneToOne
    @JoinColumn(name = "avatar_file_id", referencedColumnName = "id")
    private File avatarFile;

    @Column(name = "registration_date", nullable = false)
    private Timestamp registrationDate;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "block_date")
    private Timestamp blockDate;

    @Transient
    private String passwordConfirm;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
