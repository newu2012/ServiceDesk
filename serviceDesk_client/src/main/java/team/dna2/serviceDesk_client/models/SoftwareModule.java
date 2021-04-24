package team.dna2.serviceDesk_client.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SoftwareModule {
    public SimpleIntegerProperty id;
    public SimpleStringProperty name;
    public SimpleStringProperty description;

    public static int nextId = 1;

    public SoftwareModule(String name) {
        this.id = new SimpleIntegerProperty(nextId++);
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty("");
    }

    public SoftwareModule(String name, String description) {
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

    @Override
    public String toString() {
        return this.getName();
    }
}
