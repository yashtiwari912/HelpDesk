package com.yashdev.helpdesk.helpdesk.dto;


import com.yashdev.helpdesk.helpdesk.Enum.Priority;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CreateTicketRequest {

    private String email;

    private String summary;

    private String description;

    private String category;

    private Priority priority;

}
