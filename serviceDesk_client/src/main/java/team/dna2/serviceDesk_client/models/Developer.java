package team.dna2.serviceDesk_client.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Developer {
    private Long id;
    private User user;
    private String bio;
}
