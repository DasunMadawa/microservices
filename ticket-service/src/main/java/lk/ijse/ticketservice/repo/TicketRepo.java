package lk.ijse.ticketservice.repo;

import lk.ijse.ticketservice.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket , String> {


}
