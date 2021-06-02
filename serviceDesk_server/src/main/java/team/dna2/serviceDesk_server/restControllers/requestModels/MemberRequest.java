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
public class MemberRequest {

    @NotNull
    @Min(1)
    private Long organizationId;

    @NotNull
    @Size(min = 5, max = 63)
    private String email;

    @NotNull
    @Size(min = 3, max = 127)
    private String password;

    @NotNull
    @Size(min = 1, max = 31)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 31)
    private String lastName;

    @NotNull
    @Size(min = 1, max = 31)
    private String patronymicName;
}
