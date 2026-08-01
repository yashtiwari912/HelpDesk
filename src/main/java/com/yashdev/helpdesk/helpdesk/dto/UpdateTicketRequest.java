package com.yashdev.helpdesk.helpdesk.dto;

import com.yashdev.helpdesk.helpdesk.Enum.Priority;
import com.yashdev.helpdesk.helpdesk.Enum.Status;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateTicketRequest {

    private Long id;

    private String summary;

    private String description;

    private String category;

    private Priority priority;

    private Status status;
}
