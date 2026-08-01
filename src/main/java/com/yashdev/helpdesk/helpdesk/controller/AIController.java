package com.yashdev.helpdesk.helpdesk.controller;


import com.yashdev.helpdesk.helpdesk.service.AiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ai")
@RequiredArgsConstructor
public class AIController {

    private final AiService aiService;

    @GetMapping
    public ResponseEntity<String>getResponse(@RequestBody  String query, @RequestHeader String ConversationId){

        return ResponseEntity.ok(aiService.getResponseFromAssistant(query,ConversationId));

    }

}
