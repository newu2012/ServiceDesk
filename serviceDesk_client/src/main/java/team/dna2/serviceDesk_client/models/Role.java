package team.dna2.serviceDesk_client.models;

public enum Role {
    MEMBER("Представитель Заказчика"),
    OWNER("Владелец ЛК Заказчика"),
    DEVELOPER("Разработчик");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return this.getRole();
    }
}
