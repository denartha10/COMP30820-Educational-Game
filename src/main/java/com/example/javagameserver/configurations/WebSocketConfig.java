package com.example.javagameserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration // This indicates that it is a spring configuration class
@EnableWebSocketMessageBroker // This enables a websocket handler backed by a message broker. What is a message broker? what is a handler?
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
   @Override
   public void configureMessageBroker(MessageBrokerRegistry config){
       config.enableSimpleBroker("/topic"); //simple broker is a memory based storage
       config.setApplicationDestinationPrefixes("/app"); // this designates /app as the prefix for messages that are bound ofr methods annotated with @MessageMapping
       //for example /app/hello is the endpoint for GreetingController.greeting() method
   }

   @Override
   public void registerStompEndpoints(StompEndpointRegistry registry){
       registry.addEndpoint("/gs-guide-websocket"); //registers gs-guide-websocket as the endpoint for websocket connection
   }
}
