package team.dna2.serviceDesk_client.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Category {
    public SimpleIntegerProperty id;
    public SimpleStringProperty name;
    public SimpleStringProperty description;

    public static ArrayList<Category> categories = new ArrayList<Category>(); // Список всех категорий обращений
    public static int nextId = 0;

    public Category(String name) {
        this.id = new SimpleIntegerProperty(nextId++);
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty("");
    }

    public Category(String name, String description) {
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
