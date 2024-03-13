package com.example.javagameserver.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

// This indicates that it is a spring configuration class.
@Configuration
// This enables a websocket handler backed by a message broker.
// A message broker is a component responsible for routing messages between clients and handling
// communication between them. It facilitates the exchange of messages between different parts of
// an application or between different applications.
@EnableWebSocketMessageBroker

// implements the WebSocketMessageBrokerConfigurer interface, which provides methods for configuring
// WebSocket-related settings.

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
