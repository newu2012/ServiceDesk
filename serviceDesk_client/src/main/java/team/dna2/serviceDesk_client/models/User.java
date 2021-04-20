package team.dna2.serviceDesk_client.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Component
public class User {
    public SimpleIntegerProperty id;
    public SimpleStringProperty email;
    public SimpleStringProperty password;
    public SimpleStringProperty fullName;

    public static ArrayList<User> users = new ArrayList<User>();
    public static int nextId;

    public User(String email,
                String password,
                String fullName) {
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.fullName = new SimpleStringProperty(fullName);
    }

    public int getId() {
        return id.get();
    }

    public void setId() {
        this.id.set(nextId++);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getFullName() {
        return fullName.get();
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

}
