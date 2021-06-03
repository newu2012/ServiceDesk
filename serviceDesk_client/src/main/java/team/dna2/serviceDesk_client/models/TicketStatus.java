package team.dna2.serviceDesk_client.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketStatus {
    private Long id;
    private String name;
    private String description;

    public static ArrayList<TicketStatus> ticketStatuses = new ArrayList<>();

    @Override
    public String toString() {
        return this.getName();
    }
}
