package team.dna2.serviceDesk_client.models;

import javafx.beans.property.SimpleIntegerProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
public class License {
    private Long id;
    private String serialNumber;
    private Long organisationId;
    private Long softwareId;
    private Long limit;
    private Date startDate;
    private Date endDate;

    public static ArrayList<License> licenses = new ArrayList<>();
    public static Long nextId = 0L;

    public License(String serialNumber, Long organisationId, Long softwareId, Long limit, Date startDate, Date endDate) {
        this.id = nextId++;
        this.serialNumber = serialNumber;
        this.organisationId = organisationId;
        this.softwareId = softwareId;
        this.limit = limit;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
