package team.dna2.serviceDesk_client.models;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.util.StringConverter;

import java.util.ArrayList;

public class Software {
    public SimpleIntegerProperty id;
    public SimpleStringProperty name;
    public SimpleStringProperty description;

    public static ArrayList<Software> software = new ArrayList<Software>(); // Список всех ПО в системе
    public ArrayList<SoftwareModule> softwareModules = new ArrayList<SoftwareModule>(); // Список всех модулей этого ПО

    public static int nextId = 1;

    public Software(String name) {
        this.id = new SimpleIntegerProperty(nextId++);
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty("");
    }

    public Software(String name, String description) {
        this.id = new SimpleIntegerProperty(nextId++);
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
    }

    public int getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public ArrayList<SoftwareModule> getSoftwareModules() {
        return softwareModules;
    }

    public void setSoftwareModules(ArrayList<SoftwareModule> softwareModules) {
        this.softwareModules = softwareModules;
    }

    public void addSoftwareModule(SoftwareModule softwareModule) {
        this.softwareModules.add(softwareModule);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
