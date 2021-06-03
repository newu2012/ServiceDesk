package team.dna2.serviceDesk_client.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoftwareModule {
    public Long id;
    public Long softwareId;
    public String name;
    public String description;
    public Software software;

    public static ArrayList<SoftwareModule> softwareModules = new ArrayList<>();
    public static Long nextId = 0L;

    public SoftwareModule(Long softwareId, String name) {
        this(softwareId, name, "");
    }

    public SoftwareModule(Long softwareId, String name, String description) {
        this.id = nextId++;
        this.softwareId = softwareId;
        this.name = name;
        this.description = description;
        softwareModules.add(this);
    }

    //@Override
    //public String toString() {
    //    return this.getName();
    //}
}
