package team.dna2.serviceDesk_client.models;

public enum Role {
    MEMBER("Представитель Заказчика"),
    OWNER("Владелец ЛК Заказчика"),
    DEVELOPER("Разработчик");

    private final String status;

    Role(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return this.getStatus();
    }
}
