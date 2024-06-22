package lk.ijse.paymentservice.controller;

import lk.ijse.paymentservice.dto.PaymentDTO;
import lk.ijse.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/health")
    public String paymentHealthCheck() {
        return "Payment OK !";

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity placePayment(@RequestBody PaymentDTO paymentDTO) {
        try {
            paymentService.placePayment(paymentDTO);
            return ResponseEntity.status(HttpStatus.OK).body(paymentDTO);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(paymentDTO);

        }

    }

}
