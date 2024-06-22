package lk.ijse.ticketservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lk.ijse.ticketservice.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Ticket {
    @Id
    private String ticketId;
    private Date date;
    private double price;
    private String fromWhere;
    private String toWhere;

    @Enumerated(EnumType.STRING)
    private Status status;
    @NotNull
    private String vehicleId;
    @NotNull
    private String userId;

}
