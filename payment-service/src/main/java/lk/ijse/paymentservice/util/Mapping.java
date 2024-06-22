package lk.ijse.paymentservice.util;

import lk.ijse.paymentservice.dto.PaymentDTO;
import lk.ijse.paymentservice.entity.Payment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private GenerateID generateID;

    public PaymentDTO toPaymentDTO(Payment payment) {
        return modelMapper.map(payment, PaymentDTO.class);

    }

    public Payment toPayment(PaymentDTO paymentDTO) {
        paymentDTO.setPaymentId(generateID.generateUUID());
        return modelMapper.map(paymentDTO , Payment.class);

    }


}
