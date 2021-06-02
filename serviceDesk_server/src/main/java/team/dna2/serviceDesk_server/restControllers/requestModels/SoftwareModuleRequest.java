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
public class SoftwareModuleRequest {

    @NotNull
    @Min(1)
    private Long softwareId;

    @NotNull
    @Size(max = 128, min = 2)
    private String name;

    @Size(max = 1024, min = 2)
    private String description;
}
