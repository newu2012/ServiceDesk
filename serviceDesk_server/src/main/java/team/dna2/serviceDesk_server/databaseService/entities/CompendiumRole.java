package team.dna2.serviceDesk_server.databaseService.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "COMPENDIUM_ROLES")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CompendiumRole implements Serializable, GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "informal_name")
    private String informalName;

    //В формате "ROLE_ИМЯ", например - ROLE_MEMBER
    @Column(name = "formatted_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public CompendiumRole (Long id) {
        this.id = id;
    }

    public CompendiumRole (Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
