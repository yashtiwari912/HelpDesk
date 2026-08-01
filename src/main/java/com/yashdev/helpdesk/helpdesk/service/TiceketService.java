package com.yashdev.helpdesk.helpdesk.service;


import com.yashdev.helpdesk.helpdesk.entity.Ticket;
import com.yashdev.helpdesk.helpdesk.repository.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class TiceketService {

    private final TicketRepository  ticketRepository;

    //create Ticeket
    @Transactional
    public Ticket createTicket(Ticket ticket){
        ticket.setId(null);
        return ticketRepository.save(ticket);
    }

    //update Ticket
    @Transactional
    public Ticket updateTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }


    // get Ticket Logic

    public Ticket getTicket(Long ticketId){
        return ticketRepository.findById(ticketId).orElse(null);
    }

    //get Ticket by email


    public Ticket getTicketByEmail(String email){
        return ticketRepository.findByEmail(email).orElse(null);
    }

}
