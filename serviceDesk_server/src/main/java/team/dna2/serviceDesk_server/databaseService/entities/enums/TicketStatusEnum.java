package team.dna2.serviceDesk_server.databaseService.entities.enums;

import lombok.NoArgsConstructor;

@Deprecated
@NoArgsConstructor
public enum TicketStatusEnum {
    ОТКРЫТО,
    ЗАРЕГИСТРИРОВАНО,
    В_РАБОТЕ,
    ВЫПОЛНЕНО,
    ПЕРЕОТКРЫТО
}
