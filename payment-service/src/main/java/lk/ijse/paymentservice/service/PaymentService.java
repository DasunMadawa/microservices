package lk.ijse.paymentservice.service;

import lk.ijse.paymentservice.dto.PaymentDTO;

public interface PaymentService {
    boolean placePayment(PaymentDTO paymentDTO);

}
