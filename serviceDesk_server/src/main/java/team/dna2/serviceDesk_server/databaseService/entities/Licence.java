package team.dna2.serviceDesk_server.databaseService.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "COMPENDIUM_LICENCES")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
public class Licence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "serial_number", unique = true)
    private String serialNumber;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "organization_id", referencedColumnName = "id", nullable = false)
    private Organization organization;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "software_id", referencedColumnName = "id", nullable = false)
    private Software software;

    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;

    //Если не заполнено - значит бессрочная
    @Column(name = "expiration_date")
    private Timestamp expirationDate;

    //Если не заполнено - значит неограниченное количество юзеров
    @Column(name = "users_limit")
    private Integer usersLimit;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}
