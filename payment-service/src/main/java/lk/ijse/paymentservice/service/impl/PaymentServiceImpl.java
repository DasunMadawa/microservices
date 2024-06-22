package lk.ijse.paymentservice.service.impl;

import lk.ijse.paymentservice.dto.PaymentDTO;
import lk.ijse.paymentservice.dto.TicketDTO;
import lk.ijse.paymentservice.dto.VehicleDTO;
import lk.ijse.paymentservice.entity.Payment;
import lk.ijse.paymentservice.entity.enums.Status;
import lk.ijse.paymentservice.exception.InvalidateException;
import lk.ijse.paymentservice.repo.PaymentRepo;
import lk.ijse.paymentservice.service.PaymentService;
import lk.ijse.paymentservice.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Mapping mapping;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean placePayment(PaymentDTO paymentDTO) {
        try {
            VehicleDTO vehicleDTO = restTemplate.getForObject("http://vehicle-service/hts/api/v1/vehicle/" + paymentDTO.getVehicleId(), VehicleDTO.class);
            TicketDTO ticketDTO = restTemplate.getForObject("http://ticket-service/hts/api/v1/ticket/" + paymentDTO.getTicketId(), TicketDTO.class);

            if (ticketDTO.getStatus().equals(Status.PENDING) && vehicleDTO != null) {
                ticketDTO.setStatus(Status.PAYED);

                HttpHeaders headers = new HttpHeaders();
                headers.set("Content-Type", "application/json");

                HttpEntity<TicketDTO> entity = new HttpEntity<>(ticketDTO, headers);

                ResponseEntity<TicketDTO> responseEntity = restTemplate.exchange("http://ticket-service/hts/api/v1/ticket/" + ticketDTO.getTicketId(), HttpMethod.PUT, entity, TicketDTO.class);

                if (responseEntity.getBody() != null) {
                    Payment payment = mapping.toPayment(paymentDTO);
                    paymentRepo.save(payment);
                    return true;

                }

            }

            throw new InvalidateException("Invalid Data");

        } catch (Exception e) {
            throw new InvalidateException("Invalid Data");

        }

    }

}
