package team.dna2.serviceDesk_server.databaseService.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "COMPENDIUM_ROLES")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
@NoArgsConstructor
public class Role implements Serializable, GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    //В любом удобном виде, например - Представитель заказчика
    @Column(name = "informal_name")
    private String informalName;

    //В формате "ROLE_ИМЯ", например - ROLE_MEMBER
    @Column(name = "formatted_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Transient
    @JsonBackReference
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(Long id) {
        this.id = id;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
