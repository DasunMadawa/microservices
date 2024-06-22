package lk.ijse.ticketservice.service.impl;

import lk.ijse.ticketservice.dto.TicketDTO;
import lk.ijse.ticketservice.entity.Ticket;
import lk.ijse.ticketservice.exception.NotFoundException;
import lk.ijse.ticketservice.repo.TicketRepo;
import lk.ijse.ticketservice.service.TicketService;
import lk.ijse.ticketservice.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private Mapping mapping;

    @Override
    public boolean ticketCreate(TicketDTO ticketDTO) {
        ticketRepo.save(mapping.toTicket(ticketDTO));
        return true;

    }

    @Override
    public boolean statusUpdate(TicketDTO ticketDTO) {
        if (ticketRepo.existsById(ticketDTO.getTicketId())) {
            Ticket ticket = ticketRepo.getReferenceById(ticketDTO.getTicketId());

            ticket.setStatus(ticketDTO.getStatus());
            ticketRepo.save(ticket);
            return true;
        }

        throw new NotFoundException("Ticket Not Found");

    }

    @Override
    public TicketDTO getTicket(String ticketId) {
        if (ticketRepo.existsById(ticketId)) {
            return mapping.toTicketDTO(ticketRepo.getReferenceById(ticketId));

        }

        throw new NotFoundException("Ticket Not Found");

    }

}
