package team.dna2.serviceDesk_client.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Category {
    public Long id;
    public String name;
    public String description;

    public static ArrayList<Category> categories = new ArrayList<>();
    public static Long nextId = 0L;

    public Category(String name) {
        new Category(name, "");
    }

    public Category(String name, String description) {
        this.id = nextId++;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
