package team.dna2.serviceDesk_client.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Software {
    public Long id;
    public String name;
    public String description;

    public static ArrayList<Software> software = new ArrayList<>(); // Список всех ПО в системе
    public ArrayList<SoftwareModule> softwareModules = new ArrayList<>(); // Список всех модулей этого ПО
    public static Long nextId = 0L;

    public Software(String name) {
       this.id = nextId++;
       this.name = name;
       this.description = "";
       this.softwareModules.add(new SoftwareModule(this.getId(), "Не определено"));
    }

    public Software(String name, String description) {
        this.id = nextId++;
        this.name = name;
        this.description =description;
        this.softwareModules.add(new SoftwareModule(this.getId(), "Не определено"));
    }

    public ArrayList<SoftwareModule> getSoftwareModules() {
        return softwareModules;
    }

    public SoftwareModule getSoftwareModuleById(int id) {
        return id == -1 || id > softwareModules.size() ? new SoftwareModule(this.getId(), "") : softwareModules
            .stream().filter(sm -> sm.getId() == id)
            .findFirst()
            .orElse(null);
    }

    public void addSoftwareModule(SoftwareModule softwareModule) {
        this.softwareModules.add(softwareModule);
    }

    //@Override
    //public String toString() {
    //    return this.getName();
    //}
}
