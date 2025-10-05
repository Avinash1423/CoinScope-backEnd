package com.crypto.backend.AiChatBot;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.neo4j.Neo4jChatMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;

@Controller
public class AiConfiguration {

    @Autowired
    Neo4jChatMemoryRepository neo4jChatMemoryRepository;

    @Bean
    public ChatMemory chatMemory(){

        return MessageWindowChatMemory.builder().chatMemoryRepository(neo4jChatMemoryRepository).maxMessages(10).build();
    }

   @Bean
    public ChatClient chatClient(ChatClient.Builder builder, ChatMemory chatMemory){

        return builder.defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build()).build();


   }



}
