package lk.ijse.ticketservice.dto;

import jakarta.validation.constraints.NotNull;
import lk.ijse.ticketservice.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketDTO {
    private String ticketId;
    @NotNull
    private Date date;
    private double price;
    @NotNull
    private String fromWhere;
    @NotNull
    private String toWhere;
    private Status status;
    @NotNull
    private String vehicleId;
    @NotNull
    private String userId;

}
