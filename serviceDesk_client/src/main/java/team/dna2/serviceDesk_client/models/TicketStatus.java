package team.dna2.serviceDesk_client.models;

public enum TicketStatus {
    OPEN("Открыто"),
    REGISTERED("Зарегестрировано"),
    IN_WORK("В работе"),
    FIXED("Исправлено"),
    REOPENED("Переоткрыто");

    private final String status;

    TicketStatus(String status) {
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
