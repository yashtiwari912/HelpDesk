package com.yashdev.helpdesk.helpdesk.tools;

import com.yashdev.helpdesk.helpdesk.Enum.Status;
import com.yashdev.helpdesk.helpdesk.dto.CreateTicketRequest;
import com.yashdev.helpdesk.helpdesk.dto.UpdateTicketRequest;
import com.yashdev.helpdesk.helpdesk.entity.Ticket;
import com.yashdev.helpdesk.helpdesk.service.TiceketService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketDatabaseTool {

    private final TiceketService ticketService;

    @Tool(description = "Creates a new helpdesk ticket.")
    public Ticket createTicketTool(
            @ToolParam(description = "Ticket details")
            CreateTicketRequest request
    ) {

        Ticket ticket = Ticket.builder()
                .email(request.getEmail())
                .summary(request.getSummary())
                .description(request.getDescription())
                .category(request.getCategory())
                .priority(request.getPriority())
                .status(Status.OPEN)          // Default value
                .build();

        return ticketService.createTicket(ticket);
    }

    @Tool(description = "This tool helps to get ticket by email.")
    public Ticket getTicketByEmailId(@ToolParam(description = "email whose ticket is required ") String emailId) {
        return ticketService.getTicketByEmail(emailId);
    }

    @Tool(description = "Updates an existing ticket.")
    public Ticket updateTicket(
            @ToolParam(description = "Updated ticket details")
            UpdateTicketRequest request
    ) {

        Ticket ticket = ticketService.getTicket(request.getId());

        if(ticket == null){
            return null;
        }

        ticket.setSummary(request.getSummary());
        ticket.setDescription(request.getDescription());
        ticket.setCategory(request.getCategory());
        ticket.setPriority(request.getPriority());
        ticket.setStatus(request.getStatus());

        return ticketService.updateTicket(ticket);
    }

    // get current system time
    @Tool(description = "This tool helps to get current system time.")
    public String getCurrentTime() {
        return String.valueOf(System.currentTimeMillis());
    }


}
