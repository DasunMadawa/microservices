package lk.ijse.ticketservice.controller;

import jakarta.validation.Valid;
import lk.ijse.ticketservice.dto.TicketDTO;
import lk.ijse.ticketservice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/health")
    public String ticketHealthCheck() {
        return "Ticket OK !";

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDTO> saveTicket(@Valid @RequestBody TicketDTO ticketDTO) {
        try {
            ticketService.ticketCreate(ticketDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(ticketDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }

    }

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDTO> updateStatus(@Valid @PathVariable("id") String ticketId, @RequestBody TicketDTO ticketDTO) {
        try {
            ticketDTO.setTicketId(ticketId);
            ticketService.statusUpdate(ticketDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(ticketDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }

    }

    @GetMapping(value = "{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDTO> getVehicle(@PathVariable("id") String ticketId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ticketService.getTicket(ticketId));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }

    }

}
