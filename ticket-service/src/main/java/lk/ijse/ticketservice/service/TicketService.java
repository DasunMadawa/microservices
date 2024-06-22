package lk.ijse.ticketservice.service;

import lk.ijse.ticketservice.dto.TicketDTO;

public interface TicketService {
    boolean ticketCreate(TicketDTO ticketDTO);
    boolean statusUpdate(TicketDTO ticketDTO);
    TicketDTO getTicket(String ticketId);

}
