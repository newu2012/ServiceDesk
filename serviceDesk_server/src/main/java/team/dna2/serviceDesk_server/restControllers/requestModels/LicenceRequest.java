package team.dna2.serviceDesk_server.restControllers.requestModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class LicenceRequest {

    private String serialNumber;

    @NotNull
    private Long organizationId;

    @NotNull
    private Long softwareId;

    private Timestamp startDate;

    private Timestamp expirationDate;

    private Integer usersLimit;

}
