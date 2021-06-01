package team.dna2.serviceDesk_client.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {
    private Long id;
    private String name;
    private File logoFile;
    private String description;
    private Timestamp registrationDate;
    private Boolean isActive;
    private Timestamp blockDate;

    public static ArrayList<Organization> organizations = new ArrayList<>();

}
