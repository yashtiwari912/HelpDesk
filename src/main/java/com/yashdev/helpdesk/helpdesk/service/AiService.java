package com.yashdev.helpdesk.helpdesk.service;


import com.yashdev.helpdesk.helpdesk.tools.TicketDatabaseTool;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class AiService {
    private final ChatClient chatClient;

    private final TicketDatabaseTool ticketDatabaseTool;

    @Value("classpath:/helpdesk-system.st")
    private Resource systemPromptResource;

    public String getResponseFromAssistant(String query,String conversationId){

        //basice call to llm
           return  this.chatClient
                    .prompt()
                   .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, conversationId))
                    .tools(ticketDatabaseTool)
                    .system(systemPromptResource)
                    .user(query)
                    .call()
                    .content();
    }
}
