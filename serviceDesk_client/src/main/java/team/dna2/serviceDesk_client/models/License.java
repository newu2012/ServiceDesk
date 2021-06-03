package team.dna2.serviceDesk_client.models;

import lombok.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class License {
    private Long id;
    private String serialNumber;
    private Long organisationId;
    private Organization organization;
    private Software software;
    private Long softwareId;
    private Long usersLimit;
    private Timestamp startDate;
    private Timestamp expirationDate;
    private Boolean isActive;

    public static ArrayList<License> licenses = new ArrayList<>();
    public static Long nextId = 0L;

    public License(String serialNumber, Long organisationId, Long softwareId, Long usersLimit, Timestamp startDate, Timestamp expirationDate) {
        this.id = nextId++;
        this.serialNumber = serialNumber;
        this.organisationId = organisationId;
        this.softwareId = softwareId;
        this.usersLimit = usersLimit;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
    }
}
