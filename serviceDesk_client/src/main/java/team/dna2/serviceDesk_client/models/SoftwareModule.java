package team.dna2.serviceDesk_client.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SoftwareModule {
    public SimpleIntegerProperty id;
    public SimpleIntegerProperty softwareId;
    public SimpleStringProperty name;
    public SimpleStringProperty description;

    public static int nextId = 0;

    public SoftwareModule(Integer softwareId, String name) {
        this.id = new SimpleIntegerProperty(nextId++);
        this.softwareId = new SimpleIntegerProperty(softwareId);
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty("");
    }

    public SoftwareModule(Integer softwareId, String name, String description) {
        this.id = new SimpleIntegerProperty(nextId++);
        this.softwareId = new SimpleIntegerProperty(softwareId);
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
    }

    public int getId() {
        return id.get();
    }

    public int getSoftwareId() {
        return softwareId.get();
    }

    public void setSoftwareId(Integer softwareId) {
        this.softwareId.set(softwareId);
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

    @Override
    public String toString() {
        return this.getName();
    }
}
