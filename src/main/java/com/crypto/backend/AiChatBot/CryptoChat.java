package com.crypto.backend.AiChatBot;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class CryptoChat {

    @Autowired
    ChatClient chatClient;

    @PostMapping("/request")
    public String AiResponse(String request){

        chatClient.prompt().system().user().call().content()

    }



}
