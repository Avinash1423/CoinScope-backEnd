package com.crypto.backend.AiChatBot;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/backend")
@CrossOrigin(origins = "http://localhost:5173")
public class CryptoChat {

    @Autowired
    ChatClient chatClient;

//    @Autowired
//    ParseAndRender parseAndRender;

    @PostMapping("/request")
    public String AiResponse(@RequestBody String request){


        String system= """
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

        try {



            String response= chatClient.prompt().system(system).user(request).call().content();

            return response;
                    //parseAndRender.processInput(response);


        }catch( Exception e) {


               System.out.println(e.getMessage());
        }

        return  "error";
        }


    }




