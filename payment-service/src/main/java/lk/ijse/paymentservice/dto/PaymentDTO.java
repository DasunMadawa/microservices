package lk.ijse.paymentservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO {
    private String paymentId;
    private Date date;
    @NotNull
    private String ticketId;
    @NotNull
    private String userId;
    @NotNull
    private String vehicleId;

}
