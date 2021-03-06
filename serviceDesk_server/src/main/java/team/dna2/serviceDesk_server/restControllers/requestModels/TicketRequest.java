package team.dna2.serviceDesk_server.restControllers.requestModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class TicketRequest {

    @NotNull
    @Min(1)
    private Long authorId;

    @NotNull
    @Min(1)
    private Long categoryId;

    @NotNull
    @Size(max = 127, min = 8)
    private String title;

    @NotNull
    @Size(max = 8191, min = 8)
    private String text;

    @NotNull
    @Min(1)
    private Long softwareModuleId;

    @Min(1)
    private Long organizationId;

}
