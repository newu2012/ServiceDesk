package team.dna2.serviceDesk_server.restControllers.requestModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class TicketRequest {

    @NotNull
    private Long authorId;

    @NotNull
    private Long categoryId;

    @NotNull
    private String title;

    @NotNull
    private String text;

    @NotNull
    private Long softwareModuleId;

    private Long organizationId;

}
