package team.dna2.serviceDesk_client.models;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public Long id;
    public String email;
    public String password;
    public String fullName;
    public String firstName;
    public String lastName;
    public String patronymicName;
    public String role;
    public String avatarFileName;
    public String avatarFile;
    public String orgAvatarFileName;
    public Boolean isActive;
    public String passwordConfirm;
    public Boolean credentialsNonExpired;
    public String username;
    public Boolean accountNonExpired;
    public Boolean accountNonLocked;
    public Boolean enabled;

    public String status;
    public Long organisationId;
    public Date registrationDate;
    public Date blockDate;

    public static ArrayList<User> users = new ArrayList<>(); // Список пользователей всей системы
    public static User currentUser; // Активный пользователь системы. Меняется после выхода из аккаунта.
    public static Long nextId = 0L;

    /**
     * WIP
     * Создание новых пользователей
     * @param email Электронная почта пользователя
     * @param password Пароль (пока не хэш) пользователя
     * @param fullName ФИО пользователя
     * @param role Роль пользователя (DEVELOPER, OWNER, MEMBER)
     */
    public User(String email,
                String password,
                String fullName,
                String role) {
        this.id = nextId++;
        this.email = email;
        this.password = password;
        this.fullName = fullName;

        String[] fullNameSplit = fullName.split(" ");
        lastName = (fullNameSplit[0]);
        firstName = (fullNameSplit[1]);
        if (fullNameSplit.length > 2)
            patronymicName = (fullNameSplit[2]);

        this.role = role;
        this.status = "Активен";
        this.registrationDate = new Date();
        this.blockDate = new Date(System.currentTimeMillis() + 1000000000);


        if (role.equals(Role.DEVELOPER.getRole())) {
            this.organisationId = -1L;
            this.avatarFileName = "developer.png";
        }
        else if (role.equals(Role.MEMBER.getRole()) ) {
            this.organisationId = 0L;
            this.avatarFileName = "Misha.png";
        }
        else if (role.equals(Role.OWNER.getRole()) ) {
            this.organisationId = 0L;
            this.avatarFileName = "Obabkov.jpeg";
        }
        this.orgAvatarFileName = "UrFU.png";
    }

    @Override
    public String toString() {
        return getFullName();
    }

    public void setFullName(String lastName, String firstName, String patronymic) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymicName = patronymic;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
        String[] fullNameSplit = User.currentUser.getFullName().split(" ");
        lastName = (fullNameSplit[0]);
        firstName = (fullNameSplit[1]);
        if (fullNameSplit.length > 2)
            patronymicName = (fullNameSplit[2]);
    }

    public void setFullName() {
        this.fullName = (lastName + " " + firstName + " " + patronymicName);
    }
}
