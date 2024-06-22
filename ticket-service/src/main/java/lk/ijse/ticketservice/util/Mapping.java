package lk.ijse.ticketservice.util;

import lk.ijse.ticketservice.dto.TicketDTO;
import lk.ijse.ticketservice.entity.Ticket;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private GenerateID generateID;

    public TicketDTO toTicketDTO(Ticket ticket) {
        return modelMapper.map(ticket, TicketDTO.class);

    }

    public Ticket toTicket(TicketDTO ticketDTO) {
        ticketDTO.setTicketId(generateID.generateUUID());
        return modelMapper.map(ticketDTO , Ticket.class);

    }


}
