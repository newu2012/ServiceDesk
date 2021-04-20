package team.dna2.serviceDesk_client.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class User {
    public SimpleIntegerProperty id;
    public SimpleStringProperty email;
    public SimpleStringProperty password;
    public SimpleStringProperty fullName;

    public static ArrayList<User> users = new ArrayList<User>(); // Список пользователей всей системы
    public static User currentUser; // Активный пользователь системы. Меняется после выхода из аккаунта.
    public static int nextId = 1;

    /**
     * WIP ?
     * Создание новых пользователей
     * @param email Электронная почта пользователя
     * @param password Пароль (пока не хэш) пользователя
     * @param fullName ФИО пользователя
     */
    public User(String email,
                String password,
                String fullName) {
        this.id = new SimpleIntegerProperty(nextId++);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.fullName = new SimpleStringProperty(fullName);
    }

    public int getId() {
        return id.get();
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
