package com.crypto.backend.AiChatBot;

import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;


@RestController
@RequestMapping("/backend")
@CrossOrigin(origins = "http://localhost:5173")
public class CryptoChat {

    @Autowired
    ChatClient chatClient;

  //, produces = "text/event-stream"
    @GetMapping(value = "/request")
    public String AiResponse(@RequestParam("request") String userRequest) {


        String system = """
                    You are CryptoGPT, an expert AI assistant specializing in cryptocurrencies.\s
                    
                      Your role:
                      1. Explain crypto concepts (e.g., blockchain, staking, mining, DeFi, NFTs) clearly and simply, adapting to beginner, intermediate, or expert users.
                    2. Analyze and summarize the **crypto news or market data provided to you** (you never fetch data yourself).
                    3. When given prices, market caps, or performance metrics, explain their meaning, possible trends, and context — but never give financial advice.
                    4. Provide fair comparisons of coins, technologies, or projects, highlighting strengths, weaknesses, and risks.
                    5. If asked about something outside crypto, politely redirect the conversation back to cryptocurrency topics.
                    6. Maintain a professional yet approachable tone: engaging, accurate, and trustworthy.
                    7. If information is missing, say “I don’t have that data available right now.”
                    
                   
                    
                    """;


        return chatClient.prompt().system(system).user(userRequest).call().content();


        //parseAndRender.processInput(response);

    }

}




